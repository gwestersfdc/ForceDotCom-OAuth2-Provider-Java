package com.force.api.oauth2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * 
 * @author gwester
 */
public class CallbackServer {

	public static void main(String[] args) throws Exception {
		String webPort = System.getenv("PORT");
		String webappDirLocation = "src/main/webapp/";

		if(webPort == null || webPort.isEmpty()) {
			webPort = "8081";
		}

		Server server = new Server(Integer.valueOf(webPort));
		WebAppContext root = new WebAppContext();
		root.setContextPath("/");
		root.setDescriptor(webappDirLocation+"/WEB-INF/web.xml");
		root.setResourceBase(webappDirLocation);
		root.setParentLoaderPriority(true);

		server.setHandler(root);
		server.start();
		server.join(); 
	}
}