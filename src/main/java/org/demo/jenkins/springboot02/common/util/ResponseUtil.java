package org.demo.jenkins.springboot02.common.util;

import org.demo.jenkins.springboot02.cosnst.BaseResultEnum;
import org.demo.jenkins.springboot02.cosnst.ConstBase;
import org.demo.jenkins.springboot02.cosnst.ResultFaceEnum;
import org.demo.jenkins.springboot02.vo.ResponseVO;
import org.slf4j.MDC;

/**
 * 响应自定义构建工具
 * @author jun
 */
public class ResponseUtil {
	
	/**
	 * 响应构建(code String)
	 * @param <T>
	 * @param code  返回的代码
	 * @param msg	返回的消息
	 * @param data  返回的数据
	 * @return
	 */
	public static <T> ResponseVO<T> build(String code, String msg, T data){
		ResponseVO<T> responseVO = new ResponseVO<T>();
		responseVO.setCode(code);
		responseVO.setMsg(msg);
		responseVO.setData(data);
		responseVO.setSerialNumber( MDC.get( ConstBase.BUSINESS_NO_KEY));
		return responseVO;
	}
	
	/**
	 * 响应构建(code Integer)
	 * @param <T>
	 * @param code  返回的代码
	 * @param msg	返回的消息
	 * @param data  返回的数据
	 * @return
	 */
	public static <T> ResponseVO<T> build(Integer code, String msg, T data){
		ResponseVO<T> responseVO = new ResponseVO<T>();
		responseVO.setCode( String.valueOf(code));
		responseVO.setMsg( msg);
		responseVO.setData( data);
		responseVO.setSerialNumber( MDC.get( ConstBase.BUSINESS_NO_KEY));
		return responseVO;
	}
	
	/**
	 * 响应构建(ResultFaceEnum T)
	 * @param <T>
	 * @param faceEnum
	 * @param data
	 * @return
	 */
	public static <T> ResponseVO<T> build(ResultFaceEnum faceEnum, T data){
		ResponseVO<T> responseVO = new ResponseVO<T>();
		responseVO.setCode( String.valueOf( faceEnum.code()));
		responseVO.setMsg( faceEnum.msg());
		responseVO.setData( data);
		responseVO.setSerialNumber( MDC.get( ConstBase.BUSINESS_NO_KEY));
		return responseVO;
	}
	/**
	 * 响应构建(ResultFaceEnum)
	 * @param <T>
	 * @param faceEnum
	 * @param data
	 * @return
	 */
	public static <T> ResponseVO<T> build(ResultFaceEnum faceEnum){
		ResponseVO<T> responseVO = new ResponseVO<T>();
		responseVO.setCode( String.valueOf( faceEnum.code()));
		responseVO.setMsg( faceEnum.msg());
		responseVO.setSerialNumber( MDC.get( ConstBase.BUSINESS_NO_KEY));
		return responseVO;
	}
	
	/**
	 * 系统默认返回成功(无数据)
	 * @param <T>
	 * @return
	 */
	public static <T> ResponseVO<T> success(){
		return ResponseUtil.build(BaseResultEnum.SUCCESS, null);
	}
	
	/**
	 * 系统默认返回成功(有数据)
	 * @param <T>
	 * @return
	 */
	public static <T> ResponseVO<T> success(T data){
		return ResponseUtil.build(BaseResultEnum.SUCCESS, data);
	}
	
	/**
	 * 系统默认返回错误(无数据/无错误信息)
	 * @param <T>
	 * @return
	 */
	public static <T> ResponseVO<T> error(){
		return ResponseUtil.build(BaseResultEnum.ERROR.code(), null, null);
	}
	
	/**
	 * 系统默认返回错误(无数据/有错误信息)
	 * @param <T>
	 * @return
	 */
	public static <T> ResponseVO<T> error(String msg){
		return ResponseUtil.build(BaseResultEnum.ERROR.code(), msg, null);
	}
}
