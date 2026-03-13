package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ChathelperEntity;
import com.entity.view.ChathelperView;
import com.entity.vo.ChathelperVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 聊天助手表
 *
 * @author
 * @email
 * @date 2023-02-08 11:44:37
 */
public interface ChathelperService extends IService<ChathelperEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ChathelperVO> selectListVO(Wrapper<ChathelperEntity> wrapper);

    ChathelperVO selectVO(@Param("ew") Wrapper<ChathelperEntity> wrapper);

    List<ChathelperView> selectListView(Wrapper<ChathelperEntity> wrapper);

    ChathelperView selectView(@Param("ew") Wrapper<ChathelperEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ChathelperEntity> wrapper);


}

