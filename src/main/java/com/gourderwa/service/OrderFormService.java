package com.gourderwa.service;

import com.gourderwa.dao.CandyDao;
import com.gourderwa.dao.OrderFormDao;
import com.gourderwa.dao.UsersDao;
import com.gourderwa.entity.Candy;
import com.gourderwa.entity.OrderForm;
import com.gourderwa.entity.Users;
import com.gourderwa.model.Result;
import com.gourderwa.util.TimesUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Service
public class OrderFormService {

    @Resource
    private OrderFormDao orderFormDao;
    @Resource
    private CandyDao candyDao;
    @Resource
    private UsersDao usersDao;

    /**
     * 查询所有订单
     */
    public Result searchOrderForms() {
        return new Result(true, orderFormDao.searchOrderForms(-1));
    }

    /**
     * @param user -1 为管理员,可以查询所有,其它为普通用户,只查询自己
     */
    public Result searchOrderForms(Users user) {
        return new Result(true, orderFormDao.searchOrderForms(user.getUserId()));
    }

    //插入订单数据
    public int insertOrderForms(HttpServletRequest request, int candyId, int num, String address, String guestBook) {
        final Candy candy = candyDao.searchCandyById(candyId);
        candy.setSalesVolume(candy.getSalesVolume() + num);
        final int stock = candy.getStock() - num;
        candy.setStock(stock < num ? 0 : stock - num);
        final Users users = (Users) request.getSession().getAttribute("users");
        OrderForm orderForm =
                new OrderForm(usersDao.searchUserById(users.getUserId()), candy, num, address, OrderForm.State.WaitingForDelivery, null, TimesUtils.DATE_FORMATTER.format(new Date()), guestBook);
        return orderFormDao.insertOrderForms(orderForm);
    }

    //按 id 查询订单
    public OrderForm searchOrderFormById(int orderFormId) {
        return orderFormDao.searchOrderFormById(orderFormId);
    }

    //修改订单状态为签收
    public void updateOrderFormsSateAlreadySign(int orderFormId) {
        final OrderForm orderForm = orderFormDao.searchOrderFormById(orderFormId);
        orderForm.setState(OrderForm.State.AlreadySign);
        orderFormDao.updateOrderForms(orderForm);
    }

    public Result updateOrderForm(int orderFormId, OrderForm.State state, String reasonRejection) {
        try {
            OrderForm orderForm = orderFormDao.searchOrderFormById(orderFormId);
            orderForm.setState(state);
            orderForm.setReasonRejection(reasonRejection);
            orderFormDao.updateOrderForms(orderForm);
            return new Result(true);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, e.getMessage(), null);
        }
    }
}
