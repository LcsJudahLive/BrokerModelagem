package br.com.broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.broker.dbconnect.ConnectionFactory;

public class Conta_Corrente {
	private float saldo;
	
	public void creditar(double credito,String sigla) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("update conta set valor_conta = valor_conta + ? where sigla=?");
		stmt.setString(2,sigla);
		stmt.setDouble(1, credito);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void debitar(double debito,String sigla) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("debitando...");
		PreparedStatement stmt = con.prepareStatement("update conta set valor_conta = valor_conta-? where sigla=?");
		stmt.setString(2,sigla);
		stmt.setDouble(1, debito);
		stmt.execute();
		stmt.close();
		con.close();
	}
	public float consultar_saldo(String sigla) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		System.out.println(sigla);
		PreparedStatement stmt = con.prepareStatement("select valor_conta from conta where sigla=?");
		stmt.setString(1, sigla);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		System.out.println(rs.getDouble("valor_conta"));
		this.saldo = (float) rs.getDouble("valor_conta");
		return this.saldo;		
	}
	

}
