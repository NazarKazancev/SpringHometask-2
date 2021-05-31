package ru.flamesyt.springcourse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ScopeController {
    public static final Logger LOG = LoggerFactory.getLogger(ScopeController.class);

    @Resource
    MessagePrinter requestScopedBean;

    @Resource
    School school;

    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage() {
        System.out.println(">>>>> previousMessage: " + requestScopedBean.getMessage());
        requestScopedBean.setMessage("Hello, World!");
        return "currentMessage: " + requestScopedBean.getMessage();
    }

    @RequestMapping("/scopes/prototype")
    public String getRequestPrototypeMessage() {
        return school.ask("Василий Пупкин");
    }

    @RequestMapping("/scopes/contextsearch")
    public String getApplicationContextSearch() {
        var context = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
        Student student = (Student) context.getBean("myStudent");
        student.setName("Вася");
        return student.ask();
    }
}
