package org.demo.jenkins.springboot02.controller;


import java.util.ArrayList;
import java.util.List;

import org.demo.jenkins.springboot02.common.util.BeanUtil;
import org.demo.jenkins.springboot02.model.dto.user.UserDTO;
import org.demo.jenkins.springboot02.model.vo.user.UserVO;
import org.demo.jenkins.springboot02.service.api.user.UserService;
import org.demo.jenkins.springboot02.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 测试控制器
 * @author izhem
 *
 */
@RequestMapping(value = "/user", method = RequestMethod.GET)
@RestController
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
    
	/**
	 * 虚拟根节点 忽略对根的请求.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseVO<String> root() {
		return ResponseVO.buildSuccess();
	}
	
	/**
	 * 测试list
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseVO<List<UserVO>> list() {
		UserDTO userInfo = new UserDTO();
		
		List<UserDTO> users = userService.list( userInfo);
		
		List<UserVO> userVOs = null;
		try {
			userVOs = BeanUtil.copyList(users, UserVO.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseVO.buildSuccess(userVOs);
	}
}
