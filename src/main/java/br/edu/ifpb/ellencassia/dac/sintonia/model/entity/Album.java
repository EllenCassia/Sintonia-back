package br.edu.ifpb.ellencassia.dac.sintonia.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Integer year;

    @Enumerated
    @Column(name = "gender")
    private Gender gender;

    @JsonIgnore
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "album_id")
    @ToString.Exclude
    private List<Music> music = new ArrayList<>();

    @Column(name = "artist")
    private String artist;

    public Album(String title, Integer year, Gender gender, String artist){
        this.artist =artist;
        this.gender = gender;
        this.title = title;
        this.year = year;
    }
}