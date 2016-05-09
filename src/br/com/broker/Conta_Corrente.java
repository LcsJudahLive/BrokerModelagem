package br.com.broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.broker.dbconnect.ConnectionFactory;

public class Conta_Corrente {
	private float saldo;
	
	public void creditar(float credito,String sigla) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("update conta set valor_conta = valor_conta + ? where sigla=?");
		stmt.setString(2,sigla);
		stmt.setFloat(1, credito);
		stmt.executeQuery();
		stmt.close();
		con.close();
	}
	
	public void debitar(float debito,String sigla) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("update conta set valor_conta = valor_conta - ? where sigla=?");
		stmt.setString(2,sigla);
		stmt.setFloat(1, debito);
		stmt.executeQuery();
		stmt.close();
		con.close();
	}
	public float consultar_saldo(String sigla) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("select valor_conta where sigla=?");
		stmt.setString(1, sigla);
		ResultSet rs = stmt.executeQuery();
		this.saldo = rs.getFloat("valor_conta");
		return saldo;		
	}
	

}
