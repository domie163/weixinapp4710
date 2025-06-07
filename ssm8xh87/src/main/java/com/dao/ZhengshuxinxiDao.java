package com.dao;

import com.entity.ZhengshuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhengshuxinxiVO;
import com.entity.view.ZhengshuxinxiView;


/**
 * 证书信息
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
public interface ZhengshuxinxiDao extends BaseMapper<ZhengshuxinxiEntity> {
	
	List<ZhengshuxinxiVO> selectListVO(@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);
	
	ZhengshuxinxiVO selectVO(@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);
	
	List<ZhengshuxinxiView> selectListView(@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);

	List<ZhengshuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);
	
	ZhengshuxinxiView selectView(@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);
	

}
