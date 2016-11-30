package com.waterfox.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.waterfox.demo.User;

public interface BaseMapper {
	// 条件对象example start----------------------
	int countByExample(BaseExample example);

	int deleteByExample(BaseExample example);

	List<User> selectByExample(BaseExample example);

	// 是否判断为null。如果为null，不更新
	int updateByExampleSelective(@Param("user") User user, @Param("example") BaseExample example);

	int updateByExample(@Param("user") User user, @Param("example") BaseExample example);
	// 条件对象example end----------------------

	int deleteByPrimaryKey(Integer id);

	int insert(User user);

	int insertSelective(User user);

	List<User> selectInIds(User user);

	// 下边两个是sql语句的补充，没有实际意义
	User selectByPrimaryKey(Integer id);

	List<User> selectByUserName(User user);

}