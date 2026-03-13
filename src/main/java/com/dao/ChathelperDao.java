package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ChathelperEntity;
import com.entity.view.ChathelperView;
import com.entity.vo.ChathelperVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 聊天助手表
 *
 * @author
 * @email
 * @date 2023-02-08 11:44:37
 */
public interface ChathelperDao extends BaseMapper<ChathelperEntity> {

    List<ChathelperVO> selectListVO(@Param("ew") Wrapper<ChathelperEntity> wrapper);

    ChathelperVO selectVO(@Param("ew") Wrapper<ChathelperEntity> wrapper);

    List<ChathelperView> selectListView(@Param("ew") Wrapper<ChathelperEntity> wrapper);

    List<ChathelperView> selectListView(Pagination page, @Param("ew") Wrapper<ChathelperEntity> wrapper);

    ChathelperView selectView(@Param("ew") Wrapper<ChathelperEntity> wrapper);


}
