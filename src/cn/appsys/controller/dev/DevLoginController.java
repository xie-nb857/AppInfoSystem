package cn.appsys.controller.dev;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.backend.DevService;


@Controller
@RequestMapping("/dev")
public class DevLoginController {

	//注入devService对象
		@Resource
	    private DevService devService;
		
		//跳转至后台登录页面
		@RequestMapping("/login")
		public String login() {
			return "devlogin";
		}
		
		
		@RequestMapping("/dologin")
		public String doLogin(@RequestParam("devCode")String devCode,
				@RequestParam("devPassword")String devPassword,
				HttpSession session,HttpServletRequest request){
			//调用业务层方法获取后台用户
			DevUser devuser= devService.dev(devCode);
			//判断
			if(devuser.getDevPassword().equals(devPassword)){
				//登陆成功session保存
				session.setAttribute("userSession", devuser);
				return "/backend/main";
			}else{
				//登录失败加提示
				request.setAttribute("error", "用户名或密码错误");
				return "devlogin";
			}
		}
}
