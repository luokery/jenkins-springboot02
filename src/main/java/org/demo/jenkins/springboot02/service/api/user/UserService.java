package org.demo.jenkins.springboot02.service.api.user;

import java.util.List;

import org.demo.jenkins.springboot02.model.dto.user.ForgetPasswordDTO;
import org.demo.jenkins.springboot02.model.dto.user.UserDTO;

public interface UserService {

    /**
     * 新增用户
     *
     * @param userInfo
     * @return
     */
    UserDTO save(UserDTO userInfo);
    
    /**
     * 用户列表
     *
     * @param userInfo
     * @return
     */
    List<UserDTO> list(UserDTO userInfo);
    
    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    UserDTO findByUserId(String userId);
    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    UserDTO findByUserName(String userName);
    
    /**
     * 通过用户名查询相同用户总数
     * @param userName
     * @return
     */
    Integer findCountByUserName(String userName);

	/**
	 * 忘记密码
	 * @param paramVO
	 * @return
	 */
	String forgetPassword(ForgetPasswordDTO forgetPasswordInfo);
}
