package com.ssau.player.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;


    @OneToMany(mappedBy = "user")
    private List<PlaylistEntity> playlists;

    public UserEntity(String email, String encode) {
        this.email = email;
        this.password = encode;
//        this.role = roleUser;
    }

    public Role getRole() {
        return Role.ROLE_USER;
    }
}
