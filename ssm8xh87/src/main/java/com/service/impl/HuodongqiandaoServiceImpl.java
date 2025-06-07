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


import com.dao.HuodongqiandaoDao;
import com.entity.HuodongqiandaoEntity;
import com.service.HuodongqiandaoService;
import com.entity.vo.HuodongqiandaoVO;
import com.entity.view.HuodongqiandaoView;

@Service("huodongqiandaoService")
public class HuodongqiandaoServiceImpl extends ServiceImpl<HuodongqiandaoDao, HuodongqiandaoEntity> implements HuodongqiandaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuodongqiandaoEntity> page = this.selectPage(
                new Query<HuodongqiandaoEntity>(params).getPage(),
                new EntityWrapper<HuodongqiandaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuodongqiandaoEntity> wrapper) {
		  Page<HuodongqiandaoView> page =new Query<HuodongqiandaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<HuodongqiandaoVO> selectListVO(Wrapper<HuodongqiandaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public HuodongqiandaoVO selectVO(Wrapper<HuodongqiandaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<HuodongqiandaoView> selectListView(Wrapper<HuodongqiandaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuodongqiandaoView selectView(Wrapper<HuodongqiandaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
