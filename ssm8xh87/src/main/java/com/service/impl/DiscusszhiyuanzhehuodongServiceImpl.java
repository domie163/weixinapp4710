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


import com.dao.DiscusszhiyuanzhehuodongDao;
import com.entity.DiscusszhiyuanzhehuodongEntity;
import com.service.DiscusszhiyuanzhehuodongService;
import com.entity.vo.DiscusszhiyuanzhehuodongVO;
import com.entity.view.DiscusszhiyuanzhehuodongView;

@Service("discusszhiyuanzhehuodongService")
public class DiscusszhiyuanzhehuodongServiceImpl extends ServiceImpl<DiscusszhiyuanzhehuodongDao, DiscusszhiyuanzhehuodongEntity> implements DiscusszhiyuanzhehuodongService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhiyuanzhehuodongEntity> page = this.selectPage(
                new Query<DiscusszhiyuanzhehuodongEntity>(params).getPage(),
                new EntityWrapper<DiscusszhiyuanzhehuodongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper) {
		  Page<DiscusszhiyuanzhehuodongView> page =new Query<DiscusszhiyuanzhehuodongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhiyuanzhehuodongVO> selectListVO(Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhiyuanzhehuodongVO selectVO(Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhiyuanzhehuodongView> selectListView(Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhiyuanzhehuodongView selectView(Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
