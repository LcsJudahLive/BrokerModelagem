package br.com.broker;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/carteira")
public class Carteira {
    @Path("/consultar")
    public Response consultar() {
	return null;
    }

    @Path("/adicionar")
    public Response adicionar() {
	return null;
    }

    @Path("/remover")
    public Response remover() {
	return null;
    }
}
