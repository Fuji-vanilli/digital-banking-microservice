package com.digitalbanking.accountservice.restClient;

import com.digitalbanking.accountservice.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebClientGetter {
    private final WebClient.Builder webClient;

    public Customer getCustomer(String code) {
        final CompletableFuture<String> dataFuture = webClient.build().get()
                .uri("http://localhost:5200/api/customer/get/" + code)
                .retrieve()
                .bodyToMono(String.class)
                .toFuture();

        JSONObject data;
        String dataBrute= "";
        Customer customer;

        try {
            dataBrute= dataFuture.get();
            JSONObject jsonObject= new JSONObject(dataBrute);

            data= jsonObject.getJSONObject("data").getJSONObject("customer");
            String dateString= data.getString("createdDate");

            customer= Customer.builder()
                    .code(data.getString("code"))
                    .email(data.getString("email"))
                    .name(data.getString("name"))
                    .build();

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Error to fetch the customer microservice!");
        } catch (JSONException e) {
            throw new RuntimeException("Error to deserialize json object");
        }
        return customer;
    }
    public Customer getDefaultCustomer(String code, Exception exception) {
        return Customer.builder()
                .email("not available")
                .name("not available")
                .build();
    }
}
