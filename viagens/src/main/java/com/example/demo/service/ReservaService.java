package com.example.demo.service;

import com.example.demo.entity.Reserva;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReservaService {

    // Simulação de banco de dados em memória para armazenar reservas
    private final Map<Long, Reserva> reservas = new HashMap<>();
    private long proximoId = 1;

    public Reserva criarReserva(Reserva reserva) {
        reserva.setId(proximoId);
        reservas.put(proximoId, reserva);
        proximoId++;
        return reserva;
    }

    public Reserva atualizarReserva(Long id, Reserva reservaAtualizada) {
        if (reservas.containsKey(id)) {
            reservaAtualizada.setId(id);
            reservas.put(id, reservaAtualizada);
            return reservaAtualizada;
        }
        return null; // Retorna null se a reserva não existe
    }

    public void removerReserva(Long id) {
        reservas.remove(id);
    }

    public Reserva consultarReserva(Long id) {
        return reservas.get(id);
    }

    // Outros métodos, como listar reservas, podem ser adicionados conforme necessário
}
