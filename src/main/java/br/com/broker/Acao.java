package br.com.broker;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/acao")
public class Acao {
    private int quantidade;
    private int silga_acao;
    private int preco_atual;

    public int getQuantidade() {
	return quantidade;
    }

    public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
    }

    public int getSilga_acao() {
	return silga_acao;
    }

    public void setSilga_acao(int silga_acao) {
	this.silga_acao = silga_acao;
    }

    public int getPreco_atual() {
	return preco_atual;
    }

    public void setPreco_atual(int preco_atual) {
	this.preco_atual = preco_atual;
    }

    @Path("/lista")
    public Response lista() {
	return null;
    }

    @Path("/atualizar_preco")
    public Response atualizar_preco() {
	return null;
    }
}
