package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.CaipinfenleiEntity;
import com.entity.view.CaipinfenleiView;
import com.entity.vo.CaipinfenleiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 菜品分类
 *
 * @author
 * @email
 * @date 2026-03-03 11:44:37
 */
public interface CaipinfenleiDao extends BaseMapper<CaipinfenleiEntity> {

    List<CaipinfenleiVO> selectListVO(@Param("ew") Wrapper<CaipinfenleiEntity> wrapper);

    CaipinfenleiVO selectVO(@Param("ew") Wrapper<CaipinfenleiEntity> wrapper);

    List<CaipinfenleiView> selectListView(@Param("ew") Wrapper<CaipinfenleiEntity> wrapper);

    List<CaipinfenleiView> selectListView(Pagination page, @Param("ew") Wrapper<CaipinfenleiEntity> wrapper);

    CaipinfenleiView selectView(@Param("ew") Wrapper<CaipinfenleiEntity> wrapper);


}
