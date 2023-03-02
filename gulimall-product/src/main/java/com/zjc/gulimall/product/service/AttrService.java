package com.zjc.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjc.common.utils.PageUtils;
import com.zjc.gulimall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author zjc
 * @email pullzjc@gmail.com
 * @date 2023-02-25 16:13:31
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
