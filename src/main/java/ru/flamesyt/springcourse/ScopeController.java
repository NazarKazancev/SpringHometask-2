package ru.flamesyt.springcourse;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.annotation.Resource;

@RestController
public class ScopeController {
    public static final Logger LOG = LoggerFactory.getLogger(ScopeController.class);

    @Resource
    HelloMessageGenerator requestScopedBean;

    @Resource
    Car car;

    @RequestMapping("/scopes/request")
    public String getRequestScopeMessage() {
        System.out.println(">>>>> previousMessage: " + requestScopedBean.getMessage());
        requestScopedBean.setMessage("Hello, World!!!");
        return "currentMessage: " + requestScopedBean.getMessage();
    }

    @RequestMapping("/scopes/prototype")
    public String getRequestPrototypeMessage() {
        return car.drive("Михаил");
    }

    @RequestMapping("/scopes/contextsearch")
    public String getApplicationContextSearch() {
        var context = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
        Driver driver = (Driver) context.getBean("myDriver");
        driver.setName("Вася");
        return driver.drive();
    }
}
