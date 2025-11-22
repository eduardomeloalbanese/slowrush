package br.com.fiap.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<RuntimeException> {

    @Override
    public Response toResponse(RuntimeException exception) {

        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;

        String mensagem = exception.getMessage();

        if (mensagem.contains("não encontrado")) {
            status = Response.Status.NOT_FOUND;
        }

        if (mensagem.contains("já cadastrado") ||
        mensagem.contains("inválidos") ||
        mensagem.contains("negativo") ||
                mensagem.contains("já havia sido confirmado"))
        {
            status = Response.Status.BAD_REQUEST;
        }

        return Response
                .status(status)
                .entity(new RestError(mensagem)) // Usa o "record" RestError
                .build();
    }
}