package com.digitalbanking.customerservice.service;

import com.digitalbanking.customerservice.Utils.Response;
import com.digitalbanking.customerservice.dto.CustomerMapper;
import com.digitalbanking.customerservice.dto.CustomerRequest;
import com.digitalbanking.customerservice.model.Customer;
import com.digitalbanking.customerservice.repository.CustomerRepository;
import com.digitalbanking.customerservice.validator.CustomerValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    @Override
    public Response add(CustomerRequest request) {
        List<String> errors= CustomerValidator.validate(request);
        if (!errors.isEmpty()){
            log.error("some request not found");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    Map.of(
                            "errors", errors
                    ),
                    "some request not found"
            );
        }
        if (customerRepository.existsByCode(request.getCode())){
            log.error("customer already exist on database");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    null,
                    "customer already exist on database"
            );

        }
        Customer customer= customerMapper.mapToCustomer(request);
        customer.setCreatedDate(new Date());

        customerRepository.save(customer);
        log.info("new customer added successfully!");

        URI location= ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{code}")
                .buildAndExpand("api/customer"+customer.getCode())
                .toUri();

        return generateResponse(
                HttpStatus.OK,
                location,
                Map.of(
                        "customer", customerMapper.mapToCustomerResponse(customer)
                ),
                "new customer created successfully!"
        );
    }

    @Override
    public Response get(String code) {
        Optional<Customer> customerOptional= customerRepository.findByCode(code);

        if (customerOptional.isEmpty()) {
            log.error("customer doesn't exist on the database!");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    null,
                    "customer doesn't exist on the database!"
            );
        }

        Customer customer= customerOptional.get();
        log.info("customer with the code: "+code+" getted successfully!");
        return generateResponse(
                HttpStatus.OK,
                null,
                Map.of(
                        "customer", customerMapper.mapToCustomerResponse(customer)
                ),
                "customer with the code: "+code+" getted successfuly!"
        );
    }

    @Override
    public Response all(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);

        log.info("all customer with the page: "+page+" and size: "+size+" getted successfully!");
        return generateResponse(
                HttpStatus.OK,
                null,
                Map.of(
                        "contents number", customerRepository.findAll(pageable).getContent().size(),
                        "customers", customerRepository.findAll(pageable).getContent()
                ),
                "all customer with the page: "+page+" and size: "+size+" getted successfully!"
        );
    }

    @Override
    public Response delete(String code) {
        if (!customerRepository.existsByCode(code)) {
            log.error("customer doesn't exist on the database!");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    null,
                    "customer doesn't exist on the database!"
            );
        }

        log.info("customer with the code! "+code+" deleted successfully!");
        return generateResponse(
                HttpStatus.OK,
                null,
                null,
                "customer with the code! "+code+" deleted successfully!"
        );
    }
    private Response generateResponse(HttpStatus status, URI location, Map<?, ?> data, String message){
        return Response.builder()
                .timeStamp(LocalDateTime.now())
                .status(status)
                .statusCode(status.value())
                .location(location)
                .data(data)
                .message(message)
                .build();
    }
}
