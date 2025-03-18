package com.ilbeol.staff.infraestructure.controller;

import com.ilbeol.staff.application.dto.PlaylistRequest;
import com.ilbeol.staff.application.dto.PlaylistResponse;
import com.ilbeol.staff.domain.port.input.PlaylistService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PlaylistControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PlaylistService playlistService;

    @InjectMocks
    private PlaylistController playlistController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(playlistController).build();
    }

    @Test
    void shouldCreatePlaylistSuccessfully() throws Exception {
        PlaylistRequest request = new PlaylistRequest("Dungeon Synth", "Oscuro y atmosférico", Collections.emptyList());
        PlaylistResponse response = new PlaylistResponse(1L, "Dungeon Synth", "Oscuro y atmosférico", Collections.emptyList());

        when(playlistService.createPlaylist(any(PlaylistRequest.class))).thenReturn(response);

        mockMvc.perform(post("/lists")
                        .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Dungeon Synth\",\"description\":\"Oscuro y atmosférico\",\"songs\":[]}"))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.name").value("Dungeon Synth"));
    }

    @Test
    void shouldGetAllPlaylists() throws Exception {
        when(playlistService.getAllPlaylists()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/lists")).andExpect(status().isOk());
    }

    @Test
    void shouldGetPlaylistByName() throws Exception {
        PlaylistResponse response = new PlaylistResponse(1L, "Dungeon Synth", "Oscuro y atmosférico", Collections.emptyList());
        when(playlistService.getPlaylistByName("Dungeon Synth")).thenReturn(Optional.of(response));

        mockMvc.perform(get("/lists/Dungeon Synth"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Dungeon Synth"));
    }

    @Test
    void shouldDeletePlaylist() throws Exception {
        doNothing().when(playlistService).deletePlaylist(anyString());

        mockMvc.perform(delete("/lists/Dungeon Synth"))
                .andExpect(status().isNoContent());
    }
}
