package br.edu.ifpb.ellencassia.dac.sintonia.business.dto;

import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlbumDTO {

    private Long id;
    private String title;
    private Integer year;
    private Gender gender;
    private String artist;

}
