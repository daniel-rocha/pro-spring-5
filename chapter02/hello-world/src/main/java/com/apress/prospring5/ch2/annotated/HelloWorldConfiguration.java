package com.apress.prospring5.ch2.annotated;

import com.apress.prospring5.ch2.decoupled.HelloWorldMessageProvider;
import com.apress.prospring5.ch2.decoupled.MessageProvider;
import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import com.apress.prospring5.ch2.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliana.cosmina on 1/28/17.
 */
@Configuration
public class HelloWorldConfiguration {
  
  @Bean
  public MessageProvider provider() {
    System.out.println("That one called");
    return new HelloWorldMessageProvider();
  }
  
  @Bean
  public MessageProvider provider2() {
    System.out.println("This one called");
    return new HelloWorldMessageProvider();
  }
  
  @Bean
  public MessageRenderer renderer() {
    MessageRenderer renderer = new StandardOutMessageRenderer();
    System.out.println("The providers will be set");
    renderer.setMessageProvider(provider());
    return renderer;
  }
}
