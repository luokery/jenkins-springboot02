package org.demo.jenkins.springboot02.cosnst;

import java.text.MessageFormat;

/**
 * 系统结果异常
 * 
 *      200                         请求成功
 *	    400 bad request	    		常用在参数校验
 *	    401 unauthorized			未经验证的用户，常见于未登录。如果经过验证后依然没权限，应该 403（即 authentication 和 authorization 的区别）。
 *	    403 forbidden	    		无权限
 *	    404 not found	    		资源不存在
 *	    500 internal server error	非业务类异常
 *	    503 service unavaliable		由容器抛出，自己的代码不要抛这个异常
 * @author jun
 */
public enum BaseResultEnum implements ResultFaceEnum {
	
    UNKONW_ERROR(500, "未知错误")
    , SUCCESS(0, "成功")
    , ERROR(1, "失败")
    ;

	private Integer code;

    private String msg;

    BaseResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    
    private static final String toLogMsgPattern = "code=[{0}] {1}";
    
    @Override
	public String toLogMsg() {
		return MessageFormat.format(toLogMsgPattern, code, msg);
	}

	@Override
	public Integer code() {
		return code;
	}

	@Override
	public String msg() {
		return msg;
	}
}