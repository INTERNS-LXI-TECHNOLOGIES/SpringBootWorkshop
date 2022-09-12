package com.lxisoft.vegetablestore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.lxisoft")
public class WebConfig implements WebMvcConfigurer {

    @Bean(name = "multipartResolver")

    public CommonsMultipartResolver multipartResolver() {

       CommonsMultipartResolver multipartResolver= new CommonsMultipartResolver();
       multipartResolver.setMaxUploadSize(1000000);
       return multipartResolver;
    }

}
