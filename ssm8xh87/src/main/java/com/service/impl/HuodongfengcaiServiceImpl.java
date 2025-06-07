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


import com.dao.HuodongfengcaiDao;
import com.entity.HuodongfengcaiEntity;
import com.service.HuodongfengcaiService;
import com.entity.vo.HuodongfengcaiVO;
import com.entity.view.HuodongfengcaiView;

@Service("huodongfengcaiService")
public class HuodongfengcaiServiceImpl extends ServiceImpl<HuodongfengcaiDao, HuodongfengcaiEntity> implements HuodongfengcaiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongfengcaiEntity> page = this.selectPage(
                new Query<HuodongfengcaiEntity>(params).getPage(),
                new EntityWrapper<HuodongfengcaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongfengcaiEntity> wrapper) {
		  Page<HuodongfengcaiView> page =new Query<HuodongfengcaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongfengcaiVO> selectListVO(Wrapper<HuodongfengcaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongfengcaiVO selectVO(Wrapper<HuodongfengcaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongfengcaiView> selectListView(Wrapper<HuodongfengcaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongfengcaiView selectView(Wrapper<HuodongfengcaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
