package com.example.overonix.core.util;

import com.example.overonix.core.dto.CodeNameDto;
import com.example.overonix.core.dto.CurrencyDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.IOException;

@AllArgsConstructor
@Component
public class HttpClient {
    private final static String URL = "https://v6.exchangerate-api.com/v6/8fb8dc174f3300e58abb07fc/";
 //   private final static String URL_EXCHANGE = "https://freecurrencyapi.net/api/v2/latest?apikey=e94fa670-820f-11ec-a715-83ffcf0a8ae0?base_currency=";
    private final ObjectMapper objectMapper = new ObjectMapper();

    {
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public CurrencyDto get(String baseCode) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(URL + "latest/" + baseCode);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                return objectMapper.readValue(response.getEntity().getContent(), CurrencyDto.class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to perform request", e);
        }
    }

    public CodeNameDto view() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(URL + "codes");
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                return objectMapper.readValue(response.getEntity().getContent(), CodeNameDto.class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to perform request", e);
        }
    }
   /* public FreeCurrencyRateDto getLatestRatesFromExchange(String base) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(URL_EXCHANGE + base);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                return objectMapper.readValue(response.getEntity().getContent(), FreeCurrencyRateDto.class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to perform request", e);
        }
    }*/
}
