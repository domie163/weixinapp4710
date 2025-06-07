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

import com.entity.DiscusszhiyuanzhehuodongEntity;
import com.entity.view.DiscusszhiyuanzhehuodongView;

import com.service.DiscusszhiyuanzhehuodongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 志愿者活动评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-17 17:37:58
 */
@RestController
@RequestMapping("/discusszhiyuanzhehuodong")
public class DiscusszhiyuanzhehuodongController {
    @Autowired
    private DiscusszhiyuanzhehuodongService discusszhiyuanzhehuodongService;




    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodong, 
		HttpServletRequest request){

        EntityWrapper<DiscusszhiyuanzhehuodongEntity> ew = new EntityWrapper<DiscusszhiyuanzhehuodongEntity>();


		PageUtils page = discusszhiyuanzhehuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhiyuanzhehuodong), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodong, 
		HttpServletRequest request){
        EntityWrapper<DiscusszhiyuanzhehuodongEntity> ew = new EntityWrapper<DiscusszhiyuanzhehuodongEntity>();

		PageUtils page = discusszhiyuanzhehuodongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusszhiyuanzhehuodong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodong){
       	EntityWrapper<DiscusszhiyuanzhehuodongEntity> ew = new EntityWrapper<DiscusszhiyuanzhehuodongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusszhiyuanzhehuodong, "discusszhiyuanzhehuodong")); 
        return R.ok().put("data", discusszhiyuanzhehuodongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodong){
        EntityWrapper< DiscusszhiyuanzhehuodongEntity> ew = new EntityWrapper< DiscusszhiyuanzhehuodongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusszhiyuanzhehuodong, "discusszhiyuanzhehuodong")); 
		DiscusszhiyuanzhehuodongView discusszhiyuanzhehuodongView =  discusszhiyuanzhehuodongService.selectView(ew);
		return R.ok("查询志愿者活动评论表成功").put("data", discusszhiyuanzhehuodongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodong = discusszhiyuanzhehuodongService.selectById(id);
        return R.ok().put("data", discusszhiyuanzhehuodong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodong = discusszhiyuanzhehuodongService.selectById(id);
        return R.ok().put("data", discusszhiyuanzhehuodong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodong, HttpServletRequest request){
    	discusszhiyuanzhehuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhiyuanzhehuodong);

        discusszhiyuanzhehuodongService.insert(discusszhiyuanzhehuodong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodong, HttpServletRequest request){
    	discusszhiyuanzhehuodong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discusszhiyuanzhehuodong);

        discusszhiyuanzhehuodongService.insert(discusszhiyuanzhehuodong);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscusszhiyuanzhehuodongEntity discusszhiyuanzhehuodong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusszhiyuanzhehuodong);
        discusszhiyuanzhehuodongService.updateById(discusszhiyuanzhehuodong);//全部更新
        return R.ok();
    }
    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusszhiyuanzhehuodongService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DiscusszhiyuanzhehuodongEntity> wrapper = new EntityWrapper<DiscusszhiyuanzhehuodongEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discusszhiyuanzhehuodongService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
