package pack;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.ejb.Singleton;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;


@Path("/home")
@Singleton
public class Home {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getHome(@CookieParam("sessionId") String sessionId, @Context ServletContext s) {
		//Recuperer type d'user
		//...
			return "<!DOCTYPE html><html><head></head><body>OK " + sessionId + "</body></html>";
		
//		try {
//			return htmlFileToString(s.getRealPath("ressources/cal.html"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			return e.toString();
//		}
	}
	
	
	private String htmlFileToString(String path) throws IOException{
		try {
            byte[] fileBytes = Files.readAllBytes(Paths.get(path));
            return new String(fileBytes,StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
	
}
