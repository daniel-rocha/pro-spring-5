package com.apress.prospring5.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ResourceDemo {
  public static void main(String... args) throws Exception {
    ApplicationContext ctx = new ClassPathXmlApplicationContext();
    
    File file = File.createTempFile("test", "txt");
    file.deleteOnExit();
    
    Resource res1 = ctx.getResource("file://" + file.getPath());
    displayInfo(res1);
    
    Resource res2 = ctx.getResource("classpath:test.txt");
    displayInfo(res2);
    
    UrlResource res3 = (UrlResource) ctx.getResource("http://www.google.com");
    String line = null;
    
    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(res3.getInputStream()));
        ) {
        while((line = br.readLine()) != null) {
          System.out.println(line);
        }
    }
    displayInfo(res3);
  }
  
  private static void displayInfo(Resource res) throws Exception {
    System.out.println(res.getClass());
    System.out.println(res.getURL()
        .getContent());
    System.out.println(res.contentLength());
  }
}
