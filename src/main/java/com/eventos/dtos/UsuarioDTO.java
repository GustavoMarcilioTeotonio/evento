package com.eventos.dtos;

import com.eventos.enums.Perfil;
import com.eventos.models.Usuario;
import jakarta.persistence.Column;

import java.util.Date;
import java.util.List;

public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Date dataNascimento;
    private List<Perfil> perfis;
    private Boolean  Verificado;

    public UsuarioDTO () {}

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
        this.perfis = usuario.getPerfis();
        this.Verificado = usuario.getVerificado();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Perfil> getPerfis() {return perfis; }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public Boolean getVerificado() {
        return Verificado;
    }

    public void setVerificado(Boolean verificado) {
        Verificado = verificado;
    }
}
