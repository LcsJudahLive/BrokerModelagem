package br.com.broker;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/relatorio")
public class Relatorio {
    private String tipoRelatorio;

    public String getTipoRelatorio() {
	return tipoRelatorio;
    }

    public void setTipoRelatorio(String tipoRelatorio) {
	this.tipoRelatorio = tipoRelatorio;
    }

    @Path("/consultar")
    public Response consultar() {
	return null;
    }
}
