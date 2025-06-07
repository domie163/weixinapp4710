package com.dao;

import com.entity.WenzhangzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WenzhangzixunVO;
import com.entity.view.WenzhangzixunView;


/**
 * 文章资讯
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface WenzhangzixunDao extends BaseMapper<WenzhangzixunEntity> {
	
	List<WenzhangzixunVO> selectListVO(@Param("ew") Wrapper<WenzhangzixunEntity> wrapper);
	
	WenzhangzixunVO selectVO(@Param("ew") Wrapper<WenzhangzixunEntity> wrapper);
	
	List<WenzhangzixunView> selectListView(@Param("ew") Wrapper<WenzhangzixunEntity> wrapper);

	List<WenzhangzixunView> selectListView(Pagination page,@Param("ew") Wrapper<WenzhangzixunEntity> wrapper);
	
	WenzhangzixunView selectView(@Param("ew") Wrapper<WenzhangzixunEntity> wrapper);
	

}
