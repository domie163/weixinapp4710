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


import com.dao.WenzhangzixunDao;
import com.entity.WenzhangzixunEntity;
import com.service.WenzhangzixunService;
import com.entity.vo.WenzhangzixunVO;
import com.entity.view.WenzhangzixunView;

@Service("wenzhangzixunService")
public class WenzhangzixunServiceImpl extends ServiceImpl<WenzhangzixunDao, WenzhangzixunEntity> implements WenzhangzixunService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenzhangzixunEntity> page = this.selectPage(
                new Query<WenzhangzixunEntity>(params).getPage(),
                new EntityWrapper<WenzhangzixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenzhangzixunEntity> wrapper) {
		  Page<WenzhangzixunView> page =new Query<WenzhangzixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WenzhangzixunVO> selectListVO(Wrapper<WenzhangzixunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WenzhangzixunVO selectVO(Wrapper<WenzhangzixunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WenzhangzixunView> selectListView(Wrapper<WenzhangzixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenzhangzixunView selectView(Wrapper<WenzhangzixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
