package com.example.puzzle.service;

import com.example.puzzle.domain.Manufacturer;
import com.example.puzzle.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer save(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return manufacturer;
    }

    public Manufacturer edit(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        return manufacturer;
    }

    public Manufacturer findById(UUID id) {
        return manufacturerRepository.findById(id).orElse(null);
    }


    public void deleteById(UUID id) {
        manufacturerRepository.deleteById(id);
    }
}
