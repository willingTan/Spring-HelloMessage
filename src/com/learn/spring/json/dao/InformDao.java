package com.learn.spring.json.dao;

import org.apache.ibatis.annotations.Delete;  
import org.apache.ibatis.annotations.Insert;  
import org.apache.ibatis.annotations.Options;  
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.learn.spring.json.entity.Inform;

public interface InformDao {
	/*
	 * 查询某公告的信息
	 */
	@Select("select * from inform where info_id = #{info_id}")
	Inform findById(Integer inform_id);
}