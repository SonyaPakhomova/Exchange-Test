package com.example.overonix.core.controller;

import com.example.overonix.core.dto.CurrencyDto;
import com.example.overonix.core.dto.mapper.ConversionDtoMapper;
import com.example.overonix.core.dto.mapper.CurrencyDtoMapper;
import com.example.overonix.core.model.Conversion;
import com.example.overonix.core.model.Currency;
import com.example.overonix.core.service.ConversionService;
import com.example.overonix.core.service.CurrencyService;
import com.example.overonix.core.util.HttpClient;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class CurrencyController {
    private HttpClient httpClient;
    private CurrencyService currencyService;
    private CurrencyDtoMapper currencyDtoMapper;
    private ConversionDtoMapper conversionDtoMapper;
    private ConversionService conversionService;
    private static final Logger logger = LogManager.getLogger(CurrencyController.class);

    @GetMapping("/get_for_code")
    public CurrencyDto getExchangeRatesForCurrencies(@RequestParam String baseCode) throws IllegalAccessException {
        logger.info("getExchangeRatesForCurrencies method in class CurrencyController was called. Code " + baseCode);
        CurrencyDto currencyDto = httpClient.get(baseCode);
        Conversion conversion = conversionService.save(conversionDtoMapper
                .toObject(currencyDto.getConversionDto()));
        Currency currency = currencyDtoMapper.toObject(currencyDto);
        currency.setConversion(conversion);
        currencyService.save(currency);
        return currencyDto;
    }

    @GetMapping("/history")
    public List<CurrencyDto> getExchangeRatesByTimeBetween(@RequestParam String from, @RequestParam String to) {
        logger.info("getExchangeRatesByTimeBetween method in class CurrencyController was called with date from "
                + from + " and date to " + to);
        return currencyService.getByTimeBetween(parseToLocalDate(from), parseToLocalDate(to)).stream()
                .map(currencyDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by_date")
    public CurrencyDto getExchangeRatesByTimeAndBaseCode(@RequestParam String date,
                                                         @RequestParam String baseCode) {
        logger.info("getExchangeRatesByTimeAndBaseCode method in class CurrencyController was called with date "
                + date + " and base code " + baseCode);
        return currencyDtoMapper.toDto(currencyService.getByTimeAndBaseCode(parseToLocalDate(date), baseCode));
    }

    @GetMapping("/by_date_and_baseCode")
    public List<CurrencyDto> getAllByTimeBetweenAndBaseCode(@RequestParam String from, @RequestParam String to,
                                                            @RequestParam String baseCode) {
        logger.info("getAllByTimeBetweenAndBaseCode method in class CurrencyController was called with date from "
                + from + " and date to " + to + " and base code " + baseCode);
        return currencyService.getAllByTimeBetweenAndBaseCode(parseToLocalDate(from),
                parseToLocalDate(to), baseCode).stream().map(currencyDtoMapper::toDto).collect(Collectors.toList());
    }


    private LocalDate parseToLocalDate(String date) {
        return LocalDate.parse(date);
    }
}
