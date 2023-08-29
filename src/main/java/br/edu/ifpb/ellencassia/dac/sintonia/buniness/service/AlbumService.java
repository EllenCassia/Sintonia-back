package br.edu.ifpb.ellencassia.dac.sintonia.buniness.service;

import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.AlbumDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AlbumService {
    public abstract ResponseEntity<String> createAlbum(AlbumDTO albumDTO);

    public abstract List<AlbumDTO> getAllAlbuns();

    public abstract ResponseEntity<String> removeAlbum(Long id);

    public abstract ResponseEntity<String> updateAlbum(AlbumDTO albumDto);
}
