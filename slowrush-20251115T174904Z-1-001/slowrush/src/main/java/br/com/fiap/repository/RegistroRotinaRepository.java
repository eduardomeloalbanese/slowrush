package br.com.fiap.repository;

import br.com.fiap.model.RegistroRotina;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RegistroRotinaRepository implements PanacheRepository<RegistroRotina> {
    // O Panache já faz tudo sozinho :)
}