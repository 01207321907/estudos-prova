package com.example.demo.entity;

import java.time.LocalDate;

public class Reserva {

    private Long id;
    private Long destinoId;
    private LocalDate dataPartida;
    private int quantidadePessoas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(Long destinoId) {
        this.destinoId = destinoId;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    // Getters e Setters

    // Outros campos e métodos podem ser adicionados conforme necessário
}

