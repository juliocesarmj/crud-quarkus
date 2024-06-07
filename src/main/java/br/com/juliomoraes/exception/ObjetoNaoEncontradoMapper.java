package br.com.juliomoraes.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ObjetoNaoEncontradoMapper implements ExceptionMapper<ObjetoNaoEncontradoException> {
    @Override
    public Response toResponse(ObjetoNaoEncontradoException exception) {
        return Response.status(Response.Status.NOT_FOUND).entity("Resultado não encontrado").build();
    }
}
