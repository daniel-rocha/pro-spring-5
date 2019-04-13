package com.apress.prospring5.ch2;

import java.util.Arrays;

public class HelloWorldWithCommandLine {
  
  public static void main(String... args) {
    if (args.length > 0) {
      System.out.println(Arrays.toString(args));
      Arrays.asList(args).forEach(i->System.out.println(i));
      Arrays.asList(args).stream().forEach(System.out::println);
    }
    else {
      System.out.println("Hello World!");
    }
  }
}
