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


import com.dao.ZhiyuanzhehuodongDao;
import com.entity.ZhiyuanzhehuodongEntity;
import com.service.ZhiyuanzhehuodongService;
import com.entity.vo.ZhiyuanzhehuodongVO;
import com.entity.view.ZhiyuanzhehuodongView;

@Service("zhiyuanzhehuodongService")
public class ZhiyuanzhehuodongServiceImpl extends ServiceImpl<ZhiyuanzhehuodongDao, ZhiyuanzhehuodongEntity> implements ZhiyuanzhehuodongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhiyuanzhehuodongEntity> page = this.selectPage(
                new Query<ZhiyuanzhehuodongEntity>(params).getPage(),
                new EntityWrapper<ZhiyuanzhehuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhiyuanzhehuodongEntity> wrapper) {
		  Page<ZhiyuanzhehuodongView> page =new Query<ZhiyuanzhehuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhiyuanzhehuodongVO> selectListVO(Wrapper<ZhiyuanzhehuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhiyuanzhehuodongVO selectVO(Wrapper<ZhiyuanzhehuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhiyuanzhehuodongView> selectListView(Wrapper<ZhiyuanzhehuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhiyuanzhehuodongView selectView(Wrapper<ZhiyuanzhehuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
