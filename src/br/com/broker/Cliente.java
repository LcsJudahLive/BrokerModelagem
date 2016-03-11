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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.broker.dbconnect.ConnectionFactory;

@WebServlet("/autenticar")
public class Cliente extends HttpServlet{
	private String sigla;
	private String senha;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Aut 1");
		setSigla(request.getParameter("sigla"));
		MessageDigest alg;
		try {
			alg = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = alg.digest(request.getParameter("senha").getBytes("UTF-8"));
			String hash = new String(messageDigest,"UTF-8");
			setSenha(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rq;
		if(autenticar())
			rq = request.getRequestDispatcher("/home.html");
		else
			rq = request.getRequestDispatcher("/erro-login.html");
		
		rq.forward(request, response);
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
	
	public boolean autenticar(){
		try{
			//System.out.println(getSenha());
			//System.out.println("Autenticando...");
			Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from login where sigla =? and password =?");
			stmt.setString(1,getSigla());
			stmt.setString(2,getSenha());
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			ResultSet rs = stmt.executeQuery();	
			if (rs.next())	
				if(md.isEqual(getSenha().getBytes(),rs.getString("password").getBytes()))
					return true;
				else
					return false;
			else
				return false;
		
		}catch(Exception e){
			throw new RuntimeException(e);
			
		}
				
	}
	
}
