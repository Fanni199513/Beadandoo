package com.example.puzzle.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @Column(name = "year_of_establishment")
    private LocalDate yearOfEstablishment;
    private String headquarters;

    @OneToMany(mappedBy = "manufacturer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Jigsaw> jigsaws;
}