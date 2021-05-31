package ru.flamesyt.springcourse;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Car {
    public Car() {
    }

    @Lookup("driver")
    public Driver getDriver() {
        return null;
    }

    public String drive(String driverName) {
        Driver driver = getDriver();
        driver.setName(driverName);
        return driver.drive();
    }
}
