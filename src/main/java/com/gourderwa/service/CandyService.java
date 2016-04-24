package com.gourderwa.service;

import com.google.common.base.Strings;
import com.gourderwa.cache.ApplicationCache;
import com.gourderwa.dao.CandyDao;
import com.gourderwa.entity.Candy;
import com.gourderwa.entity.Users;
import com.gourderwa.model.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * @author Wei.Li on 2016/4/21.
 */
@Service
public class CandyService {

    @Resource
    private CandyDao candyDao;

    //查询所有糖果
    public Result searchCandies() {
        return new Result(true, candyDao.searchCandies());
    }

    //按 id 查询糖果
    public Candy searchCandyById(int candyId) {
        return candyDao.searchCandyById(candyId);
    }

    //分类查询糖果
    public Result searchCandies(int candyCategoryId) {
        return new Result(true, candyDao.searchCandies(candyCategoryId));
    }

    //验证糖果名字
    private Result verifyRepeat(String candyName) {
        return new Result(!candyDao.verifyRepeat(candyName).isEmpty());
    }

    //插入糖果数据
    private int insertCandy(Candy candy) {
        return candyDao.insertCandy(candy);
    }

    //保存手工定制糖果
    public String insertCustomizationCandy(HttpServletRequest request, String candyName) throws IOException {

        final Users users = ((Users) request.getSession().getAttribute("users"));
        if (users == null) {
            return "请登录后进行定制";
        }
        if (Strings.isNullOrEmpty(candyName)) {
            return "请输入糖果名称";
        }

        if (this.verifyRepeat(candyName).isSuccess()) {
            return "糖果名称重复,请重新输入";
        }

        //解析器解析request的上下文
        final CommonsMultipartResolver multipartResolver
                = new CommonsMultipartResolver(request.getSession().getServletContext());

        //先判断request中是否包涵multipart类型的数据，
        if (!multipartResolver.isMultipart(request)) {
            return "未包含文件数据流";
        }

        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        final Iterator<String> inter = multiRequest.getFileNames();
        while (true) {
            if (!(inter.hasNext())) break;
            final MultipartFile file = multiRequest.getFile(inter.next());
            final String uuidFileName = UUID.randomUUID().toString() + ".jpg";
            file.transferTo(new File(ApplicationCache.imagesUploadAddress + "/" + uuidFileName));

            final int i = this.insertCandy(new Candy(candyName, users, ApplicationCache.customization, Candy.State.Audi, uuidFileName));
            return "true-" + i;
        }
        return null;
    }
}
