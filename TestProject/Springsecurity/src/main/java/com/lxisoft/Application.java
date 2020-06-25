package com.lxisoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lxisoft.model.User;
import com.lxisoft.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String...args) throws Exception {
        userRepository.save(new User("ramesh", bCryptPasswordEncoder.encode("ramesh")));
    }
}