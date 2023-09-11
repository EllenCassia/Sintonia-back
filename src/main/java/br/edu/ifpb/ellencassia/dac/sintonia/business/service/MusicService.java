package br.edu.ifpb.ellencassia.dac.sintonia.business.service;

import org.springframework.stereotype.Service;

import br.edu.ifpb.ellencassia.dac.sintonia.business.dto.MusicDTO;

import java.util.List;

@Service
public interface MusicService {

    public abstract MusicDTO createMusic(MusicDTO musicDTO);

    public abstract List<MusicDTO> getAllMusics();

    public abstract MusicDTO removeMusic(Long id);

    public abstract MusicDTO updateMusic(Long id, MusicDTO musicDTO);

    public abstract List<MusicDTO> getMusicByAlbum(Long albumId);
}
