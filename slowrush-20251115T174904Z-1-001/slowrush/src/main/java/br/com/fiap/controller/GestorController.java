package br.com.fiap.controller;

import br.com.fiap.model.Gestor;
import br.com.fiap.service.GestorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/gestores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GestorController {

    @Inject
    private GestorService gestorService;

    @POST
    public Response create(Gestor gestor) {
        Gestor g = gestorService.create(gestor);
        return Response.status(Response.Status.CREATED).entity(g).build();
    }

    @GET
    public Response getAll() {
        List<Gestor> gestores = gestorService.getAll();
        return Response.ok(gestores).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Gestor g = gestorService.getById(id);
        return Response.ok(g).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        gestorService.delete(id);
        return Response.noContent().build();
    }
}