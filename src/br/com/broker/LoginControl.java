package br.com.broker;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class LoginControl {
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Cliente usuario, HttpSession session){
		Cliente cliente = new Cliente();
		if(cliente.autenticar(usuario)){
			session.setAttribute("usuario logado", usuario);
			return "menu";
		}
			return "redirect:loginForm";
	}
	@RequestMapping("loginForm")
	public String loginForm(){
		System.out.println("Chamou");
		return "ok";
	}
}



