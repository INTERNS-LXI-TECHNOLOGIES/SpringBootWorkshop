package com.lxisoft.ManytoMany;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class ManytoManyApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ManytoManyApplication.class, args);
    }
}

