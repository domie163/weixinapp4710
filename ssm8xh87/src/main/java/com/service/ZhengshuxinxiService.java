package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhengshuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhengshuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhengshuxinxiView;


/**
 * 证书信息
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
public interface ZhengshuxinxiService extends IService<ZhengshuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhengshuxinxiVO> selectListVO(Wrapper<ZhengshuxinxiEntity> wrapper);
   	
   	ZhengshuxinxiVO selectVO(@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);
   	
   	List<ZhengshuxinxiView> selectListView(Wrapper<ZhengshuxinxiEntity> wrapper);
   	
   	ZhengshuxinxiView selectView(@Param("ew") Wrapper<ZhengshuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhengshuxinxiEntity> wrapper);
   	

}

