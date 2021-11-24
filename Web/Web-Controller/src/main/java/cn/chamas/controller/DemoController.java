package cn.chamas.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DemoController {
    @RequestMapping(value = "demo", method = RequestMethod.GET)
    public String demo() {
        return "Hello world";
    }
}
