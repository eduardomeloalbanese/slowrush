package br.com.fiap.repository;

import br.com.fiap.model.Funcionario;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FuncionarioRepository implements PanacheRepositoryBase<Funcionario, String> {


}