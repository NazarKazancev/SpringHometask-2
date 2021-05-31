package ru.flamesyt.springcourse;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class School {
    public School() {
    }

    @Lookup("student")
    public Student getStudent() {
        return null;
    }

    public String ask(String studentName) {
        Student student = getStudent();
        student.setName(studentName);
        return student.ask();
    }
}
