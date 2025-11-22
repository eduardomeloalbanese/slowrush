package br.com.fiap.controller;

import br.com.fiap.dto.CheckoutDTO;
import br.com.fiap.dto.FeedbackCheckOutDTO;
import br.com.fiap.model.RegistroRotina;
import br.com.fiap.service.RegistroRotinaService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/checkouts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CheckoutController {

    @Inject
    RegistroRotinaService registroRotinaService;

    // LISTAR TODOS (GET)
    @GET
    public Response getCheckouts() {
        try {
            List<CheckoutDTO> lista = registroRotinaService.listarCheckoutsFormatados();
            return Response.ok(lista).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao listar: " + e.getMessage()).build();
        }
    }

    // BUSCAR UM ESPECÍFICO (GET /{id})
    @GET
    @Path("/{id}")
    public Response getCheckoutById(@PathParam("id") Long id) {
        try {
            RegistroRotina registro = registroRotinaService.findById(id); // Você precisará adicionar esse método no Service
            if (registro == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Registro não encontrado").build();
            }
            // Converte para DTO se necessário, ou retorna direto se o Service já fizer isso
            return Response.ok(registro).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao buscar: " + e.getMessage()).build();
        }
    }

    // CRIAR NOVO (POST)
    @POST
    public Response criarCheckout(RegistroRotina registro) {
        try {
            System.out.println("Recebendo checkout: " + registro.toString());
            FeedbackCheckOutDTO resultado = registroRotinaService.realizarCheckOut(registro);
            return Response.ok(resultado).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao salvar: " + e.getMessage()).build();
        }
    }

    // ATUALIZAR (PUT /{id})
    @PUT
    @Path("/{id}")
    public Response atualizarCheckout(@PathParam("id") Long id, RegistroRotina registroAtualizado) {
        try {
            // Lógica básica: garantir que o ID do objeto bate com o da URL
            registroAtualizado.setId(id);

            // Chama o service para atualizar (você precisará criar esse método no service)
            registroRotinaService.atualizar(registroAtualizado);

            return Response.ok("Registro atualizado com sucesso").build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao atualizar: " + e.getMessage()).build();
        }
    }

    // DELETAR (DELETE /{id})
    @DELETE
    @Path("/{id}")
    public Response deletarCheckout(@PathParam("id") Long id) {
        try {
            // Chama o service para deletar (você precisará criar esse método no service)
            boolean deletado = registroRotinaService.deletar(id);

            if (deletado) {
                return Response.noContent().build(); // 204 No Content é padrão para delete com sucesso
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Registro não encontrado para deletar").build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().entity("Erro ao deletar: " + e.getMessage()).build();
        }
    }
}