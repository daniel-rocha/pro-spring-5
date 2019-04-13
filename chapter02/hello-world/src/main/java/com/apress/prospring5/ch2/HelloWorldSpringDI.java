package com.apress.prospring5.ch2;

import com.apress.prospring5.ch2.decoupled.MessageRenderer;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class HelloWorldSpringDI {
  public static void main(String... args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
    
    MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
    System.out.println("Is singleton? " + ctx.isSingleton("renderer"));
    //Logger l = LogManager.getLogger(HelloWorldSpringDI.class);
    //l.error("Hello Logger");
    //LoggerFactory.getLogger("test").error("Hello world");
    //LoggerFactory.getLogger();
    //LoggerFactory.getLogger(HelloWorldSpringDI.class)
    mr.render();
  }
}
