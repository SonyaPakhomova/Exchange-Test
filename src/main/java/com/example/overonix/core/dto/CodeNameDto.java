package com.example.overonix.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CodeNameDto {
    private String result;
    @JsonProperty("supported_codes")
    private List<Object[]> supportedCodes;
}
