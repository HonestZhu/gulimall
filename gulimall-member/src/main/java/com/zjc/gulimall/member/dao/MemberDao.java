package com.zjc.gulimall.member.dao;

import com.zjc.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zjc
 * @email pullzjc@gmail.com
 * @date 2023-02-24 12:36:42
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
