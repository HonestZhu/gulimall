package com.zjc.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjc.common.utils.PageUtils;
import com.zjc.gulimall.product.entity.SpuInfoEntity;
import com.zjc.gulimall.product.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author zjc
 * @email pullzjc@gmail.com
 * @date 2023-02-25 16:13:30
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo vo);

    void saveBaseSpuInfo(SpuInfoEntity infoEntity);

    PageUtils queryPageByCondition(Map<String, Object> params);

}

