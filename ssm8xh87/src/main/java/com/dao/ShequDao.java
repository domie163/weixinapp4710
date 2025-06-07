package com.dao;

import com.entity.ShequEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShequVO;
import com.entity.view.ShequView;


/**
 * 社区
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
public interface ShequDao extends BaseMapper<ShequEntity> {
	
	List<ShequVO> selectListVO(@Param("ew") Wrapper<ShequEntity> wrapper);
	
	ShequVO selectVO(@Param("ew") Wrapper<ShequEntity> wrapper);
	
	List<ShequView> selectListView(@Param("ew") Wrapper<ShequEntity> wrapper);

	List<ShequView> selectListView(Pagination page,@Param("ew") Wrapper<ShequEntity> wrapper);
	
	ShequView selectView(@Param("ew") Wrapper<ShequEntity> wrapper);
	

}
