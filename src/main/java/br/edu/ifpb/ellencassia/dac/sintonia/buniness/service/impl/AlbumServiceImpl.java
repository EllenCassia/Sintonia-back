package br.edu.ifpb.ellencassia.dac.sintonia.buniness.service.impl;

import br.edu.ifpb.ellencassia.dac.sintonia.buniness.service.AlbumService;
import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.AlbumDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.buniness.service.ConvertServiceDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Gender;
import br.edu.ifpb.ellencassia.dac.sintonia.model.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ConvertServiceDTO convertServiceDTO;

    public ResponseEntity<String> createAlbum(AlbumDTO albumDTO) {
        Album album = convertServiceDTO.convertAlbumDtoToAlbum(albumDTO);
        Gender gender = Gender.valueOf(String.valueOf(albumDTO.getGender()));
        album.setGender(gender);
        try {
            albumRepository.save(album);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create the album", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Album created successfully", HttpStatus.CREATED);
    }

    public List<AlbumDTO> getAllAlbuns() {
        List<AlbumDTO> albumsDTO = new ArrayList<>();
        List<Album> albums = albumRepository.findAll();
        for (Album album : albums) {
            AlbumDTO albumDTO = new AlbumDTO(album.getId(), album.getTitle(), album.getYear(), album.getGender(), album.getArtist());
            albumsDTO.add(albumDTO);
        }
        return albumsDTO;
    }

    public ResponseEntity<String> removeAlbum(Long id) {
        Album album = albumRepository.findById(id).orElse(null);
        try {
            albumRepository.delete(album);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to remove the album", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Album removed successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> updateAlbum(AlbumDTO albumDto) {
        Album albumConvert = albumRepository.findById(albumDto.getId()).orElse(null);

        if (albumConvert != null) {
            albumConvert.setYear(albumDto.getYear());
            albumConvert.setTitle(albumDto.getTitle());
            albumConvert.setArtist(albumDto.getArtist());
            Gender gender = Gender.valueOf(String.valueOf(albumDto.getGender()));
            albumConvert.setGender(gender);
        }
        try {
            albumRepository.save(albumConvert);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update the album", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Album updated successfully", HttpStatus.OK);
    }
}
