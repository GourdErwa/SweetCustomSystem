package com.gourderwa.controller;

import com.gourderwa.model.Result;
import com.gourderwa.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "goShowAllUsersIndexPage")
    public ModelAndView goShowAllUsersIndexPage() {

        return new ModelAndView("layouts.application_layout.showAllUsers");
    }

    @RequestMapping(value = "goCreateUsersIndexPage")
    public ModelAndView goCreateUsersIndexPage() {

        return new ModelAndView("layouts.application_layout.createUsers");
    }

    @RequestMapping(value = "goUpdateUsersIndexPage")
    public ModelAndView goUpdateUsersIndexPage(String usersId) {

        return new ModelAndView("layouts.application_layout.updateUsers");
    }

    @RequestMapping(value = "searchUsers")
    public
    @ResponseBody
    Result searchUsers() throws Exception {

        return usersService.searchUsers();
    }

    @RequestMapping(value = "deleteUser")
    public
    @ResponseBody
    Result deleteUser(String usersId) throws Exception {

        // return usersService.searchUsers(userName);
        return null;
    }


}
