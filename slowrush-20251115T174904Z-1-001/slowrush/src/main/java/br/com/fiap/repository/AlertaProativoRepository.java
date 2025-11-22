package br.com.fiap.repository;

import br.com.fiap.model.AlertaProativo;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlertaProativoRepository implements PanacheRepository<AlertaProativo> {

}