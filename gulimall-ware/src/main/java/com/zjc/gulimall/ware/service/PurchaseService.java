package com.zjc.gulimall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjc.common.utils.PageUtils;
import com.zjc.gulimall.ware.entity.PurchaseEntity;
import com.zjc.gulimall.ware.vo.MergeVo;
import com.zjc.gulimall.ware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author zjc
 * @email pullzjc@gmail.com
 * @date 2023-02-24 12:43:52
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPagenreceivePurchase(Map<String, Object> params);

    void mergePurchase(MergeVo mergeVo);

    void received(List<Long> ids);


    void done(PurchaseDoneVo doneVo);
}

