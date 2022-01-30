package com.example.overonix.core.service.impl;

import com.example.overonix.core.model.Currency;
import com.example.overonix.core.repository.CurrencyRepository;
import com.example.overonix.core.service.CurrencyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class CurrencyServiceImpl implements CurrencyService {
    private CurrencyRepository currencyRepository;

    @Override
    public List<Currency> getAllByBaseCode(String baseCode) {
          return currencyRepository.getAllByBaseCode(baseCode).orElseThrow(() ->
                new RuntimeException("Can't get all currency by base code " + baseCode));
    }

   @Override
    public List<Currency> getByTimeBetween(LocalDate from, LocalDate to) {
        return currencyRepository.getByTimeBetween(from, to).orElseThrow(() ->
                new RuntimeException("Can't get currencies by time between start time " + from
                + " and and time " + to));
    }

    @Override
    public List<Currency> getAllByTimeBetweenAndBaseCode(LocalDate from, LocalDate to, String baseCode) {
        return currencyRepository.getAllByByTimeBetweenAndBaseCode(from, to, baseCode).orElseThrow(() ->
                new RuntimeException("Can't get currencies by time between start time " + from
                        + " and and time " + to + " and base code " + baseCode));
    }

    @Override
    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency getByTimeAndBaseCode(LocalDate date, String baseCode) {
        return currencyRepository.getByTimeAndBaseCode(date, baseCode).orElseThrow(() ->
                new RuntimeException("Can't get currencies by date " + date + " and base code " + baseCode));
    }
}
