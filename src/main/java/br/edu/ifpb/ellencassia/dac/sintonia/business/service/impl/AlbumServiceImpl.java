package br.edu.ifpb.ellencassia.dac.sintonia.business.service.impl;

import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.AlbumDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.business.service.AlbumService;
import br.edu.ifpb.ellencassia.dac.sintonia.business.service.ConvertServiceDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Gender;
import br.edu.ifpb.ellencassia.dac.sintonia.model.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ConvertServiceDTO convertServiceDTO;

    public AlbumDTO createAlbum(AlbumDTO albumDTO) {
        Album album = convertServiceDTO.convertAlbumDtoToAlbum(albumDTO);
        Gender gender = Gender.valueOf(String.valueOf(albumDTO.getGender()));
        album.setGender(gender);
        album = albumRepository.save(album);
        return convertServiceDTO.convertAlbumToAlbumDto(album);
    }

    public List<AlbumDTO> getAllAlbums() {
        List<AlbumDTO> albumsDTO = new ArrayList<>();
        List<Album> albums = albumRepository.findAll();
        for (Album album : albums) {
            AlbumDTO albumDTO = convertServiceDTO.convertAlbumToAlbumDto(album);
            albumsDTO.add(albumDTO);
        }
        return albumsDTO;
    }

    public AlbumDTO removeAlbum(Long id) {
        Album album = albumRepository.findById(id).orElse(null);
        if (album != null) {
            albumRepository.delete(album);
            return convertServiceDTO.convertAlbumToAlbumDto(album);
        }
        return null;
    }

    public AlbumDTO updateAlbum(Long id, AlbumDTO albumDto) {
        Album albumConvert = albumRepository.findById(id).orElse(null);
    
        if (albumConvert != null) {
            albumConvert.setYear(albumDto.getYear());
            albumConvert.setTitle(albumDto.getTitle());
            albumConvert.setArtist(albumDto.getArtist());
            Gender gender = Gender.valueOf(String.valueOf(albumDto.getGender()));
            albumConvert.setGender(gender);
            albumConvert = albumRepository.save(albumConvert);
            return convertServiceDTO.convertAlbumToAlbumDto(albumConvert);
        }
        return null;
    }
}
