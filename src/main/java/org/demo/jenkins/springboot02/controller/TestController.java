package org.demo.jenkins.springboot02.controller;


import java.util.ArrayList;
import java.util.List;

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
	 * 虚拟根节点 忽略对根的请求.
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
}
