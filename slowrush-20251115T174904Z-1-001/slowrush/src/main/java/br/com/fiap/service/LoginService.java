package br.com.fiap.service;

import br.com.fiap.model.Login;
import br.com.fiap.repository.LoginRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LoginService {

    @Inject
    private LoginRepository loginRepository;

    public Login validarLogin(String usuario, String senha) {
        Login login = loginRepository.findByUsuarioAndSenha(usuario, senha);

        if (login == null) {
            throw new RuntimeException("Usuário ou senha inválidos");
        }
        return login;
    }
}