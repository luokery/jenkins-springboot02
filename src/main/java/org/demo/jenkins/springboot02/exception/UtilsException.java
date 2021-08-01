package org.demo.jenkins.springboot02.exception;

import org.demo.jenkins.springboot02.cosnst.ResultFaceEnum;

public class UtilsException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public UtilsException(Integer code, String msg) {
        super(code, msg);
    }
    
    public UtilsException(ResultFaceEnum ResultFaceEnum) {
        super(ResultFaceEnum.code(), ResultFaceEnum.msg());
    }
}
