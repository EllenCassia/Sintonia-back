package br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto;

import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import jakarta.persistence.*;
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

    private Album album;

    private String artist;

}
