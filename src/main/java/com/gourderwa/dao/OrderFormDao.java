package com.gourderwa.dao;

import com.gourderwa.entity.OrderForm;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Component
public class OrderFormDao extends HibernateTemplateDao {

    //按 id 查询订单
    public OrderForm searchOrderFormById(int orderFormId) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(OrderForm.class)
                        .add(Restrictions.eq("orderFormId", orderFormId));

        return ((OrderForm) hibernateTemplate.findByCriteria(detachedCriteria).get(0));
    }

    /**
     * * @param userId -1 为管理员,可以查询所有,其它为普通用户,只查询自己
     *
     * @return
     */
    public List<?> searchOrderForms(int userId) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(OrderForm.class)
                        .addOrder(Order.desc("orderTime"));

        if (userId != -1) {
            detachedCriteria.add(Restrictions.eq("users.userId", userId));
        }
        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    //插入订单数据
    public int insertOrderForms(OrderForm orderForm) {

        return ((Integer) hibernateTemplate.save(orderForm));
    }

    //修改订单状态为签收
    public void updateOrderForms(OrderForm orderForm) {

        hibernateTemplate.saveOrUpdate(orderForm);
    }
}
