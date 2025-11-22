package br.com.fiap.service;

import br.com.fiap.dto.CheckoutDTO;
import br.com.fiap.dto.FeedbackCheckOutDTO;
import br.com.fiap.model.RegistroRotina;
import br.com.fiap.repository.RegistroRotinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RegistroRotinaService {

    @Inject
    RegistroRotinaRepository repository;

    @Transactional
    public FeedbackCheckOutDTO realizarCheckOut(RegistroRotina registro) {
        repository.persist(registro);

        boolean critico = false;
        String msg = "Check-out realizado com sucesso. Bom descanso!";

        if (registro.getSentimento().equalsIgnoreCase("stress") ||
                registro.getSentimento().equalsIgnoreCase("estressado")) {
            critico = true;
            msg = "Cuidado! Notamos um nível alto de estresse. Recomendamos desconexão total.";
        }

        return new FeedbackCheckOutDTO(registro.getId(), critico, msg);
    }

    public List<CheckoutDTO> listarCheckoutsFormatados() {
        List<RegistroRotina> todos = repository.listAll();
        return todos.stream().map(r -> new CheckoutDTO(
                r.getId(),
                r.getFuncionario(),
                r.getHorasTrabalhadas(),
                r.getIntensidadeReunioes(),
                r.getSentimento(),
                r.getComentario(),
                r.getData()
        )).collect(Collectors.toList());
    }

    // --- NOVOS MÉTODOS PARA O CRUD COMPLETO ---

    public RegistroRotina findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void atualizar(RegistroRotina registroAtualizado) {
        // Busca o registro existente
        RegistroRotina existente = repository.findById(registroAtualizado.getId());

        if (existente != null) {
            // Atualiza os campos
            existente.setFuncionario(registroAtualizado.getFuncionario());
            existente.setHorasTrabalhadas(registroAtualizado.getHorasTrabalhadas());
            existente.setIntensidadeReunioes(registroAtualizado.getIntensidadeReunioes());
            existente.setSentimento(registroAtualizado.getSentimento());
            existente.setComentario(registroAtualizado.getComentario());
            // Opcional: atualizar a data se necessário

            // O Hibernate gerencia a persistência automaticamente ao final da transação
        } else {
            throw new RuntimeException("Registro não encontrado");
        }
    }

    @Transactional
    public boolean deletar(Long id) {
        return repository.deleteById(id);
    }
}