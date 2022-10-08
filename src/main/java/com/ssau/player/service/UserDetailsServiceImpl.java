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
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserEntity user = userRepo.findUserByUsername(username);
            return UserDetailsImpl.fromUser(user);
        }catch (UsernameNotFoundException e){
            logger.error("User not found by username: " + username);
            return null;
        }
    }
}
