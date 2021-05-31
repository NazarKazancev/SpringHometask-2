package ru.flamesyt.springcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class ScopeConfiguration {
    @Bean
    @RequestScope
    public MessagePrinter requestScopedBean() {
        return new MessagePrinter();
    }

    @Bean
    public Student myStudent() {
        return new Student();
    }
}
