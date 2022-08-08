package com.lxisoft.dictionary.service;
import com.lxisoft.dictionary.entity.DictionaryUser;
import com.lxisoft.dictionary.repository.DictionaryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DictionaryDetailsServiceImpl implements UserDetailsService {

    @Autowired
    DictionaryUserRepository dictionaryUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final DictionaryUser dictionaryUser = dictionaryUserRepository.findById(username).orElse(null);
        if (dictionaryUser == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(dictionaryUser.getUsername()).password(dictionaryUser.getPassword()).authorities(dictionaryUser.getRole()).build();
        return user;
    }
}
