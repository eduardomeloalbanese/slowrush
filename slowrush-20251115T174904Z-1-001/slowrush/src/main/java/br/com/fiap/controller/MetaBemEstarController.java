package br.com.fiap.controller;

import br.com.fiap.model.MetaBemEstar;
import br.com.fiap.service.MetaBemEstarService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/metas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MetaBemEstarController {

    @Inject
    private MetaBemEstarService metaBemEstarService;

    @POST
    public Response create(MetaBemEstar meta) {
        MetaBemEstar m = metaBemEstarService.create(meta);
        return Response.status(Response.Status.CREATED).entity(m).build();
    }

    @GET
    public Response getAll() {
        List<MetaBemEstar> metas = metaBemEstarService.getAll();
        return Response.ok(metas).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        MetaBemEstar m = metaBemEstarService.getById(id);
        return Response.ok(m).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        metaBemEstarService.delete(id);
        return Response.noContent().build();
    }

    @POST
    @Path("/{id}/atualizar-progresso")
    public Response atualizarProgresso(
            @PathParam("id") Long id,
            @QueryParam("progresso") int progresso) {

        MetaBemEstar m = metaBemEstarService.atualizarProgresso(id, progresso);
        return Response.ok(m).build();
    }
}