package io.javabrains.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

   @Value("${my.greetings: default Value}")
    String greetings;

    @Value("${my.list.values}")
    List<String> listValues;

    @Value("#{${dBValues}}")
    Map<String,String> connectionProps;

    @Autowired
    DBSettings dbSettings;

    @GetMapping("/greetings")
    public String greetingMessage(){
        //String greetings;
        return (dbSettings.getHost()+dbSettings.getConnection()+dbSettings.getPort());
    }
}
