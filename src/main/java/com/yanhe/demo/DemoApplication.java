package com.yanhe.demo;

import com.yanhe.demo.configuration.ScopeConfig;
import com.yanhe.demo.service.DemoPrototypeService;
import com.yanhe.demo.service.DemoSingletonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		testScope();
		SpringApplication.run(DemoApplication.class, args);
	}

	private static void testScope() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ScopeConfig.class);

		DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
		DemoSingletonService s2 = context.getBean(DemoSingletonService.class);

		DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
		DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);

		System.out.println("s1 与 s2 是否相等：" + s1.equals(s2));
		System.out.println("p1 与 p2 是否相等：" + p1.equals(p2));

		context.close();
	}
}
