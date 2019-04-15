package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;
import com.apress.prospring5.ch3.Oracle;

public class InjectRef {
    private Oracle oracle;

    // this is going to be injected - see XML file.
    public void setOracle(Oracle oracle) { 
        this.oracle = oracle;
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        // getting myself from spring, how weird
        InjectRef injectRef = (InjectRef) ctx.getBean("injectRef");
        System.out.println(injectRef);

        ctx.close();
    }

    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}
