package com.ilbeol.staff.domain.port;

import com.ilbeol.staff.application.dto.PlaylistRequest;
import com.ilbeol.staff.application.dto.PlaylistResponse;
import com.ilbeol.staff.application.exception.InvalidPlaylistException;
import com.ilbeol.staff.domain.model.Playlist;
import com.ilbeol.staff.domain.port.input.PlaylistService;
import com.ilbeol.staff.domain.port.output.PlaylistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PlaylistServiceTest {

    @Mock
    private PlaylistRepository playlistRepository;

    @InjectMocks
    private PlaylistService playlistService;

    @Test
    void shouldThrowExceptionWhenPlaylistNameIsNull() {
        PlaylistRequest request = new PlaylistRequest(null, "Oscuro y atmosférico", new ArrayList<>());

        assertThrows(InvalidPlaylistException.class, () -> {
            playlistService.createPlaylist(request);
        });

        verify(playlistRepository, never()).save(any());
    }
}

