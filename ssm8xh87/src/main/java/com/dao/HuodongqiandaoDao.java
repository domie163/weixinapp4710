package com.dao;

import com.entity.HuodongqiandaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongqiandaoVO;
import com.entity.view.HuodongqiandaoView;


/**
 * 活动签到
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
public interface HuodongqiandaoDao extends BaseMapper<HuodongqiandaoEntity> {
	
	List<HuodongqiandaoVO> selectListVO(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);
	
	HuodongqiandaoVO selectVO(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);
	
	List<HuodongqiandaoView> selectListView(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);

	List<HuodongqiandaoView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);
	
	HuodongqiandaoView selectView(@Param("ew") Wrapper<HuodongqiandaoEntity> wrapper);
	

}
