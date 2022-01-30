package com.example.overonix.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyDto {
    @JsonProperty("time_last_update_utc")
    private String timeLastUpdateUtc;
    private String result;
    @JsonProperty("time_next_update_utc")
    private String timeNextUpdateUtc;
    @JsonProperty("base_code")
    private String baseCode;
    @JsonProperty("conversion_rates")
    private ConversionDto conversionDto;
}
