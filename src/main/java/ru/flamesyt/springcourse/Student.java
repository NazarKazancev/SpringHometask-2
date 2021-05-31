package ru.flamesyt.springcourse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class Driver {
    private String name;

    public String drive() {
        return String.format("The engine started and driver %s is ready to drive", this.getName());
    }
}
