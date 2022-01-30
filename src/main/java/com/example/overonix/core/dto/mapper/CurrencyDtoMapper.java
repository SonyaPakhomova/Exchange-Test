package com.example.overonix.core.dto.mapper;

import com.example.overonix.core.dto.CurrencyDto;
import com.example.overonix.core.model.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDtoMapper {
    public Currency toObject(CurrencyDto currencyDto) {
        Currency currency = new Currency();
        currency.setBaseCode(currencyDto.getBaseCode());
        currency.setTimeLastUpdateUtc(currencyDto.getTimeLastUpdateUtc());
        currency.setTimeNextUpdateUtc(currencyDto.getTimeNextUpdateUtc());
        currency.setResult(currencyDto.getResult());
        return currency;
    }

    public CurrencyDto toDto(Currency currency) {
        CurrencyDto currencyDto = new CurrencyDto();
        currencyDto.setBaseCode(currency.getBaseCode());
        currencyDto.setTimeLastUpdateUtc(currency.getTimeLastUpdateUtc());
        currencyDto.setTimeNextUpdateUtc(currency.getTimeNextUpdateUtc());
        currencyDto.setResult(currency.getResult());
        return currencyDto;
    }
}
