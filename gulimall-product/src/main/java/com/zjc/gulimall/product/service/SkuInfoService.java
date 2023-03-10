package com.zjc.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjc.common.utils.PageUtils;
import com.zjc.gulimall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * sku信息
 *
 * @author zjc
 * @email pullzjc@gmail.com
 * @date 2023-02-25 16:13:30
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);
}

