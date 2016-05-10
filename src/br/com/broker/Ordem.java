package br.com.broker;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/emitir")
public class Ordem extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("emitir");
			emitir(request,response);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.println("emitirerro");
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void emitir(HttpServletRequest request,HttpServletResponse response) throws JSONException, UnknownHostException, IOException, SQLException{
		JSONObject json = new JSONObject();
		HelloSpring test = new HelloSpring();
		System.out.println(request.getParameter("tipo"));
		System.out.println(request.getParameter("nome"));
		String arg = request.getParameter("tipo");
		
		if(arg.equals("venda")){
			//faz operação de venda
			Carteira carteira = new Carteira();
			int qtdacoes = carteira.consultar_carteira(request.getParameter("nome"),request.getParameter("codigo_empresa"));
			if(qtdacoes >= Integer.parseInt(request.getParameter("quantidade"))){
				json.put("codigo_empresa", request.getParameter("codigo_empresa"));
				json.put("tipo", request.getParameter("tipo"));
				json.put("qtd", request.getParameter("quantidade"));
				json.put("preco", request.getParameter("preco"));
				json.put("cpf",request.getParameter("nome"));
				HelloSpring hello = new HelloSpring();
				hello.parseJSON(json);
				
				//operação de remoção de ações deve ser feita quando se recebe resposta do DealBroker
				carteira.remover(Integer.parseInt(request.getParameter("quantidade")), request.getParameter("codigo_empresa"),request.getParameter("nome"));
				response.sendRedirect("menu.jsp");
			}
			else{
				throw new RuntimeException("Voce nao tem acoes suficientes para este papel");
			}
			
			
		}
		if(arg.equals("compra")){
		//faz operação de compra
		Conta_Corrente conta = new Conta_Corrente();
		float saldo = conta.consultar_saldo(request.getParameter("nome"));
		if(saldo >= (Integer.parseInt(request.getParameter("quantidade")) * Float.valueOf(request.getParameter("preco"))) ){
			System.out.println("venda");
			json.put("codigo_empresa", request.getParameter("codigo_empresa"));
			json.put("tipo", request.getParameter("tipo"));
			json.put("qtd", request.getParameter("quantidade"));
			json.put("preco", request.getParameter("preco"));
			json.put("cpf",request.getParameter("nome"));
			HelloSpring hello = new HelloSpring();
			hello.parseJSON(json);
			conta.debitar((double)(Integer.parseInt(request.getParameter("quantidade")) * Float.valueOf(request.getParameter("preco"))), request.getParameter("nome"));
			response.sendRedirect("menu.jsp");
		}
		else{
			System.out.println("voce nao tem saldo suficiente");
			throw new RuntimeException("voce nao tem saldo suficiente");
		}
		
		
		
		}	
	}
	
	public float setpreco(){
		return (float) 34.40;
	}
	
	
}
