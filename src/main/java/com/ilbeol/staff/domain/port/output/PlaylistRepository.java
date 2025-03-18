package com.ilbeol.staff.domain.port.output;

import com.ilbeol.staff.domain.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    Optional<Playlist> findByName(String name);

    boolean existsByName(String name);
}
