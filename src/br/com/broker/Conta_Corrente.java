package br.com.broker;

import com.mysql.jdbc.Connection;

import br.com.broker.dbconnect.ConnectionFactory;

public class Conta_Corrente {
	private int saldo;
	
	public void creditar(float credito,String sigla){
		Connection con = new ConnectionFactory().getConnection();
		
	}
	
	public void debitar(float debito,String sigla){
		
		
	}
	public void consultar_saldo(){
		
		
	}
	

}
