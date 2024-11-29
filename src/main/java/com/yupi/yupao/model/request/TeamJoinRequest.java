package com.yupi.yupao.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 加入队伍包装类
 * @author 罗秀让
 * @version 1.0
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = -2799635978045938170L;

    /**
     * 队伍 id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;
}
