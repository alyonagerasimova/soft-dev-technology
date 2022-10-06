package com.ssau.player.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "albums")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "albumName")
    private String albumName;

    @Column(name = "cover")
    private String cover;

    @OneToMany(mappedBy = "album")
    private List<SongEntity> songs;
}
