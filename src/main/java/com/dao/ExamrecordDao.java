package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ExamrecordEntity;
import com.entity.view.ExamrecordView;
import com.entity.vo.ExamrecordVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 考试记录表
 *
 * @author
 * @email
 * @date 2026-03-03 11:44:37
 */
public interface ExamrecordDao extends BaseMapper<ExamrecordEntity> {

    List<ExamrecordVO> selectListVO(@Param("ew") Wrapper<ExamrecordEntity> wrapper);

    ExamrecordVO selectVO(@Param("ew") Wrapper<ExamrecordEntity> wrapper);

    List<ExamrecordView> selectListView(@Param("ew") Wrapper<ExamrecordEntity> wrapper);

    List<ExamrecordView> selectListView(Pagination page, @Param("ew") Wrapper<ExamrecordEntity> wrapper);

    ExamrecordView selectView(@Param("ew") Wrapper<ExamrecordEntity> wrapper);

    List<ExamrecordView> selectGroupBy(Pagination page, @Param("ew") Wrapper<ExamrecordEntity> wrapper);

}
