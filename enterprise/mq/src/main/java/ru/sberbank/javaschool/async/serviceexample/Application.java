package ru.sberbank.javaschool.async.serviceexample;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            SimpleService simpleService = applicationContext.getBean(SimpleService.class);
            simpleService.doSomething();
        }
    }
}
