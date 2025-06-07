package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZhengshuxinxiEntity;
import com.entity.view.ZhengshuxinxiView;

import com.service.ZhengshuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 证书信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
@RestController
@RequestMapping("/zhengshuxinxi")
public class ZhengshuxinxiController {
    @Autowired
    private ZhengshuxinxiService zhengshuxinxiService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhengshuxinxiEntity zhengshuxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequ")) {
			zhengshuxinxi.setShequzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhiyuanzhe")) {
			zhengshuxinxi.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhengshuxinxiEntity> ew = new EntityWrapper<ZhengshuxinxiEntity>();


		PageUtils page = zhengshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengshuxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhengshuxinxiEntity zhengshuxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequ")) {
			zhengshuxinxi.setShequzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhiyuanzhe")) {
			zhengshuxinxi.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhengshuxinxiEntity> ew = new EntityWrapper<ZhengshuxinxiEntity>();

		PageUtils page = zhengshuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhengshuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhengshuxinxiEntity zhengshuxinxi){
       	EntityWrapper<ZhengshuxinxiEntity> ew = new EntityWrapper<ZhengshuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhengshuxinxi, "zhengshuxinxi")); 
        return R.ok().put("data", zhengshuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhengshuxinxiEntity zhengshuxinxi){
        EntityWrapper< ZhengshuxinxiEntity> ew = new EntityWrapper< ZhengshuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhengshuxinxi, "zhengshuxinxi")); 
		ZhengshuxinxiView zhengshuxinxiView =  zhengshuxinxiService.selectView(ew);
		return R.ok("查询证书信息成功").put("data", zhengshuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhengshuxinxiEntity zhengshuxinxi = zhengshuxinxiService.selectById(id);
        return R.ok().put("data", zhengshuxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhengshuxinxiEntity zhengshuxinxi = zhengshuxinxiService.selectById(id);
        return R.ok().put("data", zhengshuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhengshuxinxiEntity zhengshuxinxi, HttpServletRequest request){
    	zhengshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhengshuxinxi);

        zhengshuxinxiService.insert(zhengshuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhengshuxinxiEntity zhengshuxinxi, HttpServletRequest request){
    	zhengshuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhengshuxinxi);
    	zhengshuxinxi.setUserid((Long)request.getSession().getAttribute("userId"));

        zhengshuxinxiService.insert(zhengshuxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhengshuxinxiEntity zhengshuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhengshuxinxi);
        zhengshuxinxiService.updateById(zhengshuxinxi);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhengshuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZhengshuxinxiEntity> wrapper = new EntityWrapper<ZhengshuxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequ")) {
			wrapper.eq("shequzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhiyuanzhe")) {
			wrapper.eq("zhiyuanzhezhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zhengshuxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
