package ru.flamesyt.springcourse;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Student {
    private String name;

    public String ask() {
        return String.format("Hy, my name is %s. I'm a great student", this.getName());
    }
}
