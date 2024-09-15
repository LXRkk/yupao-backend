package com.yupi.usercenter.service;
import java.util.Date;

import com.yupi.usercenter.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 罗秀让
 * @version 1.0
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

//    @Test
//    public void testAddUser() {
//        User user = new User();
//        // 使用GenerateAllSetter插件生成对象的所有set方法
//        user.setUsername("管理员");
//        user.setUserAccount("IKUN");
//        user.setAvatarUrl("https://cn.bing.com/images/search?q=ikun%E5%A4%B4%E5%83%8F&FORM=IQFRBA&id=4A996F325E2E7B3B11B79E9E92C33901CC522760");
//        user.setUserPassword("12345678");
//        user.setGender(1);
//        user.setEmail("IKUN@163.com");
//        user.setPhone("10001");
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
//        user.setUserRole(1);
//        boolean result = userService.save(user);
//        Assert.assertTrue(result);
//        System.out.println(user.getId());
//    }

    @Test
    void userRegister() {
        String userAccont = "yupi";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccont, userPassword, checkPassword);
        Assertions.assertEquals(-1,result);

        userAccont = "yu";
        result = userService.userRegister(userAccont,userPassword,checkPassword);
        Assertions.assertEquals(-1,result);

        userAccont = "yupi";
        userPassword = "123456";
        result = userService.userRegister(userAccont,userPassword,checkPassword);
        Assertions.assertEquals(-1,result);

        userAccont = "yu pi";
        userPassword = "12345678";
        result = userService.userRegister(userAccont,userPassword,checkPassword);
        Assertions.assertEquals(-1,result);

        checkPassword = "123456789";
        result = userService.userRegister(userAccont,userPassword,checkPassword);
        Assertions.assertEquals(-1,result);

        userAccont = "IKUN";
        checkPassword = "12345678";
        result = userService.userRegister(userAccont,userPassword,checkPassword);
        Assertions.assertEquals(-1,result);

        userAccont = "lisi";
        result = userService.userRegister(userAccont,userPassword,checkPassword);
        Assertions.assertTrue(result > 0);
    };
}