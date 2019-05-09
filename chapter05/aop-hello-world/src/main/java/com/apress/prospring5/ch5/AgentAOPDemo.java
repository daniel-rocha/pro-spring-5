package com.apress.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

public class AgentAOPDemo {
  public static void main(String... args) {
    Agent target = new Agent();
    
    ProxyFactory pf = new ProxyFactory();
    pf.addAdvice(new AgentDecorator());
    pf.setTarget(target);
    
    Agent proxy = (Agent) pf.getProxy();
    
    target.speak();
    System.out.println("");
    proxy.speak();
    
    // this is a demo to show that the default advisor in Spring adds advice to all methods!
    target.doNotSpeak();
    System.out.println("");
    proxy.doNotSpeak();
  }
}
