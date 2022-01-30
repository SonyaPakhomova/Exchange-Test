package com.example.overonix.core.dto.mapper;

import com.example.overonix.core.dto.ConversionDto;
import com.example.overonix.core.model.Conversion;
import org.springframework.stereotype.Component;

@Component
public class ConversionDtoMapper {
    public Conversion toObject(ConversionDto conversionDto) {
        Conversion conversion = new Conversion();
        conversion.setAED(conversionDto.getAED());
        conversion.setAMD(conversionDto.getAMD());
        conversion.setAFN(conversionDto.getAFN());
        conversion.setCRC(conversionDto.getCRC());
        conversion.setEGP(conversionDto.getEGP());
        conversion.setETB(conversionDto.getETB());
        conversion.setEUR(conversionDto.getEUR());
        conversion.setGBP(conversionDto.getGBP());
        conversion.setUAH(conversionDto.getUAH());
        conversion.setUSD(conversionDto.getUSD());
        return conversion;
    }
    
    public ConversionDto toDto(Conversion conversion) {
        ConversionDto conversionDto = new ConversionDto();
        conversionDto.setAED(conversion.getAED());
        conversionDto.setAMD(conversion.getAMD());
        conversionDto.setAFN(conversion.getAFN());
        conversionDto.setCRC(conversion.getCRC());
        conversionDto.setEGP(conversion.getEGP());
        conversionDto.setETB(conversion.getETB());
        conversionDto.setEUR(conversion.getEUR());
        conversionDto.setGBP(conversion.getGBP());
        conversionDto.setUAH(conversion.getUAH());
        conversionDto.setUSD(conversion.getUSD());
        return conversionDto;
    }
}
