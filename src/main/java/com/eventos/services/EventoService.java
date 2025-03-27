package com.eventos.services;

import com.eventos.dtos.EventoDTO;
import com.eventos.dtos.ProdutoraDTO;
import com.eventos.models.Evento;
import com.eventos.models.Produtora;
import com.eventos.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ProdutoraService produtoraService;

    public EventoDTO salvarEvento(EventoDTO eventoDTO) {
        Evento evento = converterEventoDTOParaEvento(eventoDTO);
        evento = eventoRepository.save(evento);
        return converterEventoParaEventoDTO(evento);
    }

    public EventoDTO converterEventoParaEventoDTO(Evento evento) {
        EventoDTO eventoDTO = new EventoDTO();
        eventoDTO.setId(evento.getId());
        eventoDTO.setDescricao(evento.getDescricao());
        eventoDTO.setData(evento.getData());
        eventoDTO.setClassificacao(evento.getClassificacao());
        eventoDTO.setHoraAbertura(evento.getHoraAbertura());
        eventoDTO.setHoraFim(evento.getHoraFim());
        eventoDTO.setHoraInicio(evento.getHoraInicio());
        eventoDTO.setImagem(evento.getImagem());
        ProdutoraDTO produtoraDTO = produtoraService.converterProdutoraParaProdutoraDTO(evento.getProdutora());
        eventoDTO.setProdutora(produtoraDTO);
        return eventoDTO;
    }

    public Evento converterEventoDTOParaEvento(EventoDTO eventoDTO) {
        Evento evento = new Evento();
        evento.setId(eventoDTO.getId());
        evento.setDescricao(eventoDTO.getDescricao());
        evento.setData(eventoDTO.getData());
        evento.setClassificacao(eventoDTO.getClassificacao());
        evento.setHoraAbertura(eventoDTO.getHoraAbertura());
        evento.setHoraFim(eventoDTO.getHoraFim());
        evento.setHoraInicio(eventoDTO.getHoraInicio());
        evento.setImagem(eventoDTO.getImagem());
        Produtora produtora = produtoraService.converterProdutoraDTOParaProdutora(eventoDTO.getProdutora());
        evento.setProdutora(produtora);
        return evento;
    }

    public Evento buscarEventoPorId(Long id) {
        return eventoRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Evento não encontrada"));
    }

    public EventoDTO atualizarEvento(EventoDTO eventoDTO) {
        if (isNull(eventoDTO.getId())) {
            throw new IllegalArgumentException("campo Id não informado");
        }
        Evento evento = eventoRepository.findById(eventoDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Evento não encontrada"));

        evento = converterEventoDTOParaEvento(eventoDTO);
        evento = eventoRepository.save(evento);
        return converterEventoParaEventoDTO(evento);
    }

    public void deletarEvento(Long id) {
        eventoRepository.deleteById(id);
    }

    public EventoDTO buscarEventoPorDescricao(String descricao) {
        return converterEventoParaEventoDTO(eventoRepository.findByDescricao(descricao)
                .orElseThrow(() ->
                        new IllegalArgumentException("Evento não encontrada")));
    }
}

