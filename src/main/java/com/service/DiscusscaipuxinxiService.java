package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.DiscusscaipuxinxiEntity;
import com.entity.view.DiscusscaipuxinxiView;
import com.entity.vo.DiscusscaipuxinxiVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 菜谱信息评论表
 *
 * @author
 * @email
 * @date 2023-02-08 11:44:38
 */
public interface DiscusscaipuxinxiService extends IService<DiscusscaipuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<DiscusscaipuxinxiVO> selectListVO(Wrapper<DiscusscaipuxinxiEntity> wrapper);

    DiscusscaipuxinxiVO selectVO(@Param("ew") Wrapper<DiscusscaipuxinxiEntity> wrapper);

    List<DiscusscaipuxinxiView> selectListView(Wrapper<DiscusscaipuxinxiEntity> wrapper);

    DiscusscaipuxinxiView selectView(@Param("ew") Wrapper<DiscusscaipuxinxiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusscaipuxinxiEntity> wrapper);


}

