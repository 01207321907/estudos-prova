package com.example.demo.service;

import com.example.demo.entity.Destino;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DestinoService {

    private final List<Destino> destinos = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Destino> listarDestinos() {
        return destinos;
    }

    public Destino adicionarDestino(Destino destino) {
        destino.setId(nextId.getAndIncrement());
        destinos.add(destino);
        return destino;
    }

    public Destino consultarDestino(Long id) {
        Optional<Destino> destinoOptional = destinos.stream()
                .filter(destino -> destino.getId().equals(id))
                .findFirst();

        return destinoOptional.orElse(null);
    }

    // Outros métodos para atualizar e excluir destinos podem ser adicionados
}
