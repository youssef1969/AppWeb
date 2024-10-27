package pack;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class FiltreRessource implements Filter{
	
	 @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	    }

	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        HttpServletResponse httpResponse = (HttpServletResponse) response;

	        httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
	        
	    }

	    @Override
	    public void destroy() {
	    }

}
