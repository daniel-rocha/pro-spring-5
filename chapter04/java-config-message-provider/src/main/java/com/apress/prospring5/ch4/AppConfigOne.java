package com.apress.prospring5.ch4;

import com.apress.prospring5.ch2.decoupled.MessageProvider;
import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import com.apress.prospring5.ch2.decoupled.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:message.properties")
public class AppConfigOne {
  
  @Autowired
  Environment env;
  
  @Value("${message}")
  String message;
  
  @Bean
  @Lazy
  public MessageProvider messageProvider() {
    return new ConfigurableMessageProvider(env.getProperty("message") + message);
  }
  
  @Bean(name = "messageRenderer")
  @Scope(value = "prototype")
  @DependsOn(value = "messageProvider") //this is because messageProvider is marked as @Lazy
  public MessageRenderer messageRenderer() {
    MessageRenderer renderer = new StandardOutMessageRenderer();
    renderer.setMessageProvider(messageProvider());
    return renderer;
  }
}
