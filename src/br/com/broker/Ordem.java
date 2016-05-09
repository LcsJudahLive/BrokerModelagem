package br.com.broker;

import java.io.IOException;
import java.net.UnknownHostException;

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
		}
	}
	
	public void emitir(HttpServletRequest request,HttpServletResponse response) throws JSONException, UnknownHostException, IOException{
		JSONObject json = new JSONObject();
		HelloSpring test = new HelloSpring();
		System.out.println(request.getParameter("tipo"));
		System.out.println(request.getParameter("nome"));
		String arg = request.getParameter("tipo");
		
		if(arg.equals("compra")){
			//faz operação de compra
			
		}
		if(arg.equals("venda")){
		//faz operação de venda
		
		System.out.println("vendeu");
		System.out.println(request.getCookies());
		json.put("codigo_empresa", request.getParameter("codigo_empresa"));
		json.put("tipo", request.getParameter("tipo"));
		json.put("qtd", request.getParameter("quantidade"));
		json.put("preco", request.getParameter("preco"));
		json.put("cpf",request.getParameter("nome"));
		
		
		}	
	}
	
	public float setpreco(){
		return (float) 34.40;
	}
	
	
}
