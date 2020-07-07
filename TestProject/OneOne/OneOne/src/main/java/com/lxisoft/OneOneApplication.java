package com.lxisoft;

import com.lxisoft.book.Address;
import com.lxisoft.book.Library;
import com.lxisoft.book.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class OneOneApplication implements CommandLineRunner {
	private final LibraryRepository libraryRepository = null;

    public static void main(String[] args) {
        SpringApplication.run(OneOneApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Create a couple of Library and Address
        libraryRepository.save(new Library("Library 1", new Address("Street 1", "Zip 1")));
        libraryRepository.save(new Library("Library 2", new Address("Street 2", "Zip 2")));
    }
}
