package com.pabbasadwika.module5.springSecurity.service;

import com.pabbasadwika.module5.springSecurity.exception.ResourceNotFoundException;
import com.pabbasadwika.module5.springSecurity.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       return userRepository.findByEmail(username)
               .orElseThrow(() -> new ResourceNotFoundException("User with email"+ username + "not found"));

    }
}
