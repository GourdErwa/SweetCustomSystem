package com.gourderwa.controller;

import com.gourderwa.model.Result;
import com.gourderwa.model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author wei.Li
 */
@Controller
@RequestMapping("login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private HibernateTemplate hibernateTemplate;

    @RequestMapping(value = "")
    public
    @ResponseBody
    Result insertAAA(String topoId) {
        hibernateTemplate.saveOrUpdate(new Users("liwei"));
        System.out.println("-- success");
        return null;
    }

}
