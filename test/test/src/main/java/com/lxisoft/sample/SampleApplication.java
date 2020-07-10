package com.lxisoft.sample;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lxisoft.sample.entity.Gender;
import com.lxisoft.sample.entity.User;
import com.lxisoft.sample.entity.UserProfile;
import com.lxisoft.sample.repository.UserProfileRepository;
import com.lxisoft.sample.repository.UserRepository;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Override
	public void run(String... args) throws Exception 
	{
		User user =new User();
		user.setName("sanfar");
		user.setEmail("sanfucse123@gmail.com");
		
		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("palakkad");
		userProfile.setBirthOfDate(LocalDate.of(1997, 07, 02));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNumber("7907148292");
		
		user.setUserProfile(userProfile);
		userProfile.setUser(user);
		userRepository.save(user);
	}
}
