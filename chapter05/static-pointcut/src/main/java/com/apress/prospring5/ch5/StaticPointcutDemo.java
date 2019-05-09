package com.apress.prospring5.ch5;

import com.apress.prospring5.ch2.common.Singer;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
  public static void main(String... args) {
    GoodGuitarist johnMayer = new GoodGuitarist();
    GreatGuitarist ericClapton = new GreatGuitarist();
    
    Singer proxyOne;
    Singer proxyTwo;
    
    Pointcut pc = new SimpleStaticPointcut();
    Advice advice = new SimpleAdvice();
    Advisor advisor = new DefaultPointcutAdvisor(pc, advice);
    
    // this class will get advised
    ProxyFactory pf = new ProxyFactory();
    pf.addAdvisor(advisor);
    pf.setTarget(johnMayer);
    proxyOne = (Singer) pf.getProxy();
    
    // this one will not because it fails the matcher.
    pf = new ProxyFactory();
    pf.addAdvisor(advisor);
    pf.setTarget(ericClapton);
    proxyTwo = (Singer) pf.getProxy();
    
    proxyOne.sing();
    proxyTwo.sing();
  }
}
