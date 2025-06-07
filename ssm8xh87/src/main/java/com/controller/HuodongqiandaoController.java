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

import com.entity.HuodongqiandaoEntity;
import com.entity.view.HuodongqiandaoView;

import com.service.HuodongqiandaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 活动签到
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:37:57
 */
@RestController
@RequestMapping("/huodongqiandao")
public class HuodongqiandaoController {
    @Autowired
    private HuodongqiandaoService huodongqiandaoService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongqiandaoEntity huodongqiandao, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequ")) {
			huodongqiandao.setShequzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhiyuanzhe")) {
			huodongqiandao.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuodongqiandaoEntity> ew = new EntityWrapper<HuodongqiandaoEntity>();


		PageUtils page = huodongqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongqiandao), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongqiandaoEntity huodongqiandao, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequ")) {
			huodongqiandao.setShequzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("zhiyuanzhe")) {
			huodongqiandao.setZhiyuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuodongqiandaoEntity> ew = new EntityWrapper<HuodongqiandaoEntity>();

		PageUtils page = huodongqiandaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongqiandao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongqiandaoEntity huodongqiandao){
       	EntityWrapper<HuodongqiandaoEntity> ew = new EntityWrapper<HuodongqiandaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongqiandao, "huodongqiandao")); 
        return R.ok().put("data", huodongqiandaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongqiandaoEntity huodongqiandao){
        EntityWrapper< HuodongqiandaoEntity> ew = new EntityWrapper< HuodongqiandaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongqiandao, "huodongqiandao")); 
		HuodongqiandaoView huodongqiandaoView =  huodongqiandaoService.selectView(ew);
		return R.ok("查询活动签到成功").put("data", huodongqiandaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongqiandaoEntity huodongqiandao = huodongqiandaoService.selectById(id);
        return R.ok().put("data", huodongqiandao);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongqiandaoEntity huodongqiandao = huodongqiandaoService.selectById(id);
        return R.ok().put("data", huodongqiandao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongqiandaoEntity huodongqiandao, HttpServletRequest request){
    	huodongqiandao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongqiandao);

        huodongqiandaoService.insert(huodongqiandao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongqiandaoEntity huodongqiandao, HttpServletRequest request){
    	huodongqiandao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongqiandao);
    	huodongqiandao.setUserid((Long)request.getSession().getAttribute("userId"));

        huodongqiandaoService.insert(huodongqiandao);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongqiandaoEntity huodongqiandao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongqiandao);
        huodongqiandaoService.updateById(huodongqiandao);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongqiandaoService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HuodongqiandaoEntity> wrapper = new EntityWrapper<HuodongqiandaoEntity>();
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

		int count = huodongqiandaoService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
