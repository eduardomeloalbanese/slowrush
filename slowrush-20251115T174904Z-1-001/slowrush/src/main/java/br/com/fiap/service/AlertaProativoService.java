package br.com.fiap.service;

import br.com.fiap.model.AlertaProativo;
import br.com.fiap.repository.AlertaProativoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class AlertaProativoService {

    @Inject
    private AlertaProativoRepository alertaProativoRepository;

    @Transactional
    public AlertaProativo confirmarRecebimento(Long id) {
        AlertaProativo alerta = getById(id);

        if (alerta.isConfirmado()) {
            throw new RuntimeException("Alerta já havia sido confirmado.");
        }

        alerta.setConfirmado(true);
        alertaProativoRepository.persist(alerta);
        return alerta;
    }

    @Transactional
    public AlertaProativo create(AlertaProativo alerta) {
        alertaProativoRepository.persist(alerta);
        return alerta;
    }

    public AlertaProativo getById(Long id) {
        return alertaProativoRepository.findByIdOptional(id)
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado: " + id));
    }

    public List<AlertaProativo> getAll() {
        return alertaProativoRepository.listAll();
    }

    @Transactional
    public void delete(Long id) {
        if (alertaProativoRepository.findByIdOptional(id).isEmpty()) {
            throw new RuntimeException("Alerta não encontrado para deletar: " + id);        }
        alertaProativoRepository.deleteById(id);
    }
}