package com.gourderwa.dao;

import com.gourderwa.entity.Users;
import com.gourderwa.model.Result;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Component
public class UsersDao extends HibernateTemplateDao {

    public Result verifyLogin(String userName, String passWd) {

        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.eq("userName", userName))
                        .add(Restrictions.eq("passWd", passWd));

        final List<?> list = hibernateTemplate.findByCriteria(detachedCriteria);
        return list.isEmpty() ? new Result(false) : new Result(true, list.get(0));
    }

    public List<?> searchUsers() {
        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.ne("userName", "admin"));
        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

}
