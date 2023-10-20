package com.example.demo.service;

import com.example.demo.entity.Restaurante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RestauranteService {

    private final List<Restaurante> restaurantes = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Restaurante> listarRestaurantes() {
        return restaurantes;
    }

    public Restaurante adicionarRestaurante(Restaurante restaurante) {
        restaurante.setId(nextId.getAndIncrement());
        restaurantes.add(restaurante);
        return restaurante;
    }

    public Restaurante consultarRestaurante(Long id) {
        Optional<Restaurante> restauranteOptional = restaurantes.stream()
                .filter(restaurante -> restaurante.getId().equals(id))
                .findFirst();

        return restauranteOptional.orElse(null);
    }

    // Outros métodos para atualizar e excluir restaurantes podem ser adicionados
}
