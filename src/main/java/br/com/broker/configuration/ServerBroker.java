package br.com.broker.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.apache.shiro.web.env.EnvironmentLoaderListener;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.spi.container.servlet.ServletContainer;

public class ServerBroker {
	private static final int DEFAULT_PORT = 8080;

	public static void main(String[] args) {
		ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		servletContextHandler.addEventListener(new EnvironmentLoaderListener());
		servletContextHandler.addFilter(ShiroFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
		servletContextHandler.setContextPath("/");
		servletContextHandler.setWelcomeFiles(new String[] { "public/login.jsp" });

		ServletHolder defaultServlet = servletContextHandler.addServlet(DefaultServlet.class, "/*");
		defaultServlet.setInitParameter("resourceBase", "src/main/webapp");
		defaultServlet.setInitParameter("pathInfoOnly", "true");

		ServletHolder jerseyServlet = servletContextHandler.addServlet(ServletContainer.class, "/rest/*");
		jerseyServlet.setInitOrder(1);
		jerseyServlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
		jerseyServlet.setInitParameter("com.sun.jersey.config.property.packages", "br.com.broker");

		try {
			Server server = new Server(DEFAULT_PORT);
			server.setHandler(servletContextHandler);
			server.start();
			server.join();
		} catch (Throwable t) {
			t.printStackTrace(System.err);
		}
	}
}
