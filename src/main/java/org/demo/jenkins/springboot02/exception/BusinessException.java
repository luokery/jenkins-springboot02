package org.demo.jenkins.springboot02.exception;

import org.demo.jenkins.springboot02.cosnst.BusinessEnum;
import org.demo.jenkins.springboot02.cosnst.ResultFaceEnum;

/**
 * 业务异常
 * @author jun
 */
public class BusinessException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
    public BusinessException() {
        super();
    }
    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
    
    public BusinessException(Integer code, String msg, Exception e) {
        super(msg, e);
        this.code = code;
	}
    public BusinessException(BusinessEnum BusinessEnum) {
        super(BusinessEnum.getMsg());
        this.code = BusinessEnum.getCode();
    }
    
    public BusinessException(ResultFaceEnum ResultFaceEnum) {
        super(ResultFaceEnum.msg());
        this.code = ResultFaceEnum.code();
    }

	public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
