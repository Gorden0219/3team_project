package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ExamquestionEntity;
import com.entity.view.ExamquestionView;
import com.entity.vo.ExamquestionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 试题表
 *
 * @author
 * @email
 * @date 2023-02-08 11:44:37
 */
public interface ExamquestionDao extends BaseMapper<ExamquestionEntity> {

    List<ExamquestionVO> selectListVO(@Param("ew") Wrapper<ExamquestionEntity> wrapper);

    ExamquestionVO selectVO(@Param("ew") Wrapper<ExamquestionEntity> wrapper);

    List<ExamquestionView> selectListView(@Param("ew") Wrapper<ExamquestionEntity> wrapper);

    List<ExamquestionView> selectListView(Pagination page, @Param("ew") Wrapper<ExamquestionEntity> wrapper);

    ExamquestionView selectView(@Param("ew") Wrapper<ExamquestionEntity> wrapper);


}
