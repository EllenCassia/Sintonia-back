package br.edu.ifpb.ellencassia.dac.sintonia.business.service.impl;

import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.AlbumDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.MusicDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.business.service.ConvertServiceDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.business.service.MusicService;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Gender;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Music;
import br.edu.ifpb.ellencassia.dac.sintonia.model.repository.MusicaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class MusicServiceImplTest {

    // @Autowired
    // MusicService musicService;

    // MusicDTO musicDTO = new MusicDTO(6l,"Girassol", 1994,new Album("Girassol",1995, Gender.POP,"Alceu Valença"),"Alceu Valença");
    // @Test
    // void standardAssertions(){
    //     assertNotEquals("Music updated successfully", musicService.createMusic(musicDTO));
    // }

}
