package com.gourderwa.service;

import com.gourderwa.dao.UsersDao;
import com.gourderwa.model.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Service
public class UsersService {

    @Resource
    private UsersDao usersDao;


    public Result searchUsers(String userName) {

        final List<?> searchUsers = usersDao.searchUsers(userName);
        return new Result(true, searchUsers);
    }
}
