package com.ilbeol.staff.infraestructure.controller;

import com.ilbeol.staff.application.dto.PlaylistRequest;
import com.ilbeol.staff.application.dto.PlaylistResponse;
import com.ilbeol.staff.domain.exception.PlaylistNotFoundException;
import com.ilbeol.staff.domain.port.input.PlaylistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Validated
@RestController
@RequestMapping("/lists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<PlaylistResponse> createPlaylist(
            @Valid @RequestBody PlaylistRequest request,
            UriComponentsBuilder uriBuilder) {

        PlaylistResponse savedPlaylist = playlistService.createPlaylist(request);
        URI location = uriBuilder.path("/lists/{id}").buildAndExpand(savedPlaylist.getId()).toUri();
        return ResponseEntity.created(location).body(savedPlaylist);
    }

    @GetMapping
    public List<PlaylistResponse> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{name}")
    public ResponseEntity<PlaylistResponse> getPlaylistByName(@PathVariable String name) {
        return playlistService.getPlaylistByName(name)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new PlaylistNotFoundException("Playlist no encontrada: " + name));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable String name) {
        playlistService.deletePlaylist(name);
        return ResponseEntity.noContent().build();
    }
}