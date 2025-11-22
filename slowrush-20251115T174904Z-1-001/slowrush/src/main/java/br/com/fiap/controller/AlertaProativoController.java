package br.com.fiap.controller;

import br.com.fiap.model.AlertaProativo;
import br.com.fiap.service.AlertaProativoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/alertas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlertaProativoController {

    @Inject
    private AlertaProativoService alertaProativoService;

    @POST
    public Response create(AlertaProativo alerta) {
        AlertaProativo a = alertaProativoService.create(alerta);
        return Response.status(Response.Status.CREATED).entity(a).build();
    }

    @GET
    public Response getAll() {
        List<AlertaProativo> alertas = alertaProativoService.getAll();
        return Response.ok(alertas).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        AlertaProativo a = alertaProativoService.getById(id);
        return Response.ok(a).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        alertaProativoService.delete(id);
        return Response.noContent().build();
    }

    @POST
    @Path("/{id}/confirmar-recebimento")
    public Response confirmarRecebimento(@PathParam("id") Long id) {
        AlertaProativo a = alertaProativoService.confirmarRecebimento(id);
        return Response.ok(a).build();
    }
}