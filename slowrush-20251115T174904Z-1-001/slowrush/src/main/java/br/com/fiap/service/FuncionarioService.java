package br.com.fiap.service;

import br.com.fiap.model.Funcionario;
import br.com.fiap.repository.FuncionarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class FuncionarioService {

    @Inject
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public Funcionario registrarAcesso(String email, boolean sucesso) {
        Funcionario funcionario = getById(email);

        if (!funcionario.isAtivo()) {
            throw new RuntimeException("Usuário inativo! Não é possível registrar acesso.");
        }

        if (sucesso) {
            funcionario.setUltimoAcesso(LocalDateTime.now());
            funcionario.setTotalAcessos(funcionario.getTotalAcessos() + 1);
            funcionario.setTentativasFalhas(0);
        } else {
            funcionario.setTentativasFalhas(funcionario.getTentativasFalhas() + 1);
            if (funcionario.getTentativasFalhas() >= 3) {
                funcionario.setAtivo(false);
            }
        }

        funcionarioRepository.persist(funcionario);
        return funcionario;
    }

    @Transactional
    public Funcionario create(Funcionario funcionario) {
        if (funcionarioRepository.findByIdOptional(funcionario.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado!");
        }
        funcionarioRepository.persist(funcionario);
        return funcionario;
    }

    public Funcionario getById(String email) {
        return funcionarioRepository.findByIdOptional(email)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado: " + email));
    }

    public List<Funcionario> getAll() {
        return funcionarioRepository.listAll();
    }

    @Transactional
    public void delete(String email) {
        if (funcionarioRepository.findByIdOptional(email).isEmpty()) {
            throw new RuntimeException("Funcionário não encontrado para deletar: " + email);
        }
        funcionarioRepository.deleteById(email);
    }

    @Transactional
    public Funcionario update(String email, Funcionario funcionarioAtualizado) {
        Funcionario funcionarioExistente = getById(email);

        funcionarioExistente.setNome(funcionarioAtualizado.getNome());
        funcionarioExistente.setAtivo(funcionarioAtualizado.isAtivo());

        funcionarioRepository.persist(funcionarioExistente);
        return funcionarioExistente;
    }
}