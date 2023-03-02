package com.zjc.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjc.common.utils.PageUtils;
import com.zjc.gulimall.coupon.entity.HomeAdvEntity;

import java.util.Map;

/**
 * 首页轮播广告
 *
 * @author zjc
 * @email pullzjc@gmail.com
 * @date 2023-02-24 12:25:45
 */
public interface HomeAdvService extends IService<HomeAdvEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

