package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ExampaperEntity;
import com.entity.view.ExampaperView;
import com.entity.vo.ExampaperVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 趣味答题表
 *
 * @author
 * @email
 * @date 2023-02-08 11:44:37
 */
public interface ExampaperDao extends BaseMapper<ExampaperEntity> {

    List<ExampaperVO> selectListVO(@Param("ew") Wrapper<ExampaperEntity> wrapper);

    ExampaperVO selectVO(@Param("ew") Wrapper<ExampaperEntity> wrapper);

    List<ExampaperView> selectListView(@Param("ew") Wrapper<ExampaperEntity> wrapper);

    List<ExampaperView> selectListView(Pagination page, @Param("ew") Wrapper<ExampaperEntity> wrapper);

    ExampaperView selectView(@Param("ew") Wrapper<ExampaperEntity> wrapper);


}
