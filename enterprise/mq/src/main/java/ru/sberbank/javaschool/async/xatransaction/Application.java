package ru.sberbank.javaschool.async.xatransaction;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            User user = new User();
            user.setFirstName("Jon");
            user.setLastName("Snow");

            SomeController controller = applicationContext.getBean(SomeController.class);
            controller.addUser(user);
        }

        System.out.println("Good bye!");
    }
}
