package br.com.fiap.repository;

import br.com.fiap.model.Login;
import io.quarkus.hibernate.orm.panache.PanacheRepository; // Para IDs Long
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoginRepository implements PanacheRepository<Login> {
    public Login findByUsuarioAndSenha(String usuario, String senha) {
        return find("usuario = ?1 AND senha = ?2", usuario, senha).firstResult();}
}