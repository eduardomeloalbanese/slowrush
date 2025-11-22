package br.com.fiap.repository;

import br.com.fiap.model.MetaBemEstar;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MetaBemEstarRepository implements PanacheRepository<MetaBemEstar> {

}