package br.edu.ifpb.ellencassia.dac.sintonia.controller;

import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.MusicDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.buniness.service.MusicService;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    MusicService musicService;

    @PostMapping
    public ResponseEntity<String> createMusic(@RequestBody MusicDTO musicDTO) {
        return musicService.createMusic(musicDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMusic(@PathVariable Long id) {
        return musicService.removeMusic(id);
    }

    @PutMapping
    public ResponseEntity<String> updateMusic(@RequestBody MusicDTO musicDTO) {
        return musicService.updateMusic(musicDTO);
    }

    @GetMapping
    public List<MusicDTO> getAllMusics() {
        return musicService.getAllMusics();
    }

    @GetMapping("/albums/{albumId}")
    public ResponseEntity<List<MusicDTO>> getMusicByAlbum(@PathVariable Long albumId) {
        List<MusicDTO> musicDTOList = musicService.getMusicByAlbum(albumId);
        return ResponseEntity.ok(musicDTOList);
    }
}
