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

import com.entity.HuodongfengcaiEntity;
import com.entity.view.HuodongfengcaiView;

import com.service.HuodongfengcaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 活动风采
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
@RestController
@RequestMapping("/huodongfengcai")
public class HuodongfengcaiController {
    @Autowired
    private HuodongfengcaiService huodongfengcaiService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuodongfengcaiEntity huodongfengcai, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequ")) {
			huodongfengcai.setShequzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuodongfengcaiEntity> ew = new EntityWrapper<HuodongfengcaiEntity>();


		PageUtils page = huodongfengcaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongfengcai), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuodongfengcaiEntity huodongfengcai, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("shequ")) {
			huodongfengcai.setShequzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuodongfengcaiEntity> ew = new EntityWrapper<HuodongfengcaiEntity>();

		PageUtils page = huodongfengcaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huodongfengcai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuodongfengcaiEntity huodongfengcai){
       	EntityWrapper<HuodongfengcaiEntity> ew = new EntityWrapper<HuodongfengcaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huodongfengcai, "huodongfengcai")); 
        return R.ok().put("data", huodongfengcaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuodongfengcaiEntity huodongfengcai){
        EntityWrapper< HuodongfengcaiEntity> ew = new EntityWrapper< HuodongfengcaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huodongfengcai, "huodongfengcai")); 
		HuodongfengcaiView huodongfengcaiView =  huodongfengcaiService.selectView(ew);
		return R.ok("查询活动风采成功").put("data", huodongfengcaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuodongfengcaiEntity huodongfengcai = huodongfengcaiService.selectById(id);
        return R.ok().put("data", huodongfengcai);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuodongfengcaiEntity huodongfengcai = huodongfengcaiService.selectById(id);
        return R.ok().put("data", huodongfengcai);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        HuodongfengcaiEntity huodongfengcai = huodongfengcaiService.selectById(id);
        if(type.equals("1")) {
        	huodongfengcai.setThumbsupnum(huodongfengcai.getThumbsupnum()+1);
        } else {
        	huodongfengcai.setCrazilynum(huodongfengcai.getCrazilynum()+1);
        }
        huodongfengcaiService.updateById(huodongfengcai);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuodongfengcaiEntity huodongfengcai, HttpServletRequest request){
    	huodongfengcai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongfengcai);

        huodongfengcaiService.insert(huodongfengcai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuodongfengcaiEntity huodongfengcai, HttpServletRequest request){
    	huodongfengcai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huodongfengcai);
    	huodongfengcai.setUserid((Long)request.getSession().getAttribute("userId"));

        huodongfengcaiService.insert(huodongfengcai);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuodongfengcaiEntity huodongfengcai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huodongfengcai);
        huodongfengcaiService.updateById(huodongfengcai);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huodongfengcaiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<HuodongfengcaiEntity> wrapper = new EntityWrapper<HuodongfengcaiEntity>();
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

		int count = huodongfengcaiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
