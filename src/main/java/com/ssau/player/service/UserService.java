package com.ssau.player.service;

import com.ssau.player.entity.UserEntity;
import com.ssau.player.exception.UserEmailAlreadyExistException;
import com.ssau.player.exception.UserNotFoundException;
import com.ssau.player.model.User;
import com.ssau.player.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void registration(UserEntity user) throws UserEmailAlreadyExistException {
        if(userRepo.findUserByEmail(user.getEmail()) != null) {
            throw new UserEmailAlreadyExistException("Пользователь с таким email уже существует");
        }
        userRepo.save(user);
    }


    public User getOne(String id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public String delete(String id){
        userRepo.deleteById(id);
        return id;
    }
}
