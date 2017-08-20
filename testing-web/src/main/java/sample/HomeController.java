package sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by soong on 2017/8/20.
 */
@RestController
@RequestMapping(value = "/")
public class HomeController {

    @GetMapping(value = "")
    public String hello(){
        return "Hello world!";
    }

    @GetMapping(value = "search")
    public String search(String keywords){
        return "The keywords you input is: " + keywords;
    }

    @Resource
    private GreetingService service;

    @GetMapping(value = "greet")
    public String greet(){
        return service.greet();
    }

}
