package br.com.broker.listener;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ordem")
public class OrdemListener extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getCookies());
		System.out.println("ordemlistener");
		RequestDispatcher rq;
		rq = request.getRequestDispatcher("ordem.jsp");
		rq.forward(request, response);
	}
}
