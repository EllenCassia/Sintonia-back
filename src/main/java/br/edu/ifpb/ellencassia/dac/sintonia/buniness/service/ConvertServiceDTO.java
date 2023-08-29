package br.edu.ifpb.ellencassia.dac.sintonia.buniness.service;

import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.AlbumDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.MusicDTO;
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
        Music music = new Music(musicDTO.getName(), musicDTO.getYear(), musicDTO.getAlbum(),musicDTO.getArtist());
        return music;
    }
}
