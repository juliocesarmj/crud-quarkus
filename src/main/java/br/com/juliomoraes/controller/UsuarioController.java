package br.com.juliomoraes.controller;

import br.com.juliomoraes.entity.Usuario;
import br.com.juliomoraes.service.UsuarioService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class UsuarioController {

    UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @POST
    public Response novoUsuario(Usuario usuario) {
        return Response.status(Response.Status.CREATED).entity(service.novoUsuario(usuario)).build();
    }

    @GET
    public Response listarUsuarios(@QueryParam("pageSize") @DefaultValue("10") Integer pageSize,
                                   @QueryParam("page") @DefaultValue("0") Integer page) {
        return Response.ok(service.listarUsuarios(page, pageSize)).build();
    }

    @GET
    @Path("/{usuarioId}")
    public Response buscarUsuario(@PathParam("usuarioId") UUID usuarioId) {
        return Response.ok(service.buscarUsuario(usuarioId)).build();
    }

    @PUT
    @Path("/{usuarioId}")
    public Response atualizarUsuario(@PathParam("usuarioId") UUID usuarioId, Usuario usuario) {
        return Response.ok(service.atualizarUsuario(usuarioId, usuario)).build();
    }

    @DELETE
    @Path("/{usuarioId}")
    public Response excluirUsuario(@PathParam("usuarioId") UUID usuarioId) {
        service.excluirUsuario(usuarioId);
        return Response.noContent().build();
    }
}
