package com.yupi.yupao.service;

import com.yupi.yupao.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * 注释
 *
 * @author : LXRkk
 * @date : 2024/11/17 13:16
 */
@SpringBootTest
public class InsertUsersTest {

    @Resource
    private UserService userService;

    private ExecutorService executorService = new ThreadPoolExecutor(60,1000,10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));

    /**
     * 批量插入用户，项目打包时需要删掉此类
     */
    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        List<User> userList = new ArrayList<>();
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
            userList.add(user);
        }
        // 18秒 插入10万条数据
        userService.saveBatch(userList, 10000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    /**
     * 并发批量插入用户，项目打包时需要删掉此类
     */
    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        // 分 10 组
        int batchSize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            List<User> userList = Collections.synchronizedList(new ArrayList<>());
            do {
                j++;
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
                userList.add(user);
            } while (j % batchSize != 0);
            // 异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("threadName: " + Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            }, executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        // 7秒 插入10万条数据
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
