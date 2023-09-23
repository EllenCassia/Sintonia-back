package br.edu.ifpb.ellencassia.dac.sintonia.business.service.impl;

import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.MusicDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.business.service.ConvertServiceDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.business.service.MusicService;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Music;
import br.edu.ifpb.ellencassia.dac.sintonia.model.repository.AlbumRepository;
import br.edu.ifpb.ellencassia.dac.sintonia.model.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicaRepository musicRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ConvertServiceDTO convertServiceDTO;

    public MusicDTO createMusic(MusicDTO musicDTO) {
        Long albumId = musicDTO.getAlbum().getId();
        Album album = albumRepository.findById(albumId).orElse(null);
    
        if (album != null) {
            Music music = new Music(musicDTO.getName(),musicDTO.getYear(),musicDTO.getArtist());
            music.setAlbum(album); 
            music = musicRepository.save(music);
            return convertServiceDTO.convertMusicToMusicDto(music);
        } else {
            return null;
        }
    }
    

    public List<MusicDTO> getAllMusics() {
        List<MusicDTO> musicDTOList = new ArrayList<>();
        List<Music> musics = musicRepository.findAll();

        for (Music music : musics) {
            MusicDTO musicDTO = convertServiceDTO.convertMusicToMusicDto(music);
            musicDTOList.add(musicDTO);
        }
        return musicDTOList;
    }

    public MusicDTO removeMusic(Long id) {
        Music music = musicRepository.findById(id).orElse(null);
        if (music != null) {
            musicRepository.delete(music);
            return convertServiceDTO.convertMusicToMusicDto(music);
        }
        return null; 
    }

    public MusicDTO updateMusic(Long id, MusicDTO musicDto) {
        Music musicToUpdate = musicRepository.findById(id).orElse(null);
    
        if (musicToUpdate != null) {
            musicToUpdate.setYear(musicDto.getYear());
            musicToUpdate.setName(musicDto.getName());
            
            if (musicDto.getAlbum() != null) {
                Long albumId = musicDto.getAlbum().getId();
                Album existingAlbum = albumRepository.findById(albumId).orElse(null);
    
                if (existingAlbum != null) {
                    musicToUpdate.setAlbum(existingAlbum);
                } else {
                    Album newAlbum = convertServiceDTO.convertAlbumDtoToAlbum(musicDto.getAlbum());
                    Album savedAlbum = albumRepository.save(newAlbum);
                    musicToUpdate.setAlbum(savedAlbum);
                }
            } else {
                musicToUpdate.setAlbum(null); 
            }
            
            musicToUpdate.setArtist(musicDto.getArtist());
            musicToUpdate = musicRepository.save(musicToUpdate);
    
            return convertServiceDTO.convertMusicToMusicDto(musicToUpdate);
        }
        return null; 
    }


    public List<MusicDTO> getMusicByAlbum(Long albumId) {
        List<MusicDTO> musicDTOList = new ArrayList<>();
        List<Music> musicList = musicRepository.findByAlbumId(albumId);

        for (Music music : musicList) {
            MusicDTO musicDTO = convertServiceDTO.convertMusicToMusicDto(music);
            musicDTOList.add(musicDTO);
        }
        return musicDTOList;
    }
}
