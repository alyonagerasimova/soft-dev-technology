package com.ssau.player.controller;

import com.ssau.player.entity.UserEntity;
import com.ssau.player.exception.UserEmailAlreadyExistException;
import com.ssau.player.exception.UserNotFoundException;
import com.ssau.player.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        }catch (UserEmailAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/user")
    public ResponseEntity getOneUser(@RequestParam String id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
