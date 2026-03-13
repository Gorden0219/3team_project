package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.DiscusscaipuxinxiDao;
import com.entity.DiscusscaipuxinxiEntity;
import com.entity.view.DiscusscaipuxinxiView;
import com.entity.vo.DiscusscaipuxinxiVO;
import com.service.DiscusscaipuxinxiService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("discusscaipuxinxiService")
public class DiscusscaipuxinxiServiceImpl extends ServiceImpl<DiscusscaipuxinxiDao, DiscusscaipuxinxiEntity> implements DiscusscaipuxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusscaipuxinxiEntity> page = this.selectPage(
                new Query<DiscusscaipuxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusscaipuxinxiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusscaipuxinxiEntity> wrapper) {
        Page<DiscusscaipuxinxiView> page = new Query<DiscusscaipuxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<DiscusscaipuxinxiVO> selectListVO(Wrapper<DiscusscaipuxinxiEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public DiscusscaipuxinxiVO selectVO(Wrapper<DiscusscaipuxinxiEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<DiscusscaipuxinxiView> selectListView(Wrapper<DiscusscaipuxinxiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public DiscusscaipuxinxiView selectView(Wrapper<DiscusscaipuxinxiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }


}
