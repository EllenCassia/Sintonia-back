package br.edu.ifpb.ellencassia.dac.sintonia.model.repository;

import br.edu.ifpb.ellencassia.dac.sintonia.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}