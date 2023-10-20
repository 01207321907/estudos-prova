package com.example.demo.controller;


import com.example.demo.entity.CompanhiaAerea;
import com.example.demo.service.CompanhiaAereaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/companhias-aereas")
public class CompanhiaAereaController {

    private final CompanhiaAereaService companhiaAereaService;

    public CompanhiaAereaController(CompanhiaAereaService companhiaAereaService) {
        this.companhiaAereaService = companhiaAereaService;
    }

    @GetMapping
    public ResponseEntity<List<CompanhiaAerea>> listarCompanhiasAereas() {
        List<CompanhiaAerea> companhiasAereas = companhiaAereaService.listarCompanhiasAereas();
        return new ResponseEntity<>(companhiasAereas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanhiaAerea> adicionarCompanhiaAerea(@RequestBody CompanhiaAerea companhiaAerea) {
        CompanhiaAerea novaCompanhiaAerea = companhiaAereaService.adicionarCompanhiaAerea(companhiaAerea);
        return new ResponseEntity<>(novaCompanhiaAerea, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanhiaAerea> consultarCompanhiaAerea(@PathVariable("id") Long id) {
        CompanhiaAerea companhiaAerea = companhiaAereaService.consultarCompanhiaAerea(id);
        return new ResponseEntity<>(companhiaAerea, HttpStatus.OK);
    }

    // Outros métodos para atualizar e excluir companhias aéreas podem ser adicionados
}
