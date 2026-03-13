package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.DiscusscaipuxinxiEntity;
import com.entity.view.DiscusscaipuxinxiView;
import com.entity.vo.DiscusscaipuxinxiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 菜谱信息评论表
 *
 * @author
 * @email
 * @date 2023-02-08 11:44:38
 */
public interface DiscusscaipuxinxiDao extends BaseMapper<DiscusscaipuxinxiEntity> {

    List<DiscusscaipuxinxiVO> selectListVO(@Param("ew") Wrapper<DiscusscaipuxinxiEntity> wrapper);

    DiscusscaipuxinxiVO selectVO(@Param("ew") Wrapper<DiscusscaipuxinxiEntity> wrapper);

    List<DiscusscaipuxinxiView> selectListView(@Param("ew") Wrapper<DiscusscaipuxinxiEntity> wrapper);

    List<DiscusscaipuxinxiView> selectListView(Pagination page, @Param("ew") Wrapper<DiscusscaipuxinxiEntity> wrapper);

    DiscusscaipuxinxiView selectView(@Param("ew") Wrapper<DiscusscaipuxinxiEntity> wrapper);


}
