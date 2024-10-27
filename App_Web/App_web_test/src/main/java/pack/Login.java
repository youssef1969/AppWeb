package pack;

//import java.time.LocalDateTime;
import java.io.IOException;
import java.util.Random;
//import java.util.Map;
//import java.util.HashMap;

import jakarta.ejb.Singleton;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Path("/login")
@Singleton
public class Login {

	@PersistenceContext(unitName = "MaPU")
	private EntityManager em;
//	private Map<String,SessionId> map = new HashMap<String,SessionId>();
	Random r = new Random();
	
	
	@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void login(@CookieParam("sessionId") String sessionId,
    				  @FormParam("username") String username,
                      @FormParam("password") String password,
                      @Context HttpServletRequest request,
                      @Context HttpServletResponse response) throws IOException, ServletException {

//		response.sendRedirect("/AW/home");
				
		boolean dejaCo = false;
		
		// Check du cookie de session si deja existant
		if (sessionId != null && sessionId!="") {
//			SessionId s = em.find(SessionId.class, sessionId);
//			SessionId s = map.get("sessionId");
			response.sendRedirect("/AW/home");
			dejaCo=true;
//			if (s!=null) {
//				//sessionId deja existant
//				if (s.getExpiresDate().isBefore(LocalDateTime.now())) {
//					// Expiration OK --> On redirect
//					dispatcher = request.getRequestDispatcher("cal.html");
//					dispatcher.forward(request,response);
//					dejaCo=true;
//				}
//			}
		}
		
		if (!dejaCo) {
			if (authenticateUser(username, password)) {
				//Creer cookie
				Cookie s = new Cookie("sessionId",Integer.toString(r.nextInt()));
				s.setMaxAge(3600); //dure 1H
//				em.persist(s);
//				map.put(Integer.toString(r.nextInt()), s);
				
				//redirection
				response.addCookie(s);
				response.sendRedirect("/AW/home");
			}
			else {
				response.sendRedirect("/connect.html");
			}
		}
	}
		
		

    private boolean authenticateUser(String username, String password) {
    	return true;
   
    }
	
		
	
}