package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.HuodongfengcaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.HuodongfengcaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.HuodongfengcaiView;


/**
 * 活动风采
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface HuodongfengcaiService extends IService<HuodongfengcaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<HuodongfengcaiVO> selectListVO(Wrapper<HuodongfengcaiEntity> wrapper);
   	
   	HuodongfengcaiVO selectVO(@Param("ew") Wrapper<HuodongfengcaiEntity> wrapper);
   	
   	List<HuodongfengcaiView> selectListView(Wrapper<HuodongfengcaiEntity> wrapper);
   	
   	HuodongfengcaiView selectView(@Param("ew") Wrapper<HuodongfengcaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<HuodongfengcaiEntity> wrapper);
   	

}

