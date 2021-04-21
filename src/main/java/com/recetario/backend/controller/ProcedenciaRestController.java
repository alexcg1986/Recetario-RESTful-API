package com.recetario.backend.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.recetario.backend.dto.ProcedenciaDTO;
import com.recetario.backend.service.ProcedenciaService;

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
@RequestMapping("/api/procedencia")
@CrossOrigin(origins = "http://localhost:8081")
public class ProcedenciaRestController {

    @Autowired
    private ProcedenciaService service;

    @GetMapping
    public ResponseEntity<List<EntityModel<ProcedenciaDTO>>> getAll() {
        try {
            return new ResponseEntity<List<EntityModel<ProcedenciaDTO>>>(service.getAll().stream().map(item -> item
                    .add(WebMvcLinkBuilder.linkTo(ProcedenciaRestController.class).slash(item.getId()).withSelfRel()))
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<EntityModel<ProcedenciaDTO>>>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<ProcedenciaDTO> find(@PathVariable("id") Integer id) {
        try {
            ProcedenciaDTO item = service.get(id);
            if (item != null) {
                item.add(WebMvcLinkBuilder.linkTo(ProcedenciaRestController.class).slash(item.getId()).withSelfRel());
                return new ResponseEntity<ProcedenciaDTO>(item, HttpStatus.OK);
            } else
                return new ResponseEntity<ProcedenciaDTO>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<ProcedenciaDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<ProcedenciaDTO> save(@RequestBody ProcedenciaDTO dto) {
        try {
            ProcedenciaDTO savedItem = service.save(dto);
            savedItem.add(
                    WebMvcLinkBuilder.linkTo(ProcedenciaRestController.class).slash(savedItem.getId()).withSelfRel());
            return new ResponseEntity<ProcedenciaDTO>(savedItem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ProcedenciaDTO>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProcedenciaDTO> delete(@PathVariable("id") Integer id) {
        try {
            ProcedenciaDTO itemToDelete = service.get(id);
            if (itemToDelete != null) {
                service.delete(id);
                return new ResponseEntity<ProcedenciaDTO>(itemToDelete, HttpStatus.OK);
            } else {
                return new ResponseEntity<ProcedenciaDTO>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<ProcedenciaDTO>(HttpStatus.BAD_REQUEST);
        }
    }
}