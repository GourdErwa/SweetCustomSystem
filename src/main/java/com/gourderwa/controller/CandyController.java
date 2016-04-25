package com.gourderwa.controller;

import com.google.common.base.Strings;
import com.gourderwa.cache.ActiveMenu;
import com.gourderwa.cache.ApplicationCache;
import com.gourderwa.entity.Candy;
import com.gourderwa.model.Result;
import com.gourderwa.service.CandyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @author wei.Li
 */
@Controller
@RequestMapping("candy")
public class CandyController {

    @Resource
    private CandyService candyService;

    //糖果首页 - 按分类查询 -1查询所有
    @RequestMapping(value = "goIndexPage")
    public ModelAndView goIndexPage(String candyCategoryId) throws Exception {

        final ModelAndView modelAndView = new ModelAndView("layouts.application_layout.candy");

        final int categoryId = Strings.isNullOrEmpty(candyCategoryId) ? -1 : Integer.parseInt(candyCategoryId);
        final Result result = candyService.searchCandies(categoryId, Candy.State.SaleIn);
        final List<Candy> data = ((List<Candy>) result.getData());
        modelAndView.addObject("candies", data);
        modelAndView.addObject("categoryId", categoryId);

        modelAndView.addObject("activeMenu", ActiveMenu.candyMenu);
        return modelAndView;
    }

    //糖果管理
    @RequestMapping(value = "manageCandy")
    public ModelAndView manageCandy(String candyCategoryId,Candy.State state) throws Exception {

        final ModelAndView modelAndView = new ModelAndView("layouts.application_layout.candy.manageCandy");

        final int categoryId = Strings.isNullOrEmpty(candyCategoryId) ? -1 : Integer.parseInt(candyCategoryId);
        final Result result = candyService.searchCandies(categoryId,state);
        final List<Candy> data = ((List<Candy>) result.getData());
        modelAndView.addObject("candies", data);
        modelAndView.addObject("categoryId", categoryId);

        modelAndView.addObject("activeMenu", ActiveMenu.manageCandy);
        return modelAndView;
    }

    //手工定制糖果
    @RequestMapping(value = "customization")
    public ModelAndView customization() throws Exception {

        final ModelAndView modelAndView = new ModelAndView("layouts.application_layout.candy.customization");
        modelAndView.addObject("activeMenu", ActiveMenu.customizationMenu);
        return modelAndView;
    }

    //查询某个糖果
    @RequestMapping(value = "showOne")
    public ModelAndView showOne(int candyId) throws Exception {
        final ModelAndView modelAndView = new ModelAndView("layouts.application_layout.candy.showOne");
        modelAndView.addObject("candy", candyService.searchCandyById(candyId));
        modelAndView.addObject("activeMenu", ActiveMenu.candyMenu);
        return modelAndView;
    }

    //保存手工定制糖果
    @RequestMapping(value = "insertCustomizationCandy")
    public
    @ResponseBody
    String insertCustomizationCandy(HttpServletRequest request, String candyName) throws Exception {

        return candyService.insertCustomizationCandy(request, candyName);
    }

    //糖果图片下载
    @RequestMapping(value = "downImage")
    public
    @ResponseBody
    String downImage(HttpServletResponse response, String downImageUrl) throws Exception {

        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(ApplicationCache.imagesUploadAddress + "/" + downImageUrl);
            out = response.getOutputStream();
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        return null;
    }

}
