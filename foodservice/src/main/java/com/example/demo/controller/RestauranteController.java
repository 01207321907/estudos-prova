package com.example.demo.controller;

import com.example.demo.entity.Restaurante;
import com.example.demo.service.RestauranteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> listarRestaurantes() {
        List<Restaurante> restaurantes = restauranteService.listarRestaurantes();
        return new ResponseEntity<>(restaurantes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Restaurante> adicionarRestaurante(@RequestBody Restaurante restaurante) {
        Restaurante novoRestaurante = restauranteService.adicionarRestaurante(restaurante);
        return new ResponseEntity<>(novoRestaurante, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> consultarRestaurante(@PathVariable("id") Long id) {
        Restaurante restaurante = restauranteService.consultarRestaurante(id);
        return new ResponseEntity<>(restaurante, HttpStatus.OK);
    }

    // Outros métodos para atualizar e excluir restaurantes podem ser adicionados
}
