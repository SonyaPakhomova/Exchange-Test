package com.example.overonix.core.service.impl;

import com.example.overonix.core.model.Conversion;
import com.example.overonix.core.repository.ConversionRepository;
import com.example.overonix.core.service.ConversionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConversionServiceImpl implements ConversionService {
    private ConversionRepository conversionRepository;

    @Override
    public Conversion save(Conversion conversion) {
        return conversionRepository.save(conversion);
    }
}
