package org.demo.jenkins.springboot02.vo;

import org.demo.jenkins.springboot02.common.util.ResponseUtil;
import org.demo.jenkins.springboot02.cosnst.ConstBase;
import org.demo.jenkins.springboot02.cosnst.ResultFaceEnum;
import org.slf4j.MDC;


public class ResponseVO<T> {
	
	/**
	 * 流水号: 请求发送的流水号, 与返回的流水号对应
	 */
	private String serialNumber;
	
	/**
	 * 令牌: 身份令牌
	 */
	private String token;
	
	/**
	 * 来源: 公司, 应用(配合密钥处理)
	 */
	private String source;
	
	/**
	 * 请求版本: 匹配服务版本
	 */
	private String version;
	
	/**
	 * 响应代码: 0是成功, 非0失败, 为具体错误代码
	 */
	private String code;
	
	/**
	 * 响应消息: 消息
	 */
	private String msg;
	
	/**
	 * 响应的数据: 对应的VO
	 */
	private T data;
	
    /**
     * 成功，不用返回数据
     *
     * @return
     */
    public static <T> ResponseVO<T> buildSuccess() {
        return ResponseUtil.success();
    }

    /**
     * 成功，返回数据
     *
     * @param data
     * @return
     */
    public static <T> ResponseVO<T> buildSuccess(T data) {
        return ResponseUtil.success(data);
    }


    /**
     * 失败，固定状态码
     *
     * @param msg
     * @return
     */
    public static <T> ResponseVO<T> buildError() {
        return ResponseUtil.error();
    }

    /**
     * 失败，自定义错误码和信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static <T> ResponseVO<T> buildError(String msg) {
        return ResponseUtil.error(msg);
    }
	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCode(Integer code) {
		this.code = String.valueOf( code);
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseVO [serialNumber=" + serialNumber + ", token=" + token + ", source=" + source + ", version="
				+ version + ", code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
}
