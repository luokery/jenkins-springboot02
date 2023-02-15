package org.demo.jenkins.springboot02.controller;


import java.util.ArrayList;
import java.util.List;

import org.demo.jenkins.springboot02.model.vo.user.UserVO;
import org.demo.jenkins.springboot02.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author izhem
 *
 */
@RequestMapping(value = "/test", method = RequestMethod.GET)
@RestController
public class TestController {
	
	/**
	 * 返回页面视图
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseVO<String> html() {
		
		return ResponseVO.buildSuccess("viwe html");
	}
	
	/**
	 * 返回列表
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseVO<List<String>> root() {
		
		List<String> books = new ArrayList<String>();

		books.add("0");
		books.add("1");
		books.add("2");
		books.add("3");
		books.add("4");
		books.add("5");

		int size = books.size();
		List<String> portions = books;
		if (size > 5) {
			portions = portions.subList(0, 5);
		}
		System.out.println(portions);
		return ResponseVO.buildSuccess(portions);
	}
	/**
	 * FIXME: 增加
	 */
	/**
	 * FIXME: 删除
	 */
	/**
	 * FIXME: 修改
	 */
	
	/**
	 * 测试list
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseVO<List<String>> list() {
		
		List<String> books = new ArrayList<String>();

		books.add("0");
		books.add("1");
		books.add("2");
		books.add("3");
		books.add("4");
		books.add("5");

		int size = books.size();
		List<String> portions = books;
		if (size > 5) {
			portions = portions.subList(0, 5);
		}
		System.out.println(portions);
		return ResponseVO.buildSuccess(portions);
	}
	
	/**
	 * 测试list vo
	 */
	@RequestMapping(value = "/list/vo", method = RequestMethod.GET)
	public ResponseVO<List<UserVO>> listVo() {
		
		List<UserVO> books = new ArrayList<UserVO>();
		UserVO vo1 = new UserVO();
		vo1.setUserName("vo1");
		books.add(vo1);
		
		UserVO vo2 = new UserVO();
		vo2.setUserName("vo2");
		books.add(vo2);
		
		UserVO vo3 = new UserVO();
		vo3.setUserName("视图3");
		books.add(vo3);
		
		int size = books.size();
		List<UserVO> portions = books;
		if (size > 5) {
			portions = portions.subList(0, 5);
		}
		System.out.println(portions);
		return ResponseVO.buildSuccess(portions);
	}
}
