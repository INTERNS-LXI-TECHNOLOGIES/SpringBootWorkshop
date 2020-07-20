package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.library.dto.UserDto;
import com.example.library.service.UserService;

@Controller
public class controller {
	
	    private UserService userService;
	 
		/* private RoleService roleService; */
	
	 public controller() {
		 
	 }
	 
	 public controller(UserService userService)
	    {
	        this.userService = userService;
	    }



	    @GetMapping("/start")
	    public ModelAndView getAllStudents() {
	        List<UserDto> users = userService.getAllUser();
	        ModelAndView model = new ModelAndView();
	        model.addObject("users",users);
	        model.setViewName("Index");
	        return model;
	    }
	 
	    @PostMapping("/addUsr")
	    public ModelAndView addUser() 
	    {
	        UserDto usr = new UserDto();
	        ModelAndView model = new ModelAndView();
	        model.addObject("userDto",usr);
	        model.setViewName("addUser");
	        return model;
	    }
 		@PostMapping("/add")
	    public ModelAndView addUser(@RequestBody UserDto userDto) 
	    {
	        UserDto usr = userService.addUser(userDto);
	        ModelAndView model = new ModelAndView();
	        model.addObject("userDto",usr);
	        model.setViewName("addUser");
	        return model;
	    }
	 
	    @PutMapping("/update/{id}")
	    public ModelAndView updateEmployee(@PathVariable(name = "id") Integer id,@RequestBody UserDto userDto) 
	    {
	        UserDto std = userService.updateUser(id, userDto);
	        ModelAndView model = new ModelAndView();
	        model.setViewName("Index");
	        return model;
	    }
	 
	    @DeleteMapping("/delete/{id}")
	    public ModelAndView deleteStudent(@PathVariable(name = "id") Integer userId) {
	        String message = userService.deleteUser(userId);
	        ModelAndView model = new ModelAndView();
	        model.setViewName("Index");
	        return model;
	    }
	
}
