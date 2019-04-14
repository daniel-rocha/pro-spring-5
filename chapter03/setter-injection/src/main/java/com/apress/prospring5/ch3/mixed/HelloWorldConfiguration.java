package com.apress.prospring5.ch3.mixed;

import com.apress.prospring5.ch2.decoupled.HelloWorldMessageProvider;
import com.apress.prospring5.ch2.decoupled.MessageProvider;
import org.apache.log4j.or.jms.MessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by iuliana.cosmina on 1/29/17.
 */
@ImportResource(locations = {"classpath:spring/app-context-xml.xml"})
@Configuration
public class HelloWorldConfiguration {

  @Bean
  public MessageProvider provider10() {
    // bean with name provider10 will be created
    return new HelloWorldMessageProvider();
  }
  
  @Bean
  public MessageProvider getNewMessageProvider() {
    // bean with name getNewMessageProvider will be created
    return new HelloWorldMessageProvider();
  }
}
