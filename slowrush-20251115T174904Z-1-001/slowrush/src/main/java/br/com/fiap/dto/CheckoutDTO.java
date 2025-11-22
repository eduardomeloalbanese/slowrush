package br.com.fiap.dto;

public record CheckoutDTO(
        Long id,
        String funcionario,
        String horasTrabalhadas,
        String intensidadeReunioes,
        String sentimento,
        String comentario,
        String data
) {}