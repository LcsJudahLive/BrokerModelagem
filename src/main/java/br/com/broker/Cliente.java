package br.com.broker;

import static br.com.broker.configuration.DealBrokerRequests.CLIENTE_CADASTRAR;

import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;

import br.com.broker.configuration.ConnectionFactory;

@Path("/cliente")
public class Cliente {
	private final Client client = ClientBuilder.newClient();
	private final Realm realm = new JdbcRealm();
	private final SecurityManager sm = new DefaultSecurityManager(realm);

	private String cpf;
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("/autenticar")
	public Response autenticar(@FormParam("cpf") String cpf, @FormParam("password") String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(cpf, password);
		SecurityUtils.setSecurityManager(sm);
		Subject currentUser = SecurityUtils.getSubject();

		try {
			currentUser.login(token);
			return Response.temporaryRedirect(URI.create("/../private/index.jsp")).build();
		} catch (Exception e) {
			return Response.temporaryRedirect(URI.create("/../public/avisos/erro_login.html")).build();
		}
	}

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("/cadastrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(@FormParam("cpf") String cpf, @FormParam("password") String password)
			throws SQLException {
		WebTarget webTarget = client.target(CLIENTE_CADASTRAR.getUrl());

		Response response = webTarget.request(MediaType.APPLICATION_JSON)
				.post(Entity.json(CLIENTE_CADASTRAR.getFormattedJson(cpf, password)));

		if (response.getStatus() == 200) {
			ConnectionFactory fabrica = new ConnectionFactory();
			Connection con = fabrica.getConnection();
			PreparedStatement stmt = con.prepareStatement("insert into login (cpf,password) values(?,?)");
			stmt.setString(1, cpf);
			stmt.setString(2, password);
			stmt.executeUpdate();
			stmt = con.prepareStatement("insert into conta (cpf,valor_conta) values (?,?)");
			stmt.setString(1, cpf);
			stmt.setFloat(2, (float) 0.00);
			stmt.executeUpdate();
			con.close();

			return Response.temporaryRedirect(URI.create("http://localhost:8080/public/avisos/sucesso_cadastro.html"))
					.build();
		} else {
			return Response
					.temporaryRedirect(URI.create("http://localhost:8080/public/avisos/internal_server_error.html"))
					.build();
		}
	}
}
