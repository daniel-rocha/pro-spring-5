package com.apress.prospring5.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJAnnotationDemo {
  public static void main(String... args) {
    GenericXmlApplicationContext ctx =
        new GenericXmlApplicationContext();
    ctx.load("classpath:spring/app-config.xml");
    ctx.refresh();
    NewDocumentarist documentarist =
        ctx.getBean("documentarist", NewDocumentarist.class);
    documentarist.execute();
  }
}
