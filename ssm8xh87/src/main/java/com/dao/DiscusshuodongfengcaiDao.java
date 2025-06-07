package com.dao;

import com.entity.DiscusshuodongfengcaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusshuodongfengcaiVO;
import com.entity.view.DiscusshuodongfengcaiView;


/**
 * 活动风采评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface DiscusshuodongfengcaiDao extends BaseMapper<DiscusshuodongfengcaiEntity> {
	
	List<DiscusshuodongfengcaiVO> selectListVO(@Param("ew") Wrapper<DiscusshuodongfengcaiEntity> wrapper);
	
	DiscusshuodongfengcaiVO selectVO(@Param("ew") Wrapper<DiscusshuodongfengcaiEntity> wrapper);
	
	List<DiscusshuodongfengcaiView> selectListView(@Param("ew") Wrapper<DiscusshuodongfengcaiEntity> wrapper);

	List<DiscusshuodongfengcaiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusshuodongfengcaiEntity> wrapper);
	
	DiscusshuodongfengcaiView selectView(@Param("ew") Wrapper<DiscusshuodongfengcaiEntity> wrapper);
	

}
