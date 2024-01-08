package com.sifora.sifora.Configurer.ConverterDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class ConverterStrToDate implements Converter<String, Date>{
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(
        "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    );

    @Override
    @Nullable
    public Date convert(String time) {
        try {
            return dateFormat.parse(time);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format", e);
        }
    }
    
}
