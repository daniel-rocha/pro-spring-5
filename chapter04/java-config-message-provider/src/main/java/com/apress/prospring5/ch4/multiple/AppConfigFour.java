package com.apress.prospring5.ch4.multiple;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliana.cosmina on 3/15/17.
 */
@Configuration
@ComponentScan(basePackages = {"com.apress.prospring5.ch4.annotated"}) //this is the line where the bean is configured!
public class AppConfigFour {

}
