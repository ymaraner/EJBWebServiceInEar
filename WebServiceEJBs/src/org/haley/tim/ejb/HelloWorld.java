package org.haley.tim.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Session Bean implementation class HelloWorld
 */
@Stateless
@LocalBean
@WebService
public class HelloWorld {

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }
    
    String sayHello() {
    	return "Hello";
    }

}
