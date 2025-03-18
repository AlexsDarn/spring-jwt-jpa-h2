package com.ilbeol.staff.application.dto;

import com.ilbeol.staff.domain.model.Playlist;
import com.ilbeol.staff.domain.model.Song;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaylistResponse {
    private Long id;
    private String name;
    private String description;
    private List<Song> songs;

    public static PlaylistResponse fromEntity(Playlist playlist) {
        return PlaylistResponse.builder()
                .id(playlist.getId())
                .name(playlist.getName())
                .description(playlist.getDescription())
                .songs(playlist.getSongs())
                .build();
    }
}