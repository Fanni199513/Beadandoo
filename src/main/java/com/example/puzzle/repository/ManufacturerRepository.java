package com.example.puzzle.repository;

import com.example.puzzle.domain.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, UUID>{

}
