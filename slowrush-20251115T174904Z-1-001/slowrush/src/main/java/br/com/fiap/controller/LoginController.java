package br.com.fiap.controller;

import br.com.fiap.model.Login;
import br.com.fiap.service.LoginService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginController {

    @Inject
    private LoginService loginService;

    @POST
    public Response validarLogin(Login loginRequest) {
        Login login = loginService.validarLogin(loginRequest.getUsuario(), loginRequest.getSenha());
        return Response.ok(login).build();
    }
}