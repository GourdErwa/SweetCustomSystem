package com.gourderwa.controller;

import com.gourderwa.cache.ActiveMenu;
import com.gourderwa.entity.Candy;
import com.gourderwa.entity.OrderForm;
import com.gourderwa.entity.Users;
import com.gourderwa.model.Result;
import com.gourderwa.service.CandyService;
import com.gourderwa.service.OrderFormService;
import com.gourderwa.util.JSONTransform;
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
@RequestMapping("orderForm")
public class OrderFormController {

    @Resource
    private OrderFormService orderFormService;

    @Resource
    private CandyService candyService;

    //我的订单页面
    @RequestMapping(value = "showAllForMy")
    public ModelAndView showAllForMy(HttpServletRequest request) throws Exception {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.orderForm.showAllForMy");

        final Users users = ((Users) request.getSession().getAttribute("users"));
        final Result searchOrderForms = orderFormService.searchOrderForms(users);
        modelAndView.addObject("activeMenu", ActiveMenu.myMenu);
        modelAndView.addObject("orderForms", JSONTransform.jsonTransform(searchOrderForms.getData()));

        return modelAndView;
    }

    //订单管理页面
    @RequestMapping(value = "manageShowAll")
    public ModelAndView manageShowAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.orderForm.manageShowAll");

        final Result searchOrderForms = orderFormService.searchOrderForms();
        modelAndView.addObject("activeMenu", ActiveMenu.orderFormManage);
        modelAndView.addObject("orderForms", JSONTransform.jsonTransform(searchOrderForms.getData()));

        return modelAndView;
    }

    //展示用户单个订单页面
    @RequestMapping(value = "showOneForMy")
    public ModelAndView showOneForMy(int orderFormId) throws Exception {

        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.orderForm.showOneForMy");
        final OrderForm orderForm = orderFormService.searchOrderFormById(orderFormId);
        modelAndView.addObject("activeMenu", ActiveMenu.myOrderForm);
        modelAndView.addObject("orderForm", orderForm);

        return modelAndView;
    }

    //插入订单页面
    @RequestMapping(value = "insertOrderFormsGoIndexPage")
    public ModelAndView insertOrderFormsGoIndexPage(int candyId) throws Exception {

        ModelAndView modelAndView = new ModelAndView("layouts.application_layout.orderForm.insert");
        final Candy candy = candyService.searchCandyById(candyId);
        modelAndView.addObject("candy", candy);
        modelAndView.addObject("activeMenu", ActiveMenu.myOrderForm);
        return modelAndView;
    }

    //插入订单数据
    @RequestMapping(value = "insertOrderForms")
    public
    @ResponseBody
    Result insertOrderForms(HttpServletRequest request,
                            int candyId, int num, String address, String guestBook)
            throws Exception {

        final int orderFormId = orderFormService.insertOrderForms(request, candyId, num, address, guestBook);
        return new Result(true, orderFormId);
    }

    //修改订单状态为签收
    @RequestMapping(value = "updateOrderFormsSateAlreadySign")
    public ModelAndView updateOrderFormsSateAlreadySign(int orderFormId)
            throws Exception {

        orderFormService.updateOrderFormsSateAlreadySign(orderFormId);
        return new ModelAndView("redirect:/orderForm/orderFormShowOneGoIndexPage?orderFormId=" + orderFormId);
    }

    //修改订单
    @RequestMapping(value = "updateOrderForm")
    public
    @ResponseBody
    Result updateOrderForm(int orderFormId, OrderForm.State state, String reasonRejection)
            throws Exception {

        return orderFormService.updateOrderForm(orderFormId, state, reasonRejection);
    }
}
