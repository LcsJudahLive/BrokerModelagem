package br.com.broker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.broker.dbconnect.ConnectionFactory;

public class Carteira {
	public int consultar_carteira(String sigla, String empresa) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		System.out.println(sigla);
		PreparedStatement stmt = con.prepareStatement("select quantidade from carteira where sigla=? and codigo_empresa=?");
		stmt.setString(1, sigla);
		stmt.setString(2, empresa);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		System.out.println(rs.getDouble("quantidade"));
		return rs.getInt("quantidade");
	}
	
	public void remover(int quantidade,String empresa,String sigla) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("removendo...");
		PreparedStatement stmt = con.prepareStatement("update carteira set quantidade = quantidade - ? where sigla=? and codigo_empresa=?");
		stmt.setInt(1, quantidade);
		stmt.setString(2, sigla);
		stmt.setString(3, empresa);
		stmt.execute();
		stmt.close();
		con.close();
	}
	
	public void adicionar(int quantidade, String empresa,String sigla) throws SQLException{
		Connection con = new ConnectionFactory().getConnection();
		System.out.println("removendo...");
		PreparedStatement stmt = con.prepareStatement("update carteira set quantidade = quantidade + ? where sigla=? and codigo_empresa=?");
		stmt.setInt(1, quantidade);
		stmt.setString(2, sigla);
		stmt.setString(3, empresa);
		stmt.execute();
		stmt.close();
		con.close();
	}
}
