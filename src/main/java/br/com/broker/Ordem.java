package br.com.broker;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/ordem")
public class Ordem {
    private String empresa;
    private int num_acoes;
    private float preco;
    private String tipoOrdem;

    public String getEmpresa() {
	return empresa;
    }

    public void setEmpresa(String empresa) {
	this.empresa = empresa;
    }

    public int getNum_acoes() {
	return num_acoes;
    }

    public void setNum_acoes(int num_acoes) {
	this.num_acoes = num_acoes;
    }

    public float getPreco() {
	return preco;
    }

    public void setPreco(float preco) {
	this.preco = preco;
    }

    public String getTipoOrdem() {
	return tipoOrdem;
    }

    public void setTipoOrdem(String tipoOrdem) {
	this.tipoOrdem = tipoOrdem;
    }

    @Path("/consultar_saldo")
    public Response consultar_saldo() {
	return null;
    }

    @Path("/emitir")
    public Response emitir() {
	return null;
    }
}
