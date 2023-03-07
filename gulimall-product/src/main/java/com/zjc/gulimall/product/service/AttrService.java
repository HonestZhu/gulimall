package com.zjc.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjc.common.utils.PageUtils;
import com.zjc.gulimall.product.entity.AttrEntity;
import com.zjc.gulimall.product.vo.AttrGroupRelationVo;
import com.zjc.gulimall.product.vo.AttrRespVo;
import com.zjc.gulimall.product.vo.AttrVo;

import java.util.List;
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

    void saveAttr(AttrVo attr);

    PageUtils queryBasePage(Map<String, Object> params, Long catelogId, String type);

    AttrRespVo getAttrInfo(Long attrId);

    void updateAttr(AttrVo attr);

    List<AttrEntity> getRelationAttr(Long attrgroupId);

    void deleteRelation(AttrGroupRelationVo[] vos);

    PageUtils getNoRelationAttr(Map<String, Object> params, Long attrgroupId);
}

