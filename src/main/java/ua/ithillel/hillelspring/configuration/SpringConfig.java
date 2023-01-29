package ua.ithillel.hillelspring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ua.ithillel.hillelspring.entity.User;

@Configuration
@ComponentScan("ua.ithillel.hillelspring.configuration")
@PropertySource("classpath:application.properties")
public class SpringConfig {

    @Value("${server.name}")
    private String serverName;

    @Value("${host.server}")
    private Integer hostServer;
    @Bean
    public String stringBean(){
        return "String bean from SpringConfig";
    }

    @Bean
    @Scope("prototype")
    public User getUser(){
        return new User("Alice", "Johnson", 22, "alice@gmail.com");
    }

    @Bean
    public String getServerName(){
        return serverName;
    }
    @Bean
    public Integer getHostServer(){
        return hostServer;
    }
}
