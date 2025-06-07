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


import com.dao.ZhengshuxinxiDao;
import com.entity.ZhengshuxinxiEntity;
import com.service.ZhengshuxinxiService;
import com.entity.vo.ZhengshuxinxiVO;
import com.entity.view.ZhengshuxinxiView;

@Service("zhengshuxinxiService")
public class ZhengshuxinxiServiceImpl extends ServiceImpl<ZhengshuxinxiDao, ZhengshuxinxiEntity> implements ZhengshuxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhengshuxinxiEntity> page = this.selectPage(
                new Query<ZhengshuxinxiEntity>(params).getPage(),
                new EntityWrapper<ZhengshuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhengshuxinxiEntity> wrapper) {
		  Page<ZhengshuxinxiView> page =new Query<ZhengshuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhengshuxinxiVO> selectListVO(Wrapper<ZhengshuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhengshuxinxiVO selectVO(Wrapper<ZhengshuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhengshuxinxiView> selectListView(Wrapper<ZhengshuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhengshuxinxiView selectView(Wrapper<ZhengshuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
