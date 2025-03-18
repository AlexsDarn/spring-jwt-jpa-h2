package com.ilbeol.staff.application.dto;

import com.ilbeol.staff.domain.model.Playlist;
import com.ilbeol.staff.domain.model.Song;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaylistRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    private String description;
    private List<Song> songs;

    public Playlist toEntity() {
        return new Playlist(null, name, description, songs);
    }
}