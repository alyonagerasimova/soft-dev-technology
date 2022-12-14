package com.ssau.player.controller;

import com.ssau.player.dto.JwtDto;
import com.ssau.player.dto.LoginDto;
import com.ssau.player.dto.UserDto;
import com.ssau.player.entity.Role;
import com.ssau.player.entity.UserEntity;
import com.ssau.player.repository.UserRepo;
import com.ssau.player.security.JwtUtils;
import com.ssau.player.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String role = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .findFirst().orElse(null);
        return ResponseEntity.ok(new JwtDto(
                jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                role));
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<?> registerUser(@RequestBody UserDto user) {
        if (userRepo.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body("???????????????????????? ?? ?????????? email ?????? ????????????????????");
        }
        UserEntity userEntity = new UserEntity(
                user.getUsername(),
                user.getEmail(),
                encoder.encode(user.getPassword()),
                Role.ROLE_USER);
        userRepo.save(userEntity);
        return ResponseEntity.ok("???????????????????????? ?????????????? ????????????????");

    }
}
