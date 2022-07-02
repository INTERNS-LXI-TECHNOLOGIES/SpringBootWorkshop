package com.lxisoft.springboot.service;

import com.lxisoft.springboot.entity.AppUser;
import com.lxisoft.springboot.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class AppUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final AppUser appUser = appRepo.findById(username).orElse(null);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(appUser.getUsername()).password(appUser.getPassword()).authorities(appUser.getRole()).build();
        return user;
    }
}
