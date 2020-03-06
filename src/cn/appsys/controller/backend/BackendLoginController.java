package cn.appsys.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.service.backend.BackendService;

@Controller
@RequestMapping("/manager")
public class BackendLoginController {
	
	//注入BackendService对象
	@Resource
	private BackendService backendService;
	
	//跳转至后台登录页面
	@RequestMapping("/login")
	public String login() {
		return "backendlogin";
	}
	
	@RequestMapping("/dologin")
	public String doLogin(@RequestParam("userCode")String userCode,
			@RequestParam("userPassword")String userPassword,
			HttpSession session,HttpServletRequest request){
		//调用业务层方法获取后台用户
		BackendUser user= backendService.login(userCode);
		//判断
		if(user.getUserPassword().equals(userPassword)){
			//登陆成功session保存
			session.setAttribute("userSession", user);
			return "/backend/main";
		}else{
			//登录失败加提示
			request.setAttribute("error", "用户名或密码错误");
			return "backendlogin";
		}
	}
}
