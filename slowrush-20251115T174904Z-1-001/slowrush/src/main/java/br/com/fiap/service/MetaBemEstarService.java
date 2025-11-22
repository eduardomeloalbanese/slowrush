package br.com.fiap.service;

import br.com.fiap.model.MetaBemEstar;
import br.com.fiap.repository.MetaBemEstarRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MetaBemEstarService {

    @Inject
    private MetaBemEstarRepository metaBemEstarRepository;

    @Transactional
    public MetaBemEstar atualizarProgresso(Long id, int novoProgresso) {
        MetaBemEstar meta = getById(id); // Reutiliza o getById

        if (novoProgresso < 0) {
            throw new RuntimeException("O progresso não pode ser negativo.");
        }

        if (novoProgresso > meta.getValorMeta()) {
            throw new RuntimeException("Progresso não pode ser maior que o valor da meta.");
        }

        meta.setProgressoAtual(novoProgresso);
        metaBemEstarRepository.persist(meta);
        return meta;
    }

    @Transactional
    public MetaBemEstar create(MetaBemEstar meta) {
        metaBemEstarRepository.persist(meta);
        return meta;
    }

    public MetaBemEstar getById(Long id) {
        return metaBemEstarRepository.findByIdOptional(id)
                .orElseThrow(() -> new RuntimeException("Meta não encontrada: " + id));
    }

    public List<MetaBemEstar> getAll() {
        return metaBemEstarRepository.listAll();
    }

    @Transactional
    public void delete(Long id) {
        if (metaBemEstarRepository.findByIdOptional(id).isEmpty()) {
            throw new RuntimeException("Meta não encontrada para deletar: " + id);
        }
        metaBemEstarRepository.deleteById(id);
    }
}