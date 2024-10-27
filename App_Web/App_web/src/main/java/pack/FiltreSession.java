package pack;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FiltreSession implements Filter{

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    /*
     * Verification de la session ID
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        Cookie s [] = httpRequest.getCookies();
        Cookie sID = null;
        
        //Check de l'existence du cookie sessionId;
        if(s!=null) {
	        for(int i=0;i<s.length;i++) {
	        	if (s[i].getName().equals("sessionId")) {
	        		sID = s[i];
	        	}
	        }
	        if (sID==null) httpResponse.sendRedirect("/connect.html");
	        else {
	        	//Check de l'existance de la session dans la BD
	            //TODO
	        }
        }
        else {
        	//Pas de cookies
        	httpResponse.sendRedirect("/connect.html");
        }
        chain.doFilter(httpRequest, httpResponse);
        
        
    }

    @Override
    public void destroy() {
    }
	
}
