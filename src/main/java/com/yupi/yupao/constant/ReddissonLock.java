package com.yupi.yupao.constant;

/**
 * 分布式锁
 *
 * @author : LXRkk
 * @date : 2024/12/3 16:38
 */
public interface ReddissonLock {

    /**
     * 定时任务(缓存预热)锁
     */
    String PRE_CACHE_JOB_LOCK = "yupao:precachejob:docache:lock";

    /**
     * 加入队伍锁
     */

    String JOIN_TEAM_LOCK = "yupao:join_team:lock";
}
