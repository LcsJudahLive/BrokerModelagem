package br.com.broker;

import java.io.IOException;

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
	
	public void emitir(HttpServletRequest request,HttpServletResponse response) throws JSONException{
		JSONObject json = new JSONObject();
		HelloSpring test = new HelloSpring();
		System.out.println(request.getParameter("tipo"));
		String arg = request.getParameter("tipo");
		
		/*if(arg == "compra"){
			//faz operação de compra
		}*/
		if(arg.toString() == "venda"){
			//faz operação de venda
		System.out.println("vendeu");
			
		json.put("codigo_empresa", "PTR004");
		json.put("qtd", 500);
		json.put("preco", 34.30);
		json.put("cpf","3423434622");
		test.parseJSON(json);
		}	
	}
	
	public float setpreco(){
		return (float) 34.40;
	}
	
	
}
