package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhiyuanzhehuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhiyuanzhehuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhiyuanzhehuodongView;


/**
 * 志愿者活动评论表
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface DiscusszhiyuanzhehuodongService extends IService<DiscusszhiyuanzhehuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhiyuanzhehuodongVO> selectListVO(Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
   	
   	DiscusszhiyuanzhehuodongVO selectVO(@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
   	
   	List<DiscusszhiyuanzhehuodongView> selectListView(Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
   	
   	DiscusszhiyuanzhehuodongView selectView(@Param("ew") Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper);
   	

}

