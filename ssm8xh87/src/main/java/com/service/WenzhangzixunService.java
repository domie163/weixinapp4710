package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenzhangzixunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WenzhangzixunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WenzhangzixunView;


/**
 * 文章资讯
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface WenzhangzixunService extends IService<WenzhangzixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenzhangzixunVO> selectListVO(Wrapper<WenzhangzixunEntity> wrapper);
   	
   	WenzhangzixunVO selectVO(@Param("ew") Wrapper<WenzhangzixunEntity> wrapper);
   	
   	List<WenzhangzixunView> selectListView(Wrapper<WenzhangzixunEntity> wrapper);
   	
   	WenzhangzixunView selectView(@Param("ew") Wrapper<WenzhangzixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenzhangzixunEntity> wrapper);
   	

}

