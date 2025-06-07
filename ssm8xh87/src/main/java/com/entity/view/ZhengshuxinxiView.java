package com.entity.view;

import com.entity.ZhengshuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 证书信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
@TableName("zhengshuxinxi")
public class ZhengshuxinxiView  extends ZhengshuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhengshuxinxiView(){
	}
 
 	public ZhengshuxinxiView(ZhengshuxinxiEntity zhengshuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zhengshuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
