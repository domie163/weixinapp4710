package com.dao;

import com.entity.ZhiyuanzhehuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhiyuanzhehuodongVO;
import com.entity.view.ZhiyuanzhehuodongView;


/**
 * 志愿者活动
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
public interface ZhiyuanzhehuodongDao extends BaseMapper<ZhiyuanzhehuodongEntity> {
	
	List<ZhiyuanzhehuodongVO> selectListVO(@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);
	
	ZhiyuanzhehuodongVO selectVO(@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);
	
	List<ZhiyuanzhehuodongView> selectListView(@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);

	List<ZhiyuanzhehuodongView> selectListView(Pagination page,@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);
	
	ZhiyuanzhehuodongView selectView(@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);
	

}
