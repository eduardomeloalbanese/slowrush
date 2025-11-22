package br.com.fiap.controller;

import br.com.fiap.model.Funcionario;
import br.com.fiap.service.FuncionarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/funcionarios") // Substitui @RestController e @RequestMapping
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FuncionarioController {

    @Inject
    private FuncionarioService funcionarioService;

    @POST
    public Response create(Funcionario funcionario) { // <-- Saiu o @RequestBody
        Funcionario f = funcionarioService.create(funcionario);
        return Response.status(Response.Status.CREATED).entity(f).build();
    }

    @GET
    public Response getAll() {
        List<Funcionario> funcionarios = funcionarioService.getAll();
        return Response.ok(funcionarios).build(); // Substitui o ResponseEntity.ok
    }

    @GET
    @Path("/{email}")
    public Response getById(@PathParam("email") String email) {
        Funcionario f = funcionarioService.getById(email);
        return Response.ok(f).build();
    }

    @PUT
    @Path("/{email}")
    public Response update(@PathParam("email") String email, Funcionario funcionario) {
        Funcionario f = funcionarioService.update(email, funcionario);
        return Response.ok(f).build();
    }

    @DELETE
    @Path("/{email}")
    public Response delete(@PathParam("email") String email) {
        funcionarioService.delete(email);
        return Response.noContent().build();
    }

    @POST
    @Path("/{email}/registrar-acesso")
    public Response registrarAcesso(
            @PathParam("email") String email,
            @QueryParam("sucesso") boolean sucesso) {

        Funcionario f = funcionarioService.registrarAcesso(email, sucesso);
        return Response.ok(f).build();
    }
}