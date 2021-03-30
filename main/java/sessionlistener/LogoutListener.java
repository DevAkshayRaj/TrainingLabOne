package sessionlistener;

import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import service.LoginServiceImpl;

public class LogoutListener implements HttpSessionListener {


    public LogoutListener() {
        
    }

	
    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Session Created!!");
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	try {
    		System.out.println("User Logged out due to inactivity");
            HttpSession session=se.getSession();
            
            Properties props=(Properties)session.getServletContext().getAttribute("properties");
            LoginServiceImpl changestate=LoginServiceImpl.getObject(props);
            String username=(String)session.getAttribute("username");
            String password=(String)session.getAttribute("password");
            changestate.updateFLag(username, password, 0);
            
    	}catch(Exception e) {
    		e.printStackTrace();
    	}

    }
	
}
