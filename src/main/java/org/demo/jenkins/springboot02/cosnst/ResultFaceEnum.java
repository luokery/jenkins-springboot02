package org.demo.jenkins.springboot02.cosnst;


public interface ResultFaceEnum {
	/**
	 * 获取代码
	 * @return
	 */
	Integer code();
	/**
	 * 获取消息
	 * @return
	 */
	String msg();
	
	/**
	 * 获取日志消息
	 * @return
	 */
	String toLogMsg();
}
