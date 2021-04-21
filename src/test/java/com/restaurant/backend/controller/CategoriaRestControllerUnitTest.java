package com.restaurant.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.recetario.backend.controller.CategoriaRestController;
import com.recetario.backend.dto.CategoriaDTO;
import com.recetario.backend.service.CategoriaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CategoriaRestControllerUnitTest {

    @Mock
    CategoriaService categoriaService;

    @Mock
    CategoriaDTO categoriaDTO;

    @InjectMocks
    CategoriaRestController categoriaRestController;

    @Test
    public void testCategoriaRestControllerGetAll() {
        List<CategoriaDTO> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            categoriaDTO.setId(i);
            categoriaDTO.setNombre("categoria" + i);
            list.add(categoriaDTO);
        }
        Mockito.when(categoriaService.getAll()).thenReturn(list);
        assertEquals(list, categoriaRestController.getAll());
    }
}
