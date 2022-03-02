package com.aldeamo.bar.controller;

import com.aldeamo.bar.repository.GlassesArrayRepository;
import com.aldeamo.bar.repository.document.GlassesArray;
import com.aldeamo.bar.service.BarService;
import com.aldeamo.bar.service.impl.BarServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BarControllerTest {


    BarService barService;

    @Mock
    GlassesArrayRepository glassesArrayRepository;


    BarController barController;

    @BeforeEach
    void setUp() {
        barController = new BarController();
        barService = new BarServiceImpl(glassesArrayRepository);
        Optional<GlassesArray> mockArray = Optional.of(new GlassesArray(1, "2,4,5,6,7,8"));
        Mockito.when(glassesArrayRepository.findById(1)).thenReturn(mockArray);
    }

    @Test
    void testCreate() {
        List<Integer> arrayInt = barController.findById(1);
        System.out.println(arrayInt);
    }
}