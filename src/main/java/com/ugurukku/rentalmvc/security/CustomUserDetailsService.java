package com.ugurukku.rentalmvc.security;

import com.ugurukku.rentalmvc.exceptions.UserNotFoundException;
import com.ugurukku.rentalmvc.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository
                .findByEmail(email)
                .map(CustomUserDetails::new)
                .orElseThrow(UserNotFoundException::new);
    }
}
