package br.edu.ifpb.ellencassia.dac.sintonia.buniness.service;

import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.AlbumDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.MusicDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Music;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MusicService {

    public abstract ResponseEntity<String> createMusic(MusicDTO musicDTO);

    public abstract List<MusicDTO> getAllMusics();

    public abstract ResponseEntity<String> removeMusic(Long id);

    public abstract ResponseEntity<String> updateMusic(MusicDTO musicDTO);

    public abstract List<MusicDTO> getMusicByAlbum(Long albumId);
}
