package com.gourderwa.dao;

import com.gourderwa.entity.Candy;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Component
public class CandyDao extends HibernateTemplateDao {

    //查询所有糖果
    public List<?> searchCandies() {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Candy.class)
                        .addOrder(Order.desc("salesVolume"));

        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    //分类查询糖果
    public List<?> searchCandies(int candyCategoryId) {

        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Candy.class)
                        .addOrder(Order.desc("salesVolume"));

        if (candyCategoryId > -1) {
            detachedCriteria.add(Restrictions.eq("candyCategory.candyCategoryId", candyCategoryId));
        }
        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    //按 id 查询糖果
    public Candy searchCandyById(int candyId) {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Candy.class)
                        .add(Restrictions.eq("candyId", candyId));

        return ((Candy) hibernateTemplate.findByCriteria(detachedCriteria).get(0));
    }

    //验证糖果名字
    public List<?> verifyRepeat(String candyName) {

        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Candy.class)
                        .add(Restrictions.eq("candyName", candyName));

        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

    //插入糖果数据
    public int insertCandy(Candy candy) {
        final Serializable save = hibernateTemplate.save(candy);

        return ((Integer) save);
    }


}
