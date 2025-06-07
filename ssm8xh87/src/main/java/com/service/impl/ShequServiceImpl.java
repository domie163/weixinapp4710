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


import com.dao.ShequDao;
import com.entity.ShequEntity;
import com.service.ShequService;
import com.entity.vo.ShequVO;
import com.entity.view.ShequView;

@Service("shequService")
public class ShequServiceImpl extends ServiceImpl<ShequDao, ShequEntity> implements ShequService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShequEntity> page = this.selectPage(
                new Query<ShequEntity>(params).getPage(),
                new EntityWrapper<ShequEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShequEntity> wrapper) {
		  Page<ShequView> page =new Query<ShequView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShequVO> selectListVO(Wrapper<ShequEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShequVO selectVO(Wrapper<ShequEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShequView> selectListView(Wrapper<ShequEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShequView selectView(Wrapper<ShequEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
