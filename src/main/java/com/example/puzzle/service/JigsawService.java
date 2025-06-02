package com.example.puzzle.service;

import com.example.puzzle.domain.Jigsaw;
import com.example.puzzle.repository.JigsawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service

public class JigsawService {


    @Autowired
    private JigsawRepository jigsawRepository;

    public List<com.example.puzzle.domain.Jigsaw> getAllJigsaws() {

        return jigsawRepository.findAll();
    }

    public Jigsaw save (Jigsaw jigsaw) {
        return jigsawRepository.save(jigsaw);
    }

    public Jigsaw edit(Jigsaw jigsaw) {
        return jigsawRepository.save(jigsaw);
    }

    public Jigsaw findById(UUID id) {
        return jigsawRepository.findById(id).orElse(null);
    }


    public void deleteById(UUID id) {
        jigsawRepository.deleteById(id);
    }
}