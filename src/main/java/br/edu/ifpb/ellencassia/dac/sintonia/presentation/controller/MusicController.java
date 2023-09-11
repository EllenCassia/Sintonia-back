package br.edu.ifpb.ellencassia.dac.sintonia.presentation.controller;

import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.MusicDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.business.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/api/music")
@CrossOrigin(origins = "http://localhost:3000")
public class MusicController {

    @Autowired
    MusicService musicService;

    @PostMapping
    public ResponseEntity<MusicDTO> createMusic(@RequestBody MusicDTO musicDTO) {
        MusicDTO createdMusic = musicService.createMusic(musicDTO);
        if (createdMusic != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMusic);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMusic(@PathVariable Long id) {
        MusicDTO result = musicService.removeMusic(id);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body("Music removed");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Music not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicDTO> updateMusic(@PathVariable Long id, @RequestBody MusicDTO musicDTO) {
        MusicDTO updatedMusic = musicService.updateMusic(id, musicDTO);
        if (updatedMusic != null) {
            return ResponseEntity.ok(updatedMusic);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<MusicDTO>> getAllMusics() {
        List<MusicDTO> musicDTOList = musicService.getAllMusics();
        if (musicDTOList != null && !musicDTOList.isEmpty()) {
            return ResponseEntity.ok(musicDTOList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/albums/{albumId}")
    public ResponseEntity<List<MusicDTO>> getMusicByAlbum(@PathVariable Long albumId) {
        List<MusicDTO> musicDTOList = musicService.getMusicByAlbum(albumId);
        if (musicDTOList != null && !musicDTOList.isEmpty()) {
            return ResponseEntity.ok(musicDTOList);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
