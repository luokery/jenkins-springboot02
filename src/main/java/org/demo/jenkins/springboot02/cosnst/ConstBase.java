package org.demo.jenkins.springboot02.cosnst;

import java.text.MessageFormat;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * 系统基础常量
 * @author jun
 */
public interface ConstBase {
	
	/**
	 * 认证token
	 */
	public static final String AUTHORIZATION_KEY = "access_token";
	
	/**
	 * 日志流水号
	 */
	public static final String BUSINESS_NO_KEY = "BUSINESS_NO";
	
	/**短信key*/
	public static final String sms_Code_key = "sms:code:";
//	/**短信忘记密码key*/
//	public static final String sms_Code_forget_password_key = "sms:code:forgetpassword:";
	
	/**
	 * 验证码存活时间
	 */
	public static final Long VERIFICATION_CODE_TIME = 5l;
	
	public static final Long VERIFICATION_SMS_CODE_TIME = 5l;
	
	public static final String SESSION_ID_KEY_PREFIX = "session:redis:";
	public static final ZoneOffset ZONE_DEFAULT = ZoneOffset.of("+08:00");

	public enum ResultEnum implements ResultFaceEnum {
		
	    UNKONW_ERROR(500, "未知错误"),
	    SUCCESS(0, "成功"),
	    ERROR(1, "失败"),
	    PARAM_c_ERROR(5, "参数转换失败"),
	    PARAM_v_ERROR(6, "参数验证失败"),
	    Unauthorized(401, "请先登录"),
	    Forbidden(403, "没有权限!"),
	    LoginFailure(401, "登录凭证已失效，请重新登录"),
	    ;

	    private Integer code;

	    private String msg;

	    ResultEnum(Integer code, String msg) {
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
}
