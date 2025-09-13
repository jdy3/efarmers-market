package com.jdy3.efarmersmarket.livestock;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LivestockServiceTest {

    private LivestockService service;
    private LivestockRepository mockLivestockRepository;
    private Livestock livestock1, livestock2;

    @BeforeEach
    void setUp() {
        mockLivestockRepository = Mockito.mock(LivestockRepository.class);
        service = new LivestockService(mockLivestockRepository);
        livestock1 = new Livestock(LocalDate.now(), "product1", "", "description1", BigDecimal.valueOf(500.00), "Farm1",
                "point1", BigDecimal.valueOf(1200.00), 24.0, 10, "certificate1", "breed1");
        livestock2 = new Livestock(LocalDate.now(), "product2", "", "description2", BigDecimal.valueOf(250.00), "Farm2",
                "point2", BigDecimal.valueOf(600.00), 12.0, 20, "certificate2", "breed2");
    }

    @Test
    void testGetAllLivestockInitiallyEmpty(){
        Mockito.when(mockLivestockRepository.findAll()).thenReturn(List.of());
        assertTrue(service.getAllLivestock().isEmpty());
    }

    @Test
    void testGetAllLivestockInitiallyAfterAdding(){
        Mockito.when(mockLivestockRepository.save(Mockito.any(Livestock.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(mockLivestockRepository.findAll()).thenReturn(List.of(livestock1, livestock2));
        List<Livestock> livestock = service.getAllLivestock();

        assertEquals(2, livestock.size());
        assertTrue(livestock.contains(livestock1));
        assertTrue(livestock.contains(livestock2));
    }

    @Test
    void testGetExistingLivestockById(){
        Mockito.when(mockLivestockRepository.save(Mockito.any(Livestock.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(mockLivestockRepository.findById(livestock1.getId())).thenReturn(Optional.of(livestock1));
        service.createLivestock(livestock1);
        Livestock found = service.getLivestock(livestock1.getId());

        assertEquals(livestock1.getId(), found.getId());
    }

    @Test
    void testGetAllExistingLivestockByName(){
        Mockito.when(mockLivestockRepository.save(Mockito.any(Livestock.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(mockLivestockRepository.findByName(livestock2.getName())).thenReturn(List.of(livestock2));
        service.createLivestock(livestock2);
        List<Livestock> found = service.getLivestockByName(livestock2.getName());

        assertEquals(livestock2.getName(), found.get(0).getName());
    }

    @Test 
    void testGetAllExistingLivestockByProvenance(){
        Mockito.when(mockLivestockRepository.save(Mockito.any(Livestock.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(mockLivestockRepository.findByProvenance(livestock1.getProvenance())).thenReturn(List.of(livestock1));
        service.createLivestock(livestock1);
        List<Livestock> found = service.getLivestockByProvenance(livestock1.getProvenance());

        assertEquals(livestock1.getProvenance(), found.get(0).getProvenance());

    }

    @Test
    void testGetLivestockNonExisting(){
        assertThrows(NoSuchElementException.class, () -> service.getLivestock(UUID.randomUUID()));
    }
}
