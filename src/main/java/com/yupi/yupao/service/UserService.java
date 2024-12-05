package com.yupi.yupao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yupao.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Chris
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2024-09-04 10:59:27
*/
public interface UserService extends IService<User> {


    /**
     * 用户注册
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);

    /**
     * 用户登录
     * @param userAccount 用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser 未脱敏用户
     * @return 脱敏用户
     */
    User getSafetyUser(User originUser);

    /**
     * 用户退出登录
     * @param request 请求对象
     * @return 退出成功返回1
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     *
     * @param tagNameList
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);

    /**
     * 更新用户信息
     * @param user 需要修改信息的用户
     * @return
     */
    int updateUser(User user, User loginUser);

    /**
     * 获取当前登录用户信息
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 是否为管理员
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 是否为管理员
     * @param loginUser 当前登录用户
     * @return
     */
    boolean isAdmin(User loginUser);

    /**
     * 获取最匹配的用户
     * @param num 匹配的数量
     * @param loginUser
     * @return
     */
    List<User> matchUsers(long num, User loginUser);
}
