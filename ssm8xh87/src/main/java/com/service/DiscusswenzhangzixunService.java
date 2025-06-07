package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusswenzhangzixunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusswenzhangzixunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusswenzhangzixunView;


/**
 * 文章资讯评论表
 *
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
public interface DiscusswenzhangzixunService extends IService<DiscusswenzhangzixunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusswenzhangzixunVO> selectListVO(Wrapper<DiscusswenzhangzixunEntity> wrapper);
   	
   	DiscusswenzhangzixunVO selectVO(@Param("ew") Wrapper<DiscusswenzhangzixunEntity> wrapper);
   	
   	List<DiscusswenzhangzixunView> selectListView(Wrapper<DiscusswenzhangzixunEntity> wrapper);
   	
   	DiscusswenzhangzixunView selectView(@Param("ew") Wrapper<DiscusswenzhangzixunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusswenzhangzixunEntity> wrapper);
   	

}

