package com.example.overonix.core.service;

import com.example.overonix.core.model.Currency;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyService {
    List<Currency> getAllByBaseCode(String baseCode);

    List<Currency> getAllByTimeBetweenAndBaseCode(LocalDate from, LocalDate to, String baseCode);

    Currency save(Currency currency);

    List<Currency> getByTimeBetween(LocalDate from, LocalDate to);

    Currency getByTimeAndBaseCode(LocalDate date, String baseCode);
}
