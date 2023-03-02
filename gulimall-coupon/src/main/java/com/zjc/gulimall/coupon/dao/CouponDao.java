package com.zjc.gulimall.coupon.dao;

import com.zjc.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zjc
 * @email pullzjc@gmail.com
 * @date 2023-02-24 12:25:46
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
