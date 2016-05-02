package br.com.broker;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.support.RequestDataValueProcessor;
/*
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
*/

@WebServlet("/hi")
public class HelloSpring extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		RequestDispatcher rq;
		rq = request.getRequestDispatcher("/ok.jsp");
		rq.forward(request, response);
	}
	
	
	public void parseJSON(JSONObject json) throws JSONException{
		System.out.println(json.get("codigo_empresa"));
		
	}
	
}
