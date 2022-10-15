package com.ssau.player.repository;

import com.ssau.player.entity.Role;
import com.ssau.player.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {
    UserEntity findByEmail(String email);
    boolean existsByEmail(String email);
    UserEntity findByUsername(String username);
    Role findByRole(Role role);
}
