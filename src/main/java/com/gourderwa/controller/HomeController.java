package com.gourderwa.controller;

import com.gourderwa.cache.ActiveMenu;
import com.gourderwa.entity.Candy;
import com.gourderwa.model.Result;
import com.gourderwa.service.CandyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wei.Li
 */
@Controller
@RequestMapping("home")
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    @Resource
    private CandyService candyService;

    //首页面展示
    @RequestMapping(value = "goIndexPage")
    public ModelAndView goIndexPage() throws Exception {

        final ModelAndView modelAndView = new ModelAndView("layouts.application_layout.home");

        final Result result = candyService.searchCandies();
        final List<Candy> data = ((List<Candy>) result.getData());
        modelAndView.addObject("candies", data.subList(0, data.size() > 8 ? 8 : data.size()));
        modelAndView.addObject("activeMenu", ActiveMenu.homeMenu);
        return modelAndView;
    }

}
