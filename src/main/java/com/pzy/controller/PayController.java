package com.pzy.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pzy.entity.Pay;
import com.pzy.entity.User;
import com.pzy.service.PayService;
import com.pzy.service.UserService;
/***
 *工资情况
 * @author panchaoyang
 *qq 263608237
 */
@Controller
@RequestMapping("/admin/pay")
public class PayController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PayService payService;
	
	@RequestMapping("index")
	public String index(Model model) {
		return "admin/pay/index";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		
		model.addAttribute("users",userService.findAll());
		return "admin/pay/create";
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Model model,Pay pay) {
		User user=userService.findUserName(pay.getUser().getUsername());
		if(user==null){
			model.addAttribute("state","success");
			model.addAttribute("tip","保存失败，不存在此员工！");
		}
		pay.setUser(user);
		payService.save(pay);
		model.addAttribute("state","success");
		model.addAttribute("tip","添加成功！");
		return "admin/pay/create";
	}
	
	@InitBinder  
	protected void initBinder(HttpServletRequest request,   ServletRequestDataBinder binder) throws Exception {   
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true)); 
	}  
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(
			@RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "length", defaultValue = "10") int length, 
			String name,
			String xq
			) throws ParseException {
		int pageNumber = (int) (start / length) + 1;
		int pageSize = length;
		Page<Pay> pays = payService.findAll(pageNumber, pageSize, name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", pays.getContent());
		map.put("iTotalRecords", pays.getTotalElements());
		map.put("iTotalDisplayRecords", pays.getTotalElements());
		//map.put("echo", echo);
		return map;
	}
	
}
