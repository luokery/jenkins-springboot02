package org.demo.jenkins.springboot02.controller;


import org.demo.jenkins.springboot02.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页控制器
 * @author izhem
 *
 */
@RestController
public class IndexController {

	/**
	 * 虚拟根节点 忽略对根的请求.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseVO<String> root() {
		return ResponseVO.buildSuccess();
	}
}
