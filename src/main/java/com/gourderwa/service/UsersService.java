package com.gourderwa.service;

import com.gourderwa.dao.UsersDao;
import com.gourderwa.model.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Service
public class UsersService {

    @Resource
    private UsersDao usersDao;


    public Result verifyLogin(String userName, String passWd) {
        return usersDao.verifyLogin(userName, passWd);
    }

    public Result searchUsers() {

        return new Result(true, usersDao.searchUsers());
    }
}
