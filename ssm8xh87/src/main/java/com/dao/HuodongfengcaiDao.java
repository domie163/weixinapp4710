package com.dao;

import com.entity.HuodongfengcaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongfengcaiVO;
import com.entity.view.HuodongfengcaiView;


/**
 * 活动风采
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface HuodongfengcaiDao extends BaseMapper<HuodongfengcaiEntity> {
	
	List<HuodongfengcaiVO> selectListVO(@Param("ew") Wrapper<HuodongfengcaiEntity> wrapper);
	
	HuodongfengcaiVO selectVO(@Param("ew") Wrapper<HuodongfengcaiEntity> wrapper);
	
	List<HuodongfengcaiView> selectListView(@Param("ew") Wrapper<HuodongfengcaiEntity> wrapper);

	List<HuodongfengcaiView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongfengcaiEntity> wrapper);
	
	HuodongfengcaiView selectView(@Param("ew") Wrapper<HuodongfengcaiEntity> wrapper);
	

}
