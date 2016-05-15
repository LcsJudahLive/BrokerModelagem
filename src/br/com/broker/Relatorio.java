package br.com.broker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.broker.dbconnect.ConnectionFactory;

@WebServlet("/relatorio")
public class Relatorio extends HttpServlet{
	private String tipoRelatorio;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public List<Acao> consultar(HttpSession session) throws SQLException{
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.getConnection();
		PreparedStatement stmt;
		ResultSet rs;
		List<Acao> acoes = new ArrayList<Acao>();
		if(this.tipoRelatorio == "individual"){
			stmt = con.prepareStatement("select sigla,codigo_empresa,quantidade,preco from carteira where sigla=?");
			stmt.setString(1, session.getAttribute("nome").toString());
			rs = stmt.executeQuery();
			while(rs.next()){
				Acao acao = new Acao();
				acao.setCodigo_empresa(rs.getString("codigo_empresa"));
				acao.setSigla(rs.getString("sigla"));
				acao.setQuantidade(rs.getInt("quantidade"));
				acao.setPreco(rs.getFloat("preco"));
				acoes.add(acao);
			}
			
		}
		else if(this.tipoRelatorio == "consolidado"){
			stmt = con.prepareStatement("select sigla,codigo_empresa,quantidade,preco from carteira");
			rs = stmt.executeQuery();
			while(rs.next()){
				Acao acao = new Acao();
				acao.setCodigo_empresa(rs.getString("codigo_empresa"));
				acao.setSigla(rs.getString("sigla"));
				acao.setQuantidade(rs.getInt("quantidade"));
				acao.setPreco(rs.getFloat("preco"));
				acoes.add(acao);
			}
		}
		
		return acoes;
	}
	public void setTipo(String tipo){
		this.tipoRelatorio = tipo;
	}
	public String getTipo(){
		return this.tipoRelatorio;
	}
}
