package br.edu.ifpb.ellencassia.dac.sintonia.business.service;

import org.springframework.stereotype.Service;

import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.AlbumDTO;

import java.util.List;
@Service
public interface AlbumService {
    public abstract AlbumDTO createAlbum(AlbumDTO albumDTO);

    public abstract List<AlbumDTO> getAllAlbums();

    public abstract AlbumDTO removeAlbum(Long id);

    public abstract AlbumDTO updateAlbum(Long id, AlbumDTO albumDto);
}
