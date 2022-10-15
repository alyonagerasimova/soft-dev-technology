package com.ssau.player.controller;

import com.ssau.player.entity.UserEntity;
import com.ssau.player.exception.UserEmailAlreadyExistException;
import com.ssau.player.exception.UserNotFoundException;
import com.ssau.player.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserDetailsServiceImpl userService;

    @GetMapping("/user")
    public ResponseEntity<?> getOneUser(@RequestParam String username){
        try {
            return ResponseEntity.ok(userService.loadUserByUsername(username));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable String id){
//        try {
//            return ResponseEntity.ok(userService.delete(id));
//        } catch (Exception e){
//            return ResponseEntity.badRequest().body("Error");
//        }
//    }
}
