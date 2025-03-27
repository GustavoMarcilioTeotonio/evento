package com.eventos.repositories;

import com.eventos.models.Cidade;
import com.eventos.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    Optional<Evento> findByDescricao(String descricao);
}

