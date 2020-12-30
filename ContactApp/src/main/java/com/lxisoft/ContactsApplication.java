package com.lxisoft;

import com.lxisoft.controller.ContactController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//@ComponentScan({"model", "service","controller","repository"})
@ComponentScan("com.lxisoft")

//@ComponentScan(basePackages = "com.lxisoft.model","com.lxisoft.repository","com.lxisoft.controller")

public class ContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

}
