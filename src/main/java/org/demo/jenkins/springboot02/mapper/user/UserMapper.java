package org.demo.jenkins.springboot02.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.demo.jenkins.springboot02.model.entity.PageEntity;
import org.demo.jenkins.springboot02.model.entity.user.UserEntity;

/**
 * 用户表
 * 
 * @author
 */
@Mapper
public interface UserMapper {

	/**
	 * 用户保存
	 * 
	 * @param user
	 * @return
	 */
	int save(UserEntity user);
	
	/**
	 * 查询用户 总数
	 * @param user
	 * @return
	 */
	Integer findUsersAtPageCount(UserEntity user);
	
	/**
	 * 查询用户 分页
	 * @param user
	 * @return
	 */
	List<UserEntity> findUsers(@Param("pageEntity") PageEntity pageEntity, @Param("entity") UserEntity user);
	
	/**
	 * 用户列表
	 * 
	 * @param user
	 * @return
	 */
	List<UserEntity> getList(UserEntity user);
}
