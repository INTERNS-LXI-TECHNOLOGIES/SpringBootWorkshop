package com.lxisoft.springboot;

import com.lxisoft.springboot.entity.Contact;
import com.lxisoft.springboot.entity.Project;
import com.lxisoft.springboot.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ContactApplication extends SpringBootServletInitializer  {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ContactApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class, args);
    }
}
