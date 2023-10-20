package com.example.demo.service;


import com.example.demo.entity.CompanhiaAerea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CompanhiaAereaService {

    private final List<CompanhiaAerea> companhiasAereas = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<CompanhiaAerea> listarCompanhiasAereas() {
        return companhiasAereas;
    }

    public CompanhiaAerea adicionarCompanhiaAerea(CompanhiaAerea companhiaAerea) {
        companhiaAerea.setId(nextId.getAndIncrement());
        companhiasAereas.add(companhiaAerea);
        return companhiaAerea;
    }

    public CompanhiaAerea consultarCompanhiaAerea(Long id) {
        Optional<CompanhiaAerea> companhiaAereaOptional = companhiasAereas.stream()
                .filter(ca -> ca.getId().equals(id))
                .findFirst();

        return companhiaAereaOptional.orElse(null);
    }


}
