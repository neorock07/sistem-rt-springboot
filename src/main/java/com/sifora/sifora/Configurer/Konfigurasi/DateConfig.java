package com.sifora.sifora.Configurer.Konfigurasi;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.sifora.sifora.Configurer.ConverterDate.ConverterStrToDate;

@Configuration
public class DateConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ConverterStrToDate());
        super.addFormatters(registry);
    }
    
    
  
}
