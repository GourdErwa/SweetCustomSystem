package com.gourderwa.cache;

import com.google.common.collect.Lists;
import com.gourderwa.entity.CandyCategory;

import java.util.List;

/**
 * @author wei.Li
 */
public class ApplicationCache {

    public static final List<CandyCategory> CANDY_CATEGORIES = Lists.newArrayList();
    /**
     * 图片保存本地路径
     */
    public static String imagesUploadAddress = null;
    public static CandyCategory customization = null;


}
