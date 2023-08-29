package br.edu.ifpb.ellencassia.dac.sintonia.model.entity;

import jakarta.persistence.*;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "musica")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "year")
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @Column(name = "artist")
    private String artist;

    public Music(String name, Integer year, Album album, String artist) {
        this.artist = artist;
        this.year = year;
        this.name = name;
        this.album = album;
    }

}