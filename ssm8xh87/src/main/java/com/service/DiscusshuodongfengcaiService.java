package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusshuodongfengcaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusshuodongfengcaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusshuodongfengcaiView;


/**
 * 活动风采评论表
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface DiscusshuodongfengcaiService extends IService<DiscusshuodongfengcaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusshuodongfengcaiVO> selectListVO(Wrapper<DiscusshuodongfengcaiEntity> wrapper);
   	
   	DiscusshuodongfengcaiVO selectVO(@Param("ew") Wrapper<DiscusshuodongfengcaiEntity> wrapper);
   	
   	List<DiscusshuodongfengcaiView> selectListView(Wrapper<DiscusshuodongfengcaiEntity> wrapper);
   	
   	DiscusshuodongfengcaiView selectView(@Param("ew") Wrapper<DiscusshuodongfengcaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusshuodongfengcaiEntity> wrapper);
   	

}

