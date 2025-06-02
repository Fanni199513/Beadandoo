package com.example.puzzle.service;

import com.example.puzzle.domain.Manufacturer;
import com.example.puzzle.repository.ManufacturerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ManufacturerServiceTest {

    @Mock
    private ManufacturerRepository manufacturerRepository;

    @InjectMocks
    private ManufacturerService manufacturerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllManufacturers_shouldReturnAllManufacturers() {
        // GIVEN
        List<Manufacturer> expected = List.of(
                Manufacturer.builder()
                        .id(UUID.randomUUID())
                        .name("Ravensburger")
                        .yearOfEstablishment(LocalDate.of(1883, 1, 1))
                        .headquarters("Németország")
                        .build(),
                Manufacturer.builder()
                        .id(UUID.randomUUID())
                        .name("Trefl")
                        .yearOfEstablishment(LocalDate.of(1985, 1, 1))
                        .headquarters("Lengyelország")
                        .build()
        );

        when(manufacturerRepository.findAll()).thenReturn(expected);

        // WHEN
        List<Manufacturer> result = manufacturerService.getAllManufacturers();

        // THEN
        assertEquals(expected, result);
        verify(manufacturerRepository, times(1)).findAll();
    }

    @Test
    void save_shouldSaveAndReturnManufacturer() {
        // GIVEN
        Manufacturer manufacturer = Manufacturer.builder()
                .id(UUID.randomUUID())
                .name("Educa")
                .yearOfEstablishment(LocalDate.of(1990, 1, 1))
                .headquarters("Spanyolország")
                .build();

        when(manufacturerRepository.save(manufacturer)).thenReturn(manufacturer);

        // WHEN
        Manufacturer result = manufacturerService.save(manufacturer);

        // THEN
        assertEquals(manufacturer, result);
        verify(manufacturerRepository, times(1)).save(manufacturer);
    }

    @Test
    void edit_shouldEditAndReturnManufacturer() {
        // GIVEN
        Manufacturer manufacturer = Manufacturer.builder()
                .id(UUID.randomUUID())
                .name("Schmidt")
                .yearOfEstablishment(LocalDate.of(1900, 1, 1))
                .headquarters("Németország")
                .build();

        when(manufacturerRepository.save(manufacturer)).thenReturn(manufacturer);

        // WHEN
        Manufacturer result = manufacturerService.edit(manufacturer);

        // THEN
        assertEquals(manufacturer, result);
        verify(manufacturerRepository, times(1)).save(manufacturer);
    }

    @Test
    void findById_shouldReturnManufacturerIfExists() {
        // GIVEN
        UUID id = UUID.randomUUID();
        Manufacturer manufacturer = Manufacturer.builder()
                .id(id)
                .name("Castorland")
                .yearOfEstablishment(LocalDate.of(1989, 1, 1))
                .headquarters("Lengyelország")
                .build();

        when(manufacturerRepository.findById(id)).thenReturn(Optional.of(manufacturer));

        // WHEN
        Manufacturer result = manufacturerService.findById(id);

        // THEN
        assertEquals(manufacturer, result);
        verify(manufacturerRepository, times(1)).findById(id);
    }

    @Test
    void findById_shouldReturnNullIfNotFound() {
        // GIVEN
        UUID id = UUID.randomUUID();
        when(manufacturerRepository.findById(id)).thenReturn(Optional.empty());

        // WHEN
        Manufacturer result = manufacturerService.findById(id);

        // THEN
        assertNull(result);
        verify(manufacturerRepository, times(1)).findById(id);
    }

    @Test
    void deleteById_shouldDeleteManufacturer() {
        // GIVEN
        UUID id = UUID.randomUUID();

        // WHEN
        manufacturerService.deleteById(id);

        // THEN
        verify(manufacturerRepository, times(1)).deleteById(id);
    }
}
