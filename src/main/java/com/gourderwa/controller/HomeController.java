package com.gourderwa.controller;

import com.gourderwa.model.Result;
import com.gourderwa.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author wei.Li
 */
@Controller
@RequestMapping("home")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    @Resource
    private UsersService usersService;

    @RequestMapping(value = "goIndexPage")
    public ModelAndView goIndexPage() throws Exception{
        return new ModelAndView("layouts.application_layout.home");
    }

    @RequestMapping(value = "login")
    public Result login(boolean isAdmin, String userName, String passWd) {
        return usersService.verifyLogin(isAdmin, userName, passWd);
    }
}
