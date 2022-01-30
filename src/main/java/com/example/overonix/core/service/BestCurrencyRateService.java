package com.example.overonix.core.service;

import com.example.overonix.core.dto.CurrencyDto;

import java.lang.reflect.Field;

public interface BestCurrencyRateService {
    Field[] chooseBestRate(CurrencyDto currencyDto, FreeCurrencyRateDto freeCurrencyRateDto) throws IllegalAccessException;
}
