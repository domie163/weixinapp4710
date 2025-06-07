package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShequEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShequVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShequView;


/**
 * 社区
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
public interface ShequService extends IService<ShequEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShequVO> selectListVO(Wrapper<ShequEntity> wrapper);
   	
   	ShequVO selectVO(@Param("ew") Wrapper<ShequEntity> wrapper);
   	
   	List<ShequView> selectListView(Wrapper<ShequEntity> wrapper);
   	
   	ShequView selectView(@Param("ew") Wrapper<ShequEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShequEntity> wrapper);
   	

}

