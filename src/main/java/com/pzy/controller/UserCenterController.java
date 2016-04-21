package com.pzy.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pzy.entity.User;
import com.pzy.service.LeaveService;
import com.pzy.service.PayService;
import com.pzy.service.TranService;
import com.pzy.service.UserService;
/***
 * 个人中心
 * @author panchaoyang
 *qq 263608237
 */
@Controller
@RequestMapping("/admin/usercenter")
public class UserCenterController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private LeaveService leaveService;
	
	@Autowired
	private TranService tranService;
	
	@Autowired
	private PayService payService;
	
	@RequestMapping("myleave") 
	public String index(Model model,HttpSession httpSession) {
		User user=(User)httpSession.getAttribute("adminuser");
		model.addAttribute("leaves",leaveService.findByUser(user));
		return "admin/usercenter/myleave";
	}
	
	@RequestMapping("mytran") 
	public String mytran(Model model,HttpSession httpSession) {
		User user=(User)httpSession.getAttribute("adminuser");
		model.addAttribute("trans",tranService.findAll());
		return "admin/usercenter/mytran";
	}
	
	@RequestMapping("mypay") 
	public String mypays(Model model,HttpSession httpSession) {
		User user=(User)httpSession.getAttribute("adminuser");
		user=userService.findUserName(user.getUsername());
		model.addAttribute("pays",payService.find(user));
		return "admin/usercenter/mypay";
	}
	
}
