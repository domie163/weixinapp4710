package com.dao;

import com.entity.DiscusszhiyuanzhehuodongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhiyuanzhehuodongVO;
import com.entity.view.DiscusszhiyuanzhehuodongView;


/**
 * 志愿者活动评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface DiscusszhiyuanzhehuodongDao extends BaseMapper<DiscusszhiyuanzhehuodongEntity> {
	
	List<DiscusszhiyuanzhehuodongVO> selectListVO(@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
	
	DiscusszhiyuanzhehuodongVO selectVO(@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
	
	List<DiscusszhiyuanzhehuodongView> selectListView(@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);

	List<DiscusszhiyuanzhehuodongView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
	
	DiscusszhiyuanzhehuodongView selectView(@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
	

}
