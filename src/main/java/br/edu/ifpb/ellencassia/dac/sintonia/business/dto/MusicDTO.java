package br.edu.ifpb.ellencassia.dac.sintonia.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MusicDTO {

    private Long id;

    private String name;

    private Integer year;

    private AlbumDTO album;

    private String artist;
    
}
