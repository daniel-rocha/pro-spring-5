package com.apress.prospring5.ch2;

import java.util.Arrays;

public class HelloWorld {
  
  public static void main(String... args) {
    System.out.println("Hello World 123!");
    Arrays.asList(args).forEach(i->System.out.println(i));
  }
}
