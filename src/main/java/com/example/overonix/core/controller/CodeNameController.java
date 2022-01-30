package com.example.overonix.core.controller;

import com.example.overonix.core.dto.CodeNameDto;
import com.example.overonix.core.util.HttpClient;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CodeNameController {
    private HttpClient httpClient;
    private static final Logger logger = LogManager.getLogger(CodeNameController.class);

    @GetMapping("/all_available")
    public CodeNameDto allAvailableCurrencyCodes() {
        logger.info("gllAvailableCurrencyCodes method in class CurrencyController was called.");
        return httpClient.view();
    }
}
