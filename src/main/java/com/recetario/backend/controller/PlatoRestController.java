package com.recetario.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.recetario.backend.dto.ParametrosDTO;
import com.recetario.backend.dto.PlatoDTO;
import com.recetario.backend.service.PlatoService;

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
@RequestMapping("/api/plato")
@CrossOrigin(origins = "http://localhost:8081")
public class PlatoRestController {

    @Autowired
    private PlatoService service;

    @GetMapping
    public ResponseEntity<List<EntityModel<PlatoDTO>>> getAll() {
        try {
            return new ResponseEntity<List<EntityModel<PlatoDTO>>>(service.getAll().stream()
                    .map(item -> item
                            .add(WebMvcLinkBuilder.linkTo(PlatoRestController.class).slash(item.getId()).withSelfRel()))
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<EntityModel<PlatoDTO>>>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<PlatoDTO> find(@PathVariable("id") Integer id) {
        try {
            PlatoDTO item = service.get(id);
            if (item != null) {
                item.add(WebMvcLinkBuilder.linkTo(PlatoRestController.class).slash(item.getId()).withSelfRel());
                return new ResponseEntity<PlatoDTO>(item, HttpStatus.OK);
            } else
                return new ResponseEntity<PlatoDTO>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<PlatoDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/filtrado")
    public ResponseEntity<List<EntityModel<PlatoDTO>>> getAllFiltered(@RequestBody ParametrosDTO parametrosDTO) {
        try {
            return new ResponseEntity<List<EntityModel<PlatoDTO>>>(service.getAllFiltered(parametrosDTO).stream()
                    .map(item -> item
                            .add(WebMvcLinkBuilder.linkTo(PlatoRestController.class).slash(item.getId()).withSelfRel()))
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<EntityModel<PlatoDTO>>>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<PlatoDTO> save(@RequestBody PlatoDTO dto) {
        try {
            PlatoDTO savedItem = service.save(dto);
            savedItem.add(WebMvcLinkBuilder.linkTo(PlatoRestController.class).slash(savedItem.getId()).withSelfRel());
            return new ResponseEntity<PlatoDTO>(savedItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<PlatoDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PlatoDTO> delete(@PathVariable("id") Integer id) {
        try {
            PlatoDTO itemToDelete = service.get(id);
            if (itemToDelete != null) {
                service.delete(id);
                return new ResponseEntity<PlatoDTO>(itemToDelete, HttpStatus.OK);
            } else {
                return new ResponseEntity<PlatoDTO>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<PlatoDTO>(HttpStatus.BAD_REQUEST);
        }
    }
}