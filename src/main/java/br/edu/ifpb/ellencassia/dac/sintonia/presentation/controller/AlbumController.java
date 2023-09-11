package br.edu.ifpb.ellencassia.dac.sintonia.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.AlbumDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.business.service.AlbumService;

import java.util.List;
@RestController
@RequestMapping("/api/album")
@CrossOrigin(origins = "http://localhost:3000") 
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @PostMapping
    public ResponseEntity<AlbumDTO> createAlbum(@RequestBody AlbumDTO albumDTO) {
        AlbumDTO createdAlbum = albumService.createAlbum(albumDTO);
        if (createdAlbum != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAlbum);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<AlbumDTO>> getAllAlbuns() {
        List<AlbumDTO> albums = albumService.getAllAlbums();
        if (albums != null && !albums.isEmpty()) {
            return ResponseEntity.ok(albums);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeAlbum(@PathVariable Long id) {
        AlbumDTO removedAlbum = albumService.removeAlbum(id);
        if (removedAlbum != null) {
            return ResponseEntity.ok("Album removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Album not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumDTO> updateAlbum(@PathVariable Long id, @RequestBody AlbumDTO albumDto) {
        AlbumDTO updatedAlbum = albumService.updateAlbum(id, albumDto);
        if (updatedAlbum != null) {
            return ResponseEntity.ok(updatedAlbum);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
