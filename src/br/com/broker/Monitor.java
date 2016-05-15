package br.com.broker;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class Monitor extends Thread{
	@Override
	public void run()  {
		try {
			monitor();
		} catch (IOException | JSONException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void monitor() throws UnknownHostException, IOException, JSONException, SQLException{
		Socket cliente = new Socket("10.104.8.129",5000);
		Scanner entrada = new Scanner(cliente.getInputStream());
		JSONObject retornocliente = new JSONObject(entrada.nextLine());
		if(retornocliente.getString("status")=="1" && retornocliente.getString("tipo")=="venda"){
			Carteira carteira = new Carteira();
			Conta_Corrente conta = new Conta_Corrente();
			carteira.remover(retornocliente.getInt("quantidade"), retornocliente.getString("codigo_empresa"), retornocliente.getString("sigla"));
			conta.creditar((retornocliente.getDouble("preco")*retornocliente.getInt("quantidade")),retornocliente.getString("sigla"));			
		}
		else if(retornocliente.getString("status")=="1" && retornocliente.getString("tipo")=="compra"){
			Carteira carteira = new Carteira();
			Conta_Corrente conta = new Conta_Corrente();
			carteira.adicionar(retornocliente.getInt("quantidade"), retornocliente.getString("codigo_empresa"), retornocliente.getString("sigla"));
			conta.debitar((retornocliente.getDouble("preco")*retornocliente.getInt("quantidade")),retornocliente.getString("sigla"));
		}
		
	}
	
}
