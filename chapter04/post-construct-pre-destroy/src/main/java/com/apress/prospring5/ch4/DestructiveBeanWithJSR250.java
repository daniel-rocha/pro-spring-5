package com.apress.prospring5.ch4;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithJSR250 {
  private File file;
  private String filePath;
  
  @PostConstruct
  public void afterPropertiesSet() throws Exception {
    System.out.println("Initializing Bean");
    
    if (filePath == null) {
      throw new IllegalArgumentException(
          "You must specify the filePath property of " +
              DestructiveBeanWithJSR250.class);
    }
    
    this.file = new File(filePath);
    this.file.createNewFile();
    
    System.out.println("File exists: " + file.exists());
  }
  
  @PreDestroy
  public void destroy() {
    System.err.println("Destroying Bean");
    
    if (!file.delete()) {
      System.err.println("ERROR: failed to delete file.");
    }
    
    System.err.println("File exists: " + file.exists());
  }
  
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
  
  public static void main(String... args) throws Exception {
    AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context-annotation.xml");
    
    
    DestructiveBeanWithJSR250 bean =
        (DestructiveBeanWithJSR250) ctx.getBean("destructiveBean");
    
    ctx.registerShutdownHook();
    ctx.refresh();
    System.out.println("Calling destroy()");
    //ctx.destroy();
    System.out.println("Called destroy()");
  }
}
