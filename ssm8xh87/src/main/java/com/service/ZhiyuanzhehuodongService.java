package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhiyuanzhehuodongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhiyuanzhehuodongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiyuanzhehuodongView;


/**
 * 志愿者活动
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
public interface ZhiyuanzhehuodongService extends IService<ZhiyuanzhehuodongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhiyuanzhehuodongVO> selectListVO(Wrapper<ZhiyuanzhehuodongEntity> wrapper);
   	
   	ZhiyuanzhehuodongVO selectVO(@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);
   	
   	List<ZhiyuanzhehuodongView> selectListView(Wrapper<ZhiyuanzhehuodongEntity> wrapper);
   	
   	ZhiyuanzhehuodongView selectView(@Param("ew") Wrapper<ZhiyuanzhehuodongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhiyuanzhehuodongEntity> wrapper);
   	

}

