package com.lxisoft.MockExam.service;

import com.lxisoft.MockExam.entity.Role;
import com.lxisoft.MockExam.entity.User;
import com.lxisoft.MockExam.repository.UserRepo;
import com.lxisoft.MockExam.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {

        User user = new User(registrationDto.getName(),bCryptPasswordEncoder.encode(registrationDto.getPassword()),Arrays.asList(new Role("User")));
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            User user = userRepo.findByName(username);
            if (user == null)
            {
                throw new UsernameNotFoundException("Invalid Username or Password");
            }

            return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(),mapRoleToAuthorities(user.getRoles()));


    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(Collection<Role> roles)
    {


       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());


    }
}
