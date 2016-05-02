package br.com.broker;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.broker.dbconnect.ConnectionFactory;

@WebServlet("/autenticar")
public class Cliente extends HttpServlet{
	private String sigla;
	private String senha;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Aut 1");
		Cliente cliente = new Cliente();
		cliente.setSigla(request.getParameter("sigla"));
		cliente.setSenha(request.getParameter("senha"));
		//RequestDispatcher rq;
		if(autenticar(cliente)){
			//rq = request.getRequestDispatcher("/menu.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("nome", cliente.getSigla());
			Cookie user = new Cookie("user",cliente.getSigla());
			response.addCookie(user);
			String URL = response.encodeRedirectURL("menu.jsp");
			response.sendRedirect(URL);
		}
		else{
			String URL = response.encodeRedirectURL("erro-login.html");
			response.sendRedirect(URL);
		}
		
		
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public boolean autenticar(Cliente cliente){
		try{
			//System.out.println(getSenha());
			System.out.println("Autenticando...");
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from login where sigla =? and password =?");
			stmt.setString(1,cliente.getSigla());
			stmt.setString(2,cliente.getSenha());
			ResultSet rs = stmt.executeQuery();	
			if (rs.next())	
				return true;
			else
				return false;
		}catch(Exception e){
			throw new RuntimeException(e);
			
		}
				
	}
	
}
