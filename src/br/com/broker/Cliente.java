package br.com.broker;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;

import br.com.broker.dbconnect.ConnectionFactory;

@WebServlet("/autenticar")
public class Cliente extends HttpServlet{
	private String sigla;
	private String senha;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//System.out.println(request.getParameter("operacao"));
		if(request.getParameter("operacao").equals("cadastro")){
			try {
				System.out.println("cadastro");
				cadastrar(request,response);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Aut 1");
		Cliente cliente = new Cliente();
		cliente.setSigla(request.getParameter("sigla"));
		cliente.setSenha(request.getParameter("senha"));
		//RequestDispatcher rq;
		if(autenticar(cliente)){
			//rq = request.getRequestDispatcher("/menu.jsp");
			HttpSession session = request.getSession();
			session.setAttribute("nome", cliente.getSigla());
			session.setMaxInactiveInterval(10*60);
			Monitor monitor = new Monitor();
			/*Starta a thread de monitoramento das mensagens de efetivação
			de compra e venda vindas do DealBroker*/
			//monitor.start(); 
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
	
	public boolean cadastrar(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException, SQLException{
		//System.out.println("cadastro");
		Socket cliente = new Socket("10.104.8.129",5000);
		PrintStream saida = new PrintStream(cliente.getOutputStream());
		Scanner entrada = new Scanner(cliente.getInputStream());
		JSONObject json = new JSONObject();
		json.put("cpf",request.getParameter("nome"));
		saida.println(json);
		JSONObject retornocliente = new JSONObject(entrada.nextLine());
		
		
		if(retornocliente.getString("status")=="true"){
			ConnectionFactory fabrica = new ConnectionFactory();
			Connection con = fabrica.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into login (sigla,password) values(?,?)");
			stmt.setString(1, request.getParameter("nome"));
			stmt.setString(2, request.getParameter("senha"));
			stmt.executeQuery();
			stmt = con.prepareStatement("insert into conta (sigla,valor_conta) values (?,?)");
			stmt.setString(1, request.getParameter("nome"));
			stmt.setFloat(2, (float) 0.00);
			stmt.executeQuery();
			con.close();
			response.sendRedirect("login_sucess.jsp");
		}
		else
			response.sendRedirect("erro_login.jsp");
		
		//saida.println();
		
		
		System.out.println(json.get("codigo_empresa"));
		entrada.close();
		saida.close();
		cliente.close();
		
		
		return true;
	}
	
}
