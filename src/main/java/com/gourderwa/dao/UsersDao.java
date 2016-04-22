package com.gourderwa.dao;

import com.gourderwa.entity.Users;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Component
public class UsersDao extends HibernateTemplateDao {

    public List<?> searchUsers(String userName) {

        final DetachedCriteria detachedCriteria =
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.like("userName", userName));
        return hibernateTemplate.findByCriteria(detachedCriteria);
    }

}
