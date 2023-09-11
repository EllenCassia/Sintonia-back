package br.edu.ifpb.ellencassia.dac.sintonia.business.service;

import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.AlbumDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.MusicDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Music;
import br.edu.ifpb.ellencassia.dac.sintonia.model.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceDTO {

    @Autowired
    MusicaRepository musicaRepository;


    public Album convertAlbumDtoToAlbum(AlbumDTO albumDTO){
        Album album = new Album(albumDTO.getTitle(), albumDTO.getYear(), albumDTO.getGender(), albumDTO.getArtist());
        return album;
    }
    
    public Music convertMusicDtoToMusic(MusicDTO musicDTO){
        Music music = new Music(musicDTO.getName(), musicDTO.getYear(), musicDTO.getArtist());
        
        if (musicDTO.getAlbum() != null) {
            Album album = convertAlbumDtoToAlbum(musicDTO.getAlbum());
            music.setAlbum(album);
        }
        return music;
    }
    
    public MusicDTO convertMusicToMusicDto(Music music) {
        MusicDTO musicDTO = new MusicDTO();
        musicDTO.setId(music.getId());
        musicDTO.setName(music.getName());
        musicDTO.setYear(music.getYear());
        musicDTO.setArtist(music.getArtist());
        
        if (music.getAlbum() != null) {
            AlbumDTO albumDTO = convertAlbumToAlbumDto(music.getAlbum());
            musicDTO.setAlbum(albumDTO);
        }
        return musicDTO;
    }
    
    public AlbumDTO convertAlbumToAlbumDto(Album album) {
        AlbumDTO albumDTO = new AlbumDTO(album.getId(), album.getTitle(), album.getYear(), album.getGender(), album.getArtist());
        return albumDTO;
    }
}
