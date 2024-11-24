package com.yupi.yupao.once;

import com.yupi.yupao.mapper.UserMapper;
import com.yupi.yupao.model.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * 注释
 *
 * @author : LXRkk
 * @date : 2024/11/17 12:50
 */
public class InsertUsers {

        @Resource
        private UserMapper userMapper;

        /**
         * 批量插入用户
         */
        @Scheduled(initialDelay = 5000,fixedRate = Long.MAX_VALUE)
        public void doInsertUsers() {
            StopWatch stopWatch = new StopWatch();
            System.out.println("goodgoodgood");
            stopWatch.start();
            final int INSERT_NUM = 10000000;
            for (int i = 0; i < INSERT_NUM; i++) {
                User user = new User();
                user.setUsername("假i坤");
                user.setUserAccount("fakeIKun");
                user.setAvatarUrl("https://img1.baidu.com/it/u=1593147271,2036468941&fm=253&fmt=auto&app=138&f=JPEG?w=907&h=800");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setEmail("fakeIKun@163.com");
                user.setTags("[]");
                user.setUserStatus(0);
                user.setPhone("10096");
                user.setUserRole(0);
                userMapper.insert(user);
            }
            stopWatch.stop();
            System.out.println(stopWatch.getTotalTimeMillis());
        }
}
