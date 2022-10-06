package com.ssau.player.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "songName", nullable = false)
    private String songName;

    @Column(name = "cover")
    private String cover;

    @Column(name = "duration", nullable = false)
    private double duration;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private PlaylistEntity playlist;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistEntity artist;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumEntity album;
}
