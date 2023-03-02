package com.zjc.gulimall.order.dao;

import com.zjc.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author zjc
 * @email pullzjc@gmail.com
 * @date 2023-02-24 12:42:40
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
