package br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto;

import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AlbumDTO {

    private Long id;
    private String title;
    private Integer year;
    private Gender gender;
    private String artist;

}
