package ua.ithillel.hillelspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.ithillel.hillelspring.component.UserComponent;
import ua.ithillel.hillelspring.configuration.SpringConfig;
import ua.ithillel.hillelspring.entity.User;

import java.util.List;

@SpringBootApplication
public class HillelSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext springRun = SpringApplication.run(HillelSpringApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        String stringBean = context.getBean("stringBean", String.class);
        User getUser = context.getBean("getUser", User.class);
        String getServerName = context.getBean("getServerName", String.class);
        Integer getHostServer = context.getBean("getHostServer", Integer.class);
        System.out.println(stringBean);
        System.out.println(getUser);
        System.out.println(getServerName);
        System.out.println(getHostServer);
        UserComponent userComponent = springRun.getBean(UserComponent.class);
        List<User> all = userComponent.getAll();
        all.forEach(System.out::println);
    }
}
