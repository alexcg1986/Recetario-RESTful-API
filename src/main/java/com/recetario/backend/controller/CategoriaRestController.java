package com.recetario.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.recetario.backend.dto.CategoriaDTO;
import com.recetario.backend.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "https://spa-recetario.netlify.app")
public class CategoriaRestController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<EntityModel<CategoriaDTO>>> getAll() {
        try {
            return new ResponseEntity<List<EntityModel<CategoriaDTO>>>(service.getAll().stream()
                    .map(item -> item.add(
                            WebMvcLinkBuilder.linkTo(CategoriaRestController.class).slash(item.getId()).withSelfRel()))
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<EntityModel<CategoriaDTO>>>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoriaDTO> find(@PathVariable("id") Integer id) {
        try {
            CategoriaDTO item = service.get(id);
            if (item != null) {
                item.add(WebMvcLinkBuilder.linkTo(CategoriaRestController.class).slash(item.getId()).withSelfRel());
                return new ResponseEntity<CategoriaDTO>(item, HttpStatus.OK);
            } else
                return new ResponseEntity<CategoriaDTO>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<CategoriaDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO dto) {
        try {
            CategoriaDTO savedItem = service.save(dto);
            savedItem.add(
                    WebMvcLinkBuilder.linkTo(CategoriaRestController.class).slash(savedItem.getId()).withSelfRel());
            return new ResponseEntity<CategoriaDTO>(savedItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<CategoriaDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CategoriaDTO> delete(@PathVariable("id") Integer id) {
        try {
            CategoriaDTO itemToDelete = service.get(id);
            if (itemToDelete != null) {
                service.delete(id);
                return new ResponseEntity<CategoriaDTO>(itemToDelete, HttpStatus.OK);
            } else {
                return new ResponseEntity<CategoriaDTO>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<CategoriaDTO>(HttpStatus.BAD_REQUEST);
        }
    }
}