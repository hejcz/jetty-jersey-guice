package com.github.hejcz;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;

public class App {
    public static void main(String[] args) throws Exception {
        ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
        servletHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, Config.class.getName());

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        context.addServlet(servletHolder, "/*");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
    }
}
