package com.yupi.yupao.service;
import java.util.Date;

import com.yupi.yupao.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * 注释
 *
 * @author : LXRkk
 * @date : 2024/11/19 16:25
 */
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //增
        valueOperations.set("yupiString","dog");
        valueOperations.set("yupiInt",1);
        valueOperations.set("yupiDouble",2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("dogdog");
        valueOperations.set("yupiUser", user);

        // 查
        Object yupiString = valueOperations.get("yupiString");
        Assertions.assertEquals("dog", yupiString);
        Object yupiInt = valueOperations.get("yupiInt");
        Assertions.assertTrue(1 == (Integer) yupiInt);
        Object yupiDouble = valueOperations.get("yupiDouble");
        Assertions.assertTrue(2.0 == (Double) yupiDouble);
        Object yupiUser = valueOperations.get("yupiUser");
        Assertions.assertTrue(user.equals((User)yupiUser));

        // 改
        valueOperations.set("yupiString", "cat");

        // 删
        redisTemplate.delete("yupiString");
    }
}
