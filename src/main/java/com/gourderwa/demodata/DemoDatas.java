package com.gourderwa.demodata;

import com.gourderwa.entity.CandyCategory;
import com.gourderwa.entity.Users;

import java.util.List;

/**
 * @author wei.Li
 */
public class DemoDatas {

    private static final Users

            admin = new Users("admin", "admin", "18601341999", "admin@163.com", "北京市朝阳区", 3),
            xiaoli = new Users("xiaoli", "xiaoli", "18601341991", "xiaoli@163.com", "北京市朝阳区", 2),
            王五 = new Users("王五", "王五", "18601341992", "王五@163.com", "北京市海淀区", 1);

    private static final CandyCategory

            硬质糖果 = new CandyCategory("硬质糖果"),
            手工定制 = new CandyCategory("手工定制");


    public static final List<Users> getUserses() {
        return null;
    }
}