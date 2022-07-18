package ru.shtanko.spring_framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.shtanko.spring_framework.producer.JMSProducer;

@SpringBootApplication
public class SpringAppStart {

    @Autowired
    private JMSProducer jmsProducer;


    public static void main(String[] args) {
        SpringApplication.run(SpringAppStart.class, args);
    }

    @Bean
    public CommandLineRunner simple() {
        return args -> jmsProducer.send();
    }

}
