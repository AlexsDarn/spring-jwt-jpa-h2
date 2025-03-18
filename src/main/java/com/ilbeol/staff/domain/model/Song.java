package com.ilbeol.staff.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "songs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String artist;
    private String album;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;
    private String genre;
}
