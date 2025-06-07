package com.entity.view;

import com.entity.HuodongfengcaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动风采
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
@TableName("huodongfengcai")
public class HuodongfengcaiView  extends HuodongfengcaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongfengcaiView(){
	}
 
 	public HuodongfengcaiView(HuodongfengcaiEntity huodongfengcaiEntity){
 	try {
			BeanUtils.copyProperties(this, huodongfengcaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
