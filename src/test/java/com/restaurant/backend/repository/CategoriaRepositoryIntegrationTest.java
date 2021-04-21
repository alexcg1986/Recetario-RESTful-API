package com.restaurant.backend.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.recetario.backend.model.Categoria;
import com.recetario.backend.repository.CategoriaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoriaRepositoryIntegrationTest {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    public void testCategoriaCreate() {
        Categoria categoria = new Categoria();
        categoria.setId(null);
        categoria.setNombre("categoria");
        Categoria savedItem = categoriaRepository.save(categoria);
        assertEquals("categoria", savedItem.getNombre());
        testCategoriaUpdate(savedItem);
    }

    public void testCategoriaUpdate(Categoria savedItem) {
        savedItem.setNombre("updatedCategoria");
        categoriaRepository.save(savedItem);
        assertEquals("updatedCategoria", categoriaRepository.findById(savedItem.getId()).get().getNombre());
        testCategoriaDelete(savedItem);
    }

    public void testCategoriaDelete(Categoria savedItem) {
        categoriaRepository.deleteById(savedItem.getId());
        assertEquals(false, categoriaRepository.findById(savedItem.getId()).isPresent());
    }
}
