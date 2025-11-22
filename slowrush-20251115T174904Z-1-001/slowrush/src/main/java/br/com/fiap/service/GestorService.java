package br.com.fiap.service;

import br.com.fiap.model.Gestor;
import br.com.fiap.repository.GestorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GestorService {

    @Inject
    private GestorRepository gestorRepository;

    @Transactional
    public Gestor create(Gestor gestor) {
        gestorRepository.persist(gestor);
        return gestor;
    }

    public Gestor getById(Long id) {
        return gestorRepository.findByIdOptional(id)
                .orElseThrow(() -> new RuntimeException("Gestor não encontrado: " + id));
    }

    public List<Gestor> getAll() {
        return gestorRepository.listAll();
    }

    @Transactional
    public void delete(Long id) {
        if (gestorRepository.findByIdOptional(id).isEmpty()) {
            throw new RuntimeException("Gestor não encontrado para deletar: " + id);
        }
        gestorRepository.deleteById(id);
    }
}