package com.apress.prospring5.ch3;

import com.apress.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {

	public static void main(String... args) {
		// this implements ApplicationContext and can be created from XML. Its
		// much more powerful than simply the BeanFactory interface. Provides more services
		// like internationalization and configuration.
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//ctx.load("classpath:spring/app-context-xml.xml");
		ctx.load("classpath:spring/app-context-annotation.xml");
		ctx.refresh();
		MessageRenderer messageRenderer = ctx.getBean("renderer",
				MessageRenderer.class);
		messageRenderer.render();
		ctx.close();
	}
}
