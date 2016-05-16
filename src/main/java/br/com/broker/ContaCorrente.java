package br.com.broker;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/conta_corrente")
public class ContaCorrente {
    private float saldo;
    private float deposito_futuro;

    public float getSaldo() {
	return saldo;
    }

    public void setSaldo(float saldo) {
	this.saldo = saldo;
    }

    public float getDeposito_futuro() {
	return deposito_futuro;
    }

    public void setDeposito_futuro(float deposito_futuro) {
	this.deposito_futuro = deposito_futuro;
    }

    @Path("/consultar_saldo")
    public Response consultar_saldo() {
	return null;
    }

    @Path("/creditar")
    public Response creditar() {
	return null;
    }

    @Path("/debitar")
    public Response debitar() {
	return null;
    }
}
