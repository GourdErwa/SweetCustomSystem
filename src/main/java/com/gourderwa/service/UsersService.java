package com.gourderwa.service;

import com.gourderwa.dao.UsersDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author HuKaiMo on 2016/4/21.
 */
@Service
public class UsersService {

    @Resource
    private UsersDao usersDao;


}
