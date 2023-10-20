package com.example.demo.controller;


import com.example.demo.entity.Destino;
import com.example.demo.service.DestinoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    private final DestinoService destinoService;


    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @GetMapping
    public ResponseEntity<List<Destino>> listarDestinos() {
        List<Destino> destinos = destinoService.listarDestinos();
        return new ResponseEntity<>(destinos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Destino> adicionarDestino(@RequestBody Destino destino) {
        Destino novoDestino = destinoService.adicionarDestino(destino);
        return new ResponseEntity<>(novoDestino, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> consultarDestino(@PathVariable("id") Long id) {
        Destino destino = destinoService.consultarDestino(id);
        return new ResponseEntity<>(destino, HttpStatus.OK);
    }

    // Outros métodos para atualizar e excluir destinos podem ser adicionados
}
