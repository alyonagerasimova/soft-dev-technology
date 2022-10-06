package com.ssau.player.repository;

import com.ssau.player.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {
    UserEntity findUserByEmail(String email);
}
