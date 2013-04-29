package org.haley.tim.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.DefaultValue;

/**
 * Session Bean implementation class HelloWorld
 */
@Stateless
@LocalBean
@WebService
public class HelloWorld {

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(name = "foo/bar/test")
    private Queue queue;
    
    Connection connection;

    /**
     * Default constructor. 
     */
    public HelloWorld() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    private void init() throws JMSException {
    	connection = connectionFactory.createConnection();
		connection.start();
    }
    
    public String sayHello() {
    	return "Hello";
    }
    
    public void sendMDB(@WebParam(name="state") @DefaultValue(value="1") int state) throws JMSException {
    	final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    	final MessageProducer msgProd = session.createProducer(queue);
    	final TextMessage textMessage = session.createTextMessage();
    	textMessage.setIntProperty("state", state);
    	msgProd.send(textMessage);
    }

}
