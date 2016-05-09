package br.com.broker;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/relatorio")
public class Relatorio extends HttpServlet{
	private String tipoRelatorio;
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
	}
	
	public void consultar(){
		if(this.tipoRelatorio == "individual"){
			
		}
		else if(this.tipoRelatorio == "consolidado"){
			
		}
		
		
	}
	public void setTipo(String tipo){
		this.tipoRelatorio = tipo;
	}
	public String getTipo(){
		return this.tipoRelatorio;
	}
}
