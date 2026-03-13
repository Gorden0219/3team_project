package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ExampaperEntity;
import com.entity.view.ExampaperView;
import com.entity.vo.ExampaperVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 趣味答题表
 *
 * @author
 * @email
 * @date 2023-02-08 11:44:37
 */
public interface ExampaperService extends IService<ExampaperEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ExampaperVO> selectListVO(Wrapper<ExampaperEntity> wrapper);

    ExampaperVO selectVO(@Param("ew") Wrapper<ExampaperEntity> wrapper);

    List<ExampaperView> selectListView(Wrapper<ExampaperEntity> wrapper);

    ExampaperView selectView(@Param("ew") Wrapper<ExampaperEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<ExampaperEntity> wrapper);


}

