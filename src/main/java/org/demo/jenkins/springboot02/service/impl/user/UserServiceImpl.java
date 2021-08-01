package org.demo.jenkins.springboot02.service.impl.user;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.demo.jenkins.springboot02.common.util.BeanUtil;
import org.demo.jenkins.springboot02.mapper.user.UserMapper;
import org.demo.jenkins.springboot02.model.dto.user.ForgetPasswordDTO;
import org.demo.jenkins.springboot02.model.dto.user.UserDTO;
import org.demo.jenkins.springboot02.model.entity.user.UserEntity;
import org.demo.jenkins.springboot02.model.vo.user.UserVO;
import org.demo.jenkins.springboot02.service.api.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
    @Resource
    private UserMapper userMapper;
    
	@Override
	public UserDTO save(UserDTO userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> list(UserDTO userInfo) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userEntity, userInfo);
		List<UserEntity> userEntitys = userMapper.getList(userEntity);
		
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		try {
			userDTOs = BeanUtil.copyList(userEntitys, UserDTO.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDTOs;
	}

	@Override
	public UserDTO findByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO findByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findCountByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String forgetPassword(ForgetPasswordDTO forgetPasswordInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
