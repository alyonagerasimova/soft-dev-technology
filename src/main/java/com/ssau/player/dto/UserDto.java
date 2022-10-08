package com.ssau.player.dto;

import com.ssau.player.entity.PlaylistEntity;
import com.ssau.player.entity.UserEntity;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String email;
    private String password;

//    public UserEntity toUserEntity(){
//        UserEntity user = new UserEntity();
//        user.setUsername(username);
//        user.setEmail(email);
//        user.setPassword(password);
//        return user;
//    }
//
//    public static UserDto fromUserEntity(UserEntity user){
//        UserDto userDto = new UserDto();
//        userDto.setUsername(user.getUsername());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        return userDto;
//    }
}
