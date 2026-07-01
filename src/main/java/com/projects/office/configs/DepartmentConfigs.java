package com.projects.office.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentConfigs {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
