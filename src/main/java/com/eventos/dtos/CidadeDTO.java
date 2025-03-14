package com.eventos.dtos;


import com.eventos.enums.Estado;

public class CidadeDTO {
    private Long id;
    private String nome;
    private Estado estado;

    public CidadeDTO() {
    }

    public CidadeDTO(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
