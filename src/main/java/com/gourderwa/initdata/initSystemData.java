package com.gourderwa.initdata;

import com.google.common.collect.Lists;
import com.gourderwa.entity.Candy;
import com.gourderwa.entity.CandyCategory;
import com.gourderwa.entity.Users;

import java.util.List;

/**
 * 插入测试数据
 *
 * @author wei.Li
 */
public class InitSystemData {

    public static final Users
            ADMIN = new Users("admin", "admin", "18601341999", "admin@163.com", "admin", 2);

    private static final CandyCategory
            YZ = new CandyCategory("硬质糖"),
            SZ = new CandyCategory("手工定制"),
            ET = new CandyCategory("儿童糖"),
            NN = new CandyCategory("牛奶糖"),
            R = new CandyCategory("软糖"),
            S = new CandyCategory("酥糖");

    public static List<Users> getUsers() {

        final List<Users> list = Lists.newArrayList(ADMIN);
        for (int i = 0; i < 100; i++) {
            list.add(new Users("用户-" + i, i + "", "18601341992", i + "-tyut@163.com", "北京市海淀区", 1));
        }

        return list;
    }

    public static List<CandyCategory> getCandyCategory() {
        return Lists.newArrayList(YZ, SZ, ET, NN, R, S);
    }

    public static List<Candy> getCandy() {
        final List<Candy> list = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(new Candy("糖果 " + i, ADMIN, SZ, Candy.State.SaleIn, "1.jpg", 100000, i, 1d));
        }
        return list;
    }

}
