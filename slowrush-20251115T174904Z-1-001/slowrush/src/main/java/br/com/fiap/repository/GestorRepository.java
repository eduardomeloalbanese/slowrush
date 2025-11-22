package br.com.fiap.repository;

import br.com.fiap.model.Gestor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GestorRepository implements PanacheRepository<Gestor> {

}