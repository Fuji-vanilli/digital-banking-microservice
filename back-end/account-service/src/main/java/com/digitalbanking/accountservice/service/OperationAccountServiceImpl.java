package com.digitalbanking.accountservice.service;

import com.digitalbanking.accountservice.Utils.Response;
import com.digitalbanking.accountservice.dto.CreditRequest;
import com.digitalbanking.accountservice.dto.DebitRequest;
import com.digitalbanking.accountservice.dto.TransferRequest;
import com.digitalbanking.accountservice.entitie.BankAccount;
import com.digitalbanking.accountservice.entitie.OperationAccount;
import com.digitalbanking.accountservice.enumerationAccount.OperationType;
import com.digitalbanking.accountservice.repository.BankAccountRepository;
import com.digitalbanking.accountservice.repository.OperationAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OperationAccountServiceImpl implements OperationAccountService{
    private final OperationAccountRepository operationAccountRepository;
    private final BankAccountRepository bankAccountRepository;
    @Override
    public Response credit(CreditRequest request) {
        Optional<BankAccount> accountOptional= bankAccountRepository.findByCode(request.getAccountCode());
        if (accountOptional.isEmpty()) {
            log.error("sorry, there is no account with the code {} into the database", request.getAccountCode());
            return generateResponse(
                    HttpStatus.OK,
                    null,
                    null,
                    "sorry, there is no account with the code: "+request.getAccountCode()+" into the database"
            );
        }
        BankAccount bankAccount= accountOptional.get();
        BigDecimal newBalance= bankAccount.getBalance().add(request.getAmount());

        bankAccount.setBalance(newBalance);
        bankAccount.setUpdateBalance(getDate());

        bankAccountRepository.save(bankAccount);
        log.info("balance account credit with the amount: {} successfully!", request.getAmount());

        OperationAccount operationAccount= OperationAccount.builder()
                .bankAccount(bankAccount)
                .description(request.getDescription())
                .operationDate(getDate())
                .type(OperationType.CREDIT)
                .build();

        operationAccountRepository.save(operationAccount);
        return generateResponse(
                HttpStatus.OK,
                null,
                Map.of(
                        "operationAccount", operationAccount
                ),
                "balance account credit with the amount: "+request.getAccountCode()+" successfully!"
        );
    }

    @Override
    public Response debit(DebitRequest request) {
        return null;
    }

    @Override
    public Response transfer(TransferRequest request) {
        return null;
    }
    private Date getDate() {
        TimeZone timeZone= TimeZone.getDefault();
        Calendar calendar= Calendar.getInstance(timeZone);

        return calendar.getTime();
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
