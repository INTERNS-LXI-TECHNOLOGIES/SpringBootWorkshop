package com.lxisoft.sample;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lxisoft.sample.entity.Comment;
import com.lxisoft.sample.entity.Gender;
import com.lxisoft.sample.entity.MainPost;
import com.lxisoft.sample.entity.Post;
import com.lxisoft.sample.entity.Tag;
import com.lxisoft.sample.entity.User;
import com.lxisoft.sample.entity.UserProfile;
import com.lxisoft.sample.repository.MainPostRepository;
import com.lxisoft.sample.repository.PostRepository;
import com.lxisoft.sample.repository.TagRepository;
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
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private MainPostRepository mainPostRepository;
	
	@Override
	public void run(String... args) throws Exception 
	{
		
		 MainPost mainPost=new MainPost("engagement Party", "my engagement party festive","festive");
		 
		 Tag EngagementEvent = new Tag("EngagementDayEvent"); 
		 Tag MarraigeEvent = new Tag("Marraige festive");
		 Tag LoveFestive = new Tag("LoveFestive");
		 mainPost.getTags().add(EngagementEvent);
		 mainPost.getTags().add(MarraigeEvent);
		 mainPost.getTags().add(LoveFestive);
		 
		 EngagementEvent.getMainPost().add(mainPost);
		 MarraigeEvent.getMainPost().add(mainPost);
		 LoveFestive.getMainPost().add(mainPost);
		 this.mainPostRepository.save(mainPost);
		 
		
		
	}
}
