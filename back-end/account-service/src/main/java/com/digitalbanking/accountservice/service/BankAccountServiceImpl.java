package com.digitalbanking.accountservice.service;

import com.digitalbanking.accountservice.Utils.Response;
import com.digitalbanking.accountservice.dto.BankAccountRequest;
import com.digitalbanking.accountservice.entitie.BankAccount;
import com.digitalbanking.accountservice.mapper.BankAccountMapper;
import com.digitalbanking.accountservice.repository.BankAccountRepository;
import com.digitalbanking.accountservice.validator.BankAccountValidator;
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
import java.util.*;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService{
    private final BankAccountRepository repository;
    private final BankAccountMapper bankAccountMapper;
    @Override
    public Response add(BankAccountRequest request) {
        List<String> errors= BankAccountValidator.validate(request);
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
        if (repository.existsByCode(request.getCustomerCode())){
            log.error("bank account already exist on database");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    null,
                    "bank account already exist on database"
            );
        }

        BankAccount bankAccount= bankAccountMapper.mapToBankAccount(request);
        bankAccount.setCode(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(getDateLocal());

        repository.save(bankAccount);

        URI location= ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{code}")
                .buildAndExpand("api/bankAccount/get"+bankAccount.getCode())
                .toUri();

        log.info("new bank account created successfully!");
        return generateResponse(
                HttpStatus.OK,
                location,
                Map.of(
                        "bankAccount", bankAccountMapper.mapToBankAccountResponse(bankAccount)
                ),
                "new bank account created successfully!"
        );
    }

    @Override
    public Response get(String code) {

        Optional<BankAccount> bankAccountOptional= repository.findByCode(code);
        if (bankAccountOptional.isEmpty()) {
            log.error("bank account doesn't exist on the database!");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    null,
                    "bank account doesn't exist on the database!"
            );
        }

        BankAccount bankAccount= bankAccountOptional.get();
        log.info("bank account with the code: "+code+" getted successfully!");
        return generateResponse(
                HttpStatus.OK,
                null,
                Map.of(
                        "bankAccount", bankAccountMapper.mapToBankAccountResponse(bankAccount)
                ),
                "bank account with the code: "+code+" getted successfuly!"
        );
    }

    @Override
    public Response all(int page, int size) {

        Pageable pageable= PageRequest.of(page, size);

        log.info("all bank account with the page: "+page+" and size: "+size+" getted successfully!");
        return generateResponse(
                HttpStatus.OK,
                null,
                Map.of(
                        "contents number", repository.findAll(pageable).getContent().size(),
                        "bankAccounts", repository.findAll(pageable).getContent()
                ),
                "all bank account with the page: "+page+" and size: "+size+" getted successfully!"
        );
    }

    @Override
    public Response delete(String code) {

        if (!repository.existsByCode(code)) {
            log.error("bank account doesn't exist on the database!");
            return generateResponse(
                    HttpStatus.BAD_REQUEST,
                    null,
                    null,
                    "bank account doesn't exist on the database!"
            );
        }

        log.info("bank account with the code! "+code+" deleted successfully!");
        return generateResponse(
                HttpStatus.OK,
                null,
                null,
                "bank account with the code! "+code+" deleted successfully!"
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
    private Date getDateLocal() {
        TimeZone timeZone= TimeZone.getDefault();
        Calendar calendar= Calendar.getInstance(timeZone);

        return calendar.getTime();
    }
}
