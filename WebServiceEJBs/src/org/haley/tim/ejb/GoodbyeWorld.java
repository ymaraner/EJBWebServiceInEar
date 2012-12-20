package org.haley.tim.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Session Bean implementation class GoodbyeWorld
 */
@Stateless
@LocalBean
@WebService
public class GoodbyeWorld {

    /**
     * Default constructor. 
     */
    public GoodbyeWorld() {
        // TODO Auto-generated constructor stub
    }
    
    public String sayGoodbye() {
    	return "Goodbye";
    }

}
