package com.yupi.yupao.model.dto;


import com.yupi.yupao.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 队伍查询封装类
 *
 * @author : LXRkk
 * @date : 2024/11/25 17:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TeamQuery extends PageRequest {
    private static final long serialVersionUID = -4793593996885309161L;
    /**
     * id
     */
    private Long id;

    /**
     * 关键词查询（同时在 name 和 description 中查询）
     */
    private String searchText;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;


    /**
     * 用户id
     */
    private Long userId;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;
}
