package com.gourderwa.controller;

import com.gourderwa.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author HuKaiMo on 2016/4/21.
 */
@Controller
@RequestMapping("users")
public class UsersController {

    @Resource
    private UsersService usersService;

    @RequestMapping(value = "")
    public ModelAndView goIndexPage(String topoId) {

        return null;
    }
}
