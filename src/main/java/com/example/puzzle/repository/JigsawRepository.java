package com.example.puzzle.repository;

import com.example.puzzle.domain.Jigsaw;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JigsawRepository extends JpaRepository<Jigsaw, UUID> {

}
