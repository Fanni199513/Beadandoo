package com.example.puzzle.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.puzzle.domain.Jigsaw;
import com.example.puzzle.domain.Manufacturer;
import com.example.puzzle.repository.JigsawRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JigsawServiceTest {

    @Mock
    private JigsawRepository jigsawRepositoryMock;

    @InjectMocks
    private JigsawService underTest;

    private final Manufacturer mockManufacturer = Manufacturer.builder()
            .id(UUID.randomUUID())
            .name("Trefl")
            .yearOfEstablishment(LocalDate.of(1985, 1, 1))
            .headquarters("Lengyelország")
            .build();

    @Test
    void getAllJigsaws() {
        // GIVEN
        List<Jigsaw> expectedJigsaws = List.of(
                Jigsaw.builder()
                        .id(UUID.randomUUID())
                        .title("Zebra")
                        .pieces(1500)
                        .price(2990)
                        .manufacturer(mockManufacturer)
                        .build(),
                Jigsaw.builder()
                        .id(UUID.randomUUID())
                        .title("Kutya")
                        .pieces(2000)
                        .price(3490)
                        .manufacturer(mockManufacturer)
                        .build()
        );

        when(jigsawRepositoryMock.findAll()).thenReturn(expectedJigsaws);

        // WHEN
        List<Jigsaw> result = underTest.getAllJigsaws();

        // THEN
        assertEquals(expectedJigsaws, result);
    }

    @Test
    void saveHappyPath() {
        // GIVEN
        Jigsaw expectedJigsaw = Jigsaw.builder()
                .id(UUID.randomUUID())
                .title("Kutya")
                .pieces(2000)
                .price(3490)
                .manufacturer(mockManufacturer)
                .build();

        when(jigsawRepositoryMock.save(expectedJigsaw)).thenReturn(expectedJigsaw);

        // WHEN
        Jigsaw result = underTest.save(expectedJigsaw);

        // THEN
        assertEquals(expectedJigsaw, result);
    }

    @Test
    void editHappyPath() {
        // GIVEN
        Jigsaw expectedJigsaw = Jigsaw.builder()
                .id(UUID.randomUUID())
                .title("Kutya")
                .pieces(2000)
                .price(3490)
                .manufacturer(mockManufacturer)
                .build();

        when(jigsawRepositoryMock.save(expectedJigsaw)).thenReturn(expectedJigsaw);

        // WHEN
        Jigsaw result = underTest.edit(expectedJigsaw);

        // THEN
        assertEquals(expectedJigsaw, result);
    }
}
