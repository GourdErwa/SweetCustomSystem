package com.gourderwa.controller;

import com.gourderwa.model.Result;
import com.gourderwa.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wei.Li
 */
@Controller
@RequestMapping("login")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Resource
    private UsersService usersService;

    @RequestMapping(value = "goIndexPage")
    public ModelAndView goIndexPage() {
        return new ModelAndView("layouts.application_layout.login");
    }

    @RequestMapping(value = "verifyLogin")
    public
    @ResponseBody
    Result verifyLogin(HttpServletRequest request, boolean isAdmin, String userName, String passWd) throws Exception {
        final Result result = usersService.verifyLogin(isAdmin, userName, passWd);
        if (result.isSuccess()) {
            request.getSession().setAttribute("users", result.getData());
        }
        return result;
    }
}
