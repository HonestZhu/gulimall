package com.zjc.gulimall.product.service.impl;

import com.zjc.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjc.common.utils.PageUtils;
import com.zjc.common.utils.Query;

import com.zjc.gulimall.product.dao.BrandDao;
import com.zjc.gulimall.product.entity.BrandEntity;
import com.zjc.gulimall.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        if(StringUtils.hasText(key)) {
            wrapper.eq("brand_id", key).or().like("name", key);
        }

        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                wrapper
        );

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public void updateDetail(BrandEntity brand) {
        // 保证冗余字段的属性一致
        this.updateById(brand);
        if(StringUtils.hasText(brand.getName())) {
            categoryBrandRelationService.updateBrand(brand.getBrandId(), brand.getName());
        }
    }

}