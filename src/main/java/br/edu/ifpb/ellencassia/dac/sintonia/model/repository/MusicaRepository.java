package br.edu.ifpb.ellencassia.dac.sintonia.model.repository;

import br.edu.ifpb.ellencassia.dac.sintonia.buniness.dto.MusicDTO;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Music, Long> {
        List<Music> findByAlbumId(Long albumId);
}
