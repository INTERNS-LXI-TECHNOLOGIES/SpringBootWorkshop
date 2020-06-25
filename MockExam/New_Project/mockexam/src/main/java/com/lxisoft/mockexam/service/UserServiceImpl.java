package com.lxisoft.mockexam.service;

import com.lxisoft.mockexam.entity.Role;
import com.lxisoft.mockexam.entity.User;
import com.lxisoft.mockexam.repo.UserRepo;
import com.lxisoft.mockexam.web.dto.UserRegistrationDto;
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

        User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(),bCryptPasswordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            User user = userRepo.findByEmail(username);
            if (user == null)
            {
                throw new UsernameNotFoundException("Invalid Username or Password");
            }

            return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRoleToAuthorities(user.getRoles()));


    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthorities(Collection<Role> roles)
    {


       return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());


    }
}
