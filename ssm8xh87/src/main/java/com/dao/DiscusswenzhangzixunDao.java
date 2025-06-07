package com.dao;

import com.entity.DiscusswenzhangzixunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusswenzhangzixunVO;
import com.entity.view.DiscusswenzhangzixunView;


/**
 * 文章资讯评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface DiscusswenzhangzixunDao extends BaseMapper<DiscusswenzhangzixunEntity> {
	
	List<DiscusswenzhangzixunVO> selectListVO(@Param("ew") Wrapper<DiscusswenzhangzixunEntity> wrapper);
	
	DiscusswenzhangzixunVO selectVO(@Param("ew") Wrapper<DiscusswenzhangzixunEntity> wrapper);
	
	List<DiscusswenzhangzixunView> selectListView(@Param("ew") Wrapper<DiscusswenzhangzixunEntity> wrapper);

	List<DiscusswenzhangzixunView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusswenzhangzixunEntity> wrapper);
	
	DiscusswenzhangzixunView selectView(@Param("ew") Wrapper<DiscusswenzhangzixunEntity> wrapper);
	

}
