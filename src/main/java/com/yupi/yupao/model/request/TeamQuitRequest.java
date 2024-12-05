package com.yupi.yupao.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 退出队伍请求体
 * @author 罗秀让
 * @version 1.0
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = -2799635978045938170L;

    /**
     * 队伍 id
     */
    private Long teamId;
}
