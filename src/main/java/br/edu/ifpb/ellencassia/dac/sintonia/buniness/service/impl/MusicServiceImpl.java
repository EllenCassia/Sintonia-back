package br.edu.ifpb.ellencassia.dac.sintonia.buniness.service.impl;

import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.MusicDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.buniness.service.ConvertServiceDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.buniness.service.MusicService;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Music;
import br.edu.ifpb.ellencassia.dac.sintonia.model.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicaRepository musicRepository;

    @Autowired
    ConvertServiceDTO convertServiceDTO;

    public ResponseEntity<String> createMusic(MusicDTO musicDTO) {
        try {
            Music music = convertServiceDTO.convertMusicDtoToMusic(musicDTO);
            musicRepository.save(music);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating music");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Music created successfully");
    }
    public List<MusicDTO> getAllMusics(){
        List<MusicDTO> musicDTO = new ArrayList<>();
        List<Music> musics = musicRepository.findAll();
        for(Music music: musics){
            MusicDTO musicdto = new MusicDTO(music.getId(), music.getName(), music.getYear(), music.getAlbum(), music.getArtist());
            musicDTO.add(musicdto);
        }
        return musicDTO;
    }

    public ResponseEntity<String> removeMusic(Long id) {
        Music music = musicRepository.findById(id).orElse(null);
        try {
            musicRepository.delete(music);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Music not found");
        }
        return ResponseEntity.ok("Music removed successfully");
    }

    public ResponseEntity<String> updateMusic(MusicDTO musicDto) {
        Music musicConvert = musicRepository.findById(musicDto.getId()).orElse(null);

        if (musicConvert != null) {
            musicConvert.setYear(musicDto.getYear());
            musicConvert.setName(musicDto.getName());
            musicConvert.setAlbum(musicDto.getAlbum());
            musicConvert.setArtist(musicDto.getArtist());
        }
            try {
                musicRepository.save(musicConvert);
            }catch (Exception e){
                return new ResponseEntity<>("Music not found", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        return new ResponseEntity<>("Music updated successfully", HttpStatus.CREATED);
    }
    public List<MusicDTO> getMusicByAlbum(Long albumId) {
        List<MusicDTO> musicDTO = new ArrayList<>();
        List<Music> musicList = musicRepository.findByAlbumId(albumId);
        for (Music music : musicList) {
            MusicDTO musicDTo = new MusicDTO(music.getId(), music.getName(), music.getYear(), music.getAlbum(), music.getArtist());
            musicDTO.add(musicDTo);
        }
        return musicDTO;
    }
}
