package com.entity.view;

import com.entity.HuodongqiandaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 活动签到
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
@TableName("huodongqiandao")
public class HuodongqiandaoView  extends HuodongqiandaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public HuodongqiandaoView(){
	}
 
 	public HuodongqiandaoView(HuodongqiandaoEntity huodongqiandaoEntity){
 	try {
			BeanUtils.copyProperties(this, huodongqiandaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
