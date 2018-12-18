package com.example.hellosb_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/rest")
    public String index() {
        String quote = restTemplate.getForObject(
                "http://gturnquist-quoters.cfapps.io/api/random", String.class);
        return quote.toString();
    }

}
