package br.edu.ifpb.ellencassia.dac.sintonia.presentation.controller;

import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.AlbumDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.buniness.service.AlbumService;
import br.edu.ifpb.ellencassia.dac.sintonia.buniness.service.MusicService;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/album")
public class AlbumController{

    @Autowired
    AlbumService albumService;

    @PostMapping
    public ResponseEntity<String> createAlbum(@RequestBody AlbumDTO albumDTO) {
        return albumService.createAlbum(albumDTO);
    }

    @GetMapping
    public List<AlbumDTO> getAllAlbuns() {
        return albumService.getAllAlbuns();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeAlbum(@PathVariable Long id) {
        return albumService.removeAlbum(id);
    }

    @PutMapping
    public ResponseEntity<String> updateAlbum(@RequestBody AlbumDTO albumDto) {
        return albumService.updateAlbum(albumDto);
    }

}
