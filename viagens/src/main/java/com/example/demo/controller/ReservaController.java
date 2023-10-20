package com.example.demo.controller;


import com.example.demo.entity.Reserva;
import com.example.demo.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.criarReserva(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizarReserva(@PathVariable("id") Long id, @RequestBody Reserva reserva) {
        Reserva reservaAtualizada = reservaService.atualizarReserva(id, reserva);
        return new ResponseEntity<>(reservaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerReserva(@PathVariable("id") Long id) {
        reservaService.removerReserva(id);
        return new ResponseEntity<>("Reserva removida com sucesso", HttpStatus.OK);
    }

}

