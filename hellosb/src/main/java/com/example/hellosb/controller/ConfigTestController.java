package com.example.hellosb.controller;

import com.example.hellosb.bean.ConfigBean;
import com.example.hellosb.bean.InfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/18
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class,InfoBean.class})
public class ConfigTestController {
    @Autowired
    ConfigBean configBean;

    @Autowired
    InfoBean infoBean;

    @RequestMapping(value = "/ct")
    public String miya(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }

    @RequestMapping(value = "/info")
    public String info(){
        return infoBean.getName()+" "+infoBean.getAge();
    }
}
