package com.yupi.yupao.service;

import com.yupi.yupao.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 *算法工具类测试
 *
 * @author : LXRkk
 * @date : 2024/11/30 19:24
 */
@SpringBootTest
class AlgorithmUtilsTest {

    @Test
    void test() {
        String str1 = ("今天出太阳");
        String str2 = ("今天没出太阳");
        String str3 = ("今天出没出太阳");
        int score1 = AlgorithmUtils.minDistance(str1, str2); // 1
        int score2 = AlgorithmUtils.minDistance(str1, str3); // 2
        System.out.println(score1);
        System.out.println(score2);
    }

    @Test
    void testCompareTags() {
        List<String> tagList1 = Arrays.asList("Java", "大一", "男");
        List<String> tagList2 = Arrays.asList("Java", "大一", "女");
        List<String> tagList3 = Arrays.asList("Python", "大二", "男");
        int score1 = AlgorithmUtils.minDistance(tagList1, tagList2); // 1
        int score2 = AlgorithmUtils.minDistance(tagList1, tagList3); // 2
        System.out.println(score1);
        System.out.println(score2);
    }
}
