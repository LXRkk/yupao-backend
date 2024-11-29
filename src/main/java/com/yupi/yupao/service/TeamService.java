package com.yupi.yupao.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yupao.model.Team;
import com.yupi.yupao.model.User;
import com.yupi.yupao.model.dto.TeamQuery;
import com.yupi.yupao.model.request.TeamJoinRequest;
import com.yupi.yupao.model.request.TeamUpdateRequest;
import com.yupi.yupao.model.vo.TeamUserVO;

import java.util.List;

/**
* @author Chris
* @description 针对表【team(队伍表)】的数据库操作Service
* @createDate 2024-11-24 15:57:05
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 查询队伍
     * @param teamQuery
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     *更新队伍
     * @param teamUpdateRequest
     * @param loginUser 登录用户
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);
}
