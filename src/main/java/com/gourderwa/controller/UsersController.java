package com.gourderwa.controller;

import com.gourderwa.model.Result;
import com.gourderwa.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author Wei.Li on 2016/4/21.
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

    @RequestMapping(value = "searchUsers")
    public Result searchUsers(String userName) {

        return usersService.searchUsers(userName);
    }
}
