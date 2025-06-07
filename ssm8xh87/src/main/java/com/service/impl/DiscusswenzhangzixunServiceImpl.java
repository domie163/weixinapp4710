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


import com.dao.DiscusswenzhangzixunDao;
import com.entity.DiscusswenzhangzixunEntity;
import com.service.DiscusswenzhangzixunService;
import com.entity.vo.DiscusswenzhangzixunVO;
import com.entity.view.DiscusswenzhangzixunView;

@Service("discusswenzhangzixunService")
public class DiscusswenzhangzixunServiceImpl extends ServiceImpl<DiscusswenzhangzixunDao, DiscusswenzhangzixunEntity> implements DiscusswenzhangzixunService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswenzhangzixunEntity> page = this.selectPage(
                new Query<DiscusswenzhangzixunEntity>(params).getPage(),
                new EntityWrapper<DiscusswenzhangzixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswenzhangzixunEntity> wrapper) {
		  Page<DiscusswenzhangzixunView> page =new Query<DiscusswenzhangzixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusswenzhangzixunVO> selectListVO(Wrapper<DiscusswenzhangzixunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswenzhangzixunVO selectVO(Wrapper<DiscusswenzhangzixunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswenzhangzixunView> selectListView(Wrapper<DiscusswenzhangzixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswenzhangzixunView selectView(Wrapper<DiscusswenzhangzixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
