package com.entity.vo;

import com.entity.ZhengshuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 证书信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
public class ZhengshuxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 社区名称
	 */
	
	private String shequmingcheng;
		
	/**
	 * 活动名称
	 */
	
	private String huodongmingcheng;
		
	/**
	 * 活动图片
	 */
	
	private String huodongtupian;
		
	/**
	 * 证书名称
	 */
	
	private String zhengshumingcheng;
		
	/**
	 * 证书文件
	 */
	
	private String zhengshuwenjian;
		
	/**
	 * 发放时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fafangshijian;
		
	/**
	 * 志愿者账号
	 */
	
	private String zhiyuanzhezhanghao;
		
	/**
	 * 志愿者姓名
	 */
	
	private String zhiyuanzhexingming;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：社区名称
	 */
	 
	public void setShequmingcheng(String shequmingcheng) {
		this.shequmingcheng = shequmingcheng;
	}
	
	/**
	 * 获取：社区名称
	 */
	public String getShequmingcheng() {
		return shequmingcheng;
	}
				
	
	/**
	 * 设置：活动名称
	 */
	 
	public void setHuodongmingcheng(String huodongmingcheng) {
		this.huodongmingcheng = huodongmingcheng;
	}
	
	/**
	 * 获取：活动名称
	 */
	public String getHuodongmingcheng() {
		return huodongmingcheng;
	}
				
	
	/**
	 * 设置：活动图片
	 */
	 
	public void setHuodongtupian(String huodongtupian) {
		this.huodongtupian = huodongtupian;
	}
	
	/**
	 * 获取：活动图片
	 */
	public String getHuodongtupian() {
		return huodongtupian;
	}
				
	
	/**
	 * 设置：证书名称
	 */
	 
	public void setZhengshumingcheng(String zhengshumingcheng) {
		this.zhengshumingcheng = zhengshumingcheng;
	}
	
	/**
	 * 获取：证书名称
	 */
	public String getZhengshumingcheng() {
		return zhengshumingcheng;
	}
				
	
	/**
	 * 设置：证书文件
	 */
	 
	public void setZhengshuwenjian(String zhengshuwenjian) {
		this.zhengshuwenjian = zhengshuwenjian;
	}
	
	/**
	 * 获取：证书文件
	 */
	public String getZhengshuwenjian() {
		return zhengshuwenjian;
	}
				
	
	/**
	 * 设置：发放时间
	 */
	 
	public void setFafangshijian(Date fafangshijian) {
		this.fafangshijian = fafangshijian;
	}
	
	/**
	 * 获取：发放时间
	 */
	public Date getFafangshijian() {
		return fafangshijian;
	}
				
	
	/**
	 * 设置：志愿者账号
	 */
	 
	public void setZhiyuanzhezhanghao(String zhiyuanzhezhanghao) {
		this.zhiyuanzhezhanghao = zhiyuanzhezhanghao;
	}
	
	/**
	 * 获取：志愿者账号
	 */
	public String getZhiyuanzhezhanghao() {
		return zhiyuanzhezhanghao;
	}
				
	
	/**
	 * 设置：志愿者姓名
	 */
	 
	public void setZhiyuanzhexingming(String zhiyuanzhexingming) {
		this.zhiyuanzhexingming = zhiyuanzhexingming;
	}
	
	/**
	 * 获取：志愿者姓名
	 */
	public String getZhiyuanzhexingming() {
		return zhiyuanzhexingming;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
