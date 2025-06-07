package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusshuodongfengcaiDao;
import com.entity.DiscusshuodongfengcaiEntity;
import com.service.DiscusshuodongfengcaiService;
import com.entity.vo.DiscusshuodongfengcaiVO;
import com.entity.view.DiscusshuodongfengcaiView;

@Service("discusshuodongfengcaiService")
public class DiscusshuodongfengcaiServiceImpl extends ServiceImpl<DiscusshuodongfengcaiDao, DiscusshuodongfengcaiEntity> implements DiscusshuodongfengcaiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusshuodongfengcaiEntity> page = this.selectPage(
                new Query<DiscusshuodongfengcaiEntity>(params).getPage(),
                new EntityWrapper<DiscusshuodongfengcaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusshuodongfengcaiEntity> wrapper) {
		  Page<DiscusshuodongfengcaiView> page =new Query<DiscusshuodongfengcaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusshuodongfengcaiVO> selectListVO(Wrapper<DiscusshuodongfengcaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusshuodongfengcaiVO selectVO(Wrapper<DiscusshuodongfengcaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusshuodongfengcaiView> selectListView(Wrapper<DiscusshuodongfengcaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusshuodongfengcaiView selectView(Wrapper<DiscusshuodongfengcaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
