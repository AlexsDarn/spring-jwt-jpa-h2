package com.ilbeol.staff.domain.port.input;

import com.ilbeol.staff.application.dto.PlaylistRequest;
import com.ilbeol.staff.application.dto.PlaylistResponse;
import com.ilbeol.staff.application.exception.InvalidPlaylistException;
import com.ilbeol.staff.domain.exception.PlaylistNotFoundException;
import com.ilbeol.staff.domain.model.Playlist;
import com.ilbeol.staff.domain.port.output.PlaylistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Transactional
    public PlaylistResponse createPlaylist(PlaylistRequest request) {
        if (playlistRepository.existsByName(request.getName())) {
            throw new InvalidPlaylistException("Ya existe una playlist con el nombre: " + request.getName());
        }

        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new InvalidPlaylistException("El nombre de la playlist no puede estar vacío o nulo.");
        }

        if (playlistRepository.existsByName(request.getName())) {
            throw new InvalidPlaylistException("Ya existe una playlist con el nombre: " + request.getName());
        }

        Playlist playlist = request.toEntity();
        Playlist savedPlaylist = playlistRepository.save(playlist);
        return PlaylistResponse.fromEntity(savedPlaylist);
    }

    public List<PlaylistResponse> getAllPlaylists() {
        return playlistRepository.findAll()
                .stream()
                .map(PlaylistResponse::fromEntity)
                .toList();
    }

    public Optional<PlaylistResponse> getPlaylistByName(String name) {
        return playlistRepository.findByName(name)
                .map(PlaylistResponse::fromEntity);
    }

    @Transactional
    public void deletePlaylist(String name) {
        Playlist playlist = playlistRepository.findByName(name)
                .orElseThrow(() -> new PlaylistNotFoundException("Playlist no encontrada: " + name));

        playlistRepository.delete(playlist);
    }
}
