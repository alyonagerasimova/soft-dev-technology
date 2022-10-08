package com.ssau.player.service;

import com.ssau.player.entity.UserEntity;
import com.ssau.player.repository.UserRepo;
import com.ssau.player.security.AuthTokenFilter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return UserDetailsImpl.fromUser(user);
    }
}
