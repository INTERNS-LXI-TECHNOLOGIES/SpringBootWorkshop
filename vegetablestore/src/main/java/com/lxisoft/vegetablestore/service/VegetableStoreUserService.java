package com.lxisoft.vegetablestore.service;

import com.lxisoft.vegetablestore.entity.VegetableStoreUser;
import com.lxisoft.vegetablestore.repository.VegetableStoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class VegetableStoreUserService implements UserDetailsService {

    @Autowired
    VegetableStoreUserRepository vegetableStoreUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final VegetableStoreUser storeUser = vegetableStoreUserRepository.findById(username).orElse(null);
        if (storeUser == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(storeUser.getUsername()).password(storeUser.getPassword()).authorities(storeUser.getRole()).build();
        return user;
    }
}
