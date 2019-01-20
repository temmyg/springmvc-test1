package com.hzit.handler;

import java.util.Map;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import com.hzit.entity.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.hzit.entity.User;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/spitter")
public class HelloHandler {
	
	 @RequestMapping("/hello")
	  public String hello(){
	      System.out.println("hello world");
	      return "index";
	  }
	
	/**
	 * post请求
	 * @return
	 */
	@RequestMapping(value="/postTest",method=RequestMethod.POST)
	public String postTest(){
		System.out.println("postTest");
		return "index";
	}
	
	/**
	 * get请求
	 * @return
	 */
	@RequestMapping(value="/getTest",method=RequestMethod.GET)
	public String getTest(){
		System.out.println("getTest");
		return "index";
	}
	
	/**
	 * 重定向
	 * @return
	 */
	@RequestMapping("redirectTest")
	public String redirectTest(){
		return "redirect:/index.jsp";
	}
	
	/**
	 * 转发
	 * @return
	 */
	@RequestMapping("forwardTest")
	public String forwardTest(){
		return "forward:/index.jsp";
	}
	
	/**
	 * 参数限制
	 * @return
	 */
	@RequestMapping(value="paramsTest",params={"name","id=10"})
	public String paramsTest(){
		System.out.println("paramsTest");
		return "index";
	}
	
	
	/**
	 * 参数绑定
	 * @return
	 */
	@RequestMapping(value="paramsBind")
	public String paramsBind(@RequestParam("name") String name,@RequestParam("id") int id){
		System.out.println(name);
		int num = id+10;
		System.out.println(num);
		return "index";
	}
	
	/**
	 * restful风格
	 * @return
	 */
	@RequestMapping(value="restful/{name}")
	@ResponseBody
	public User paramsBind(@PathVariable("name") String name){
		System.out.println(name);
		User user = new User();
		user.setName("Michy");
		Address addr = new Address();
		addr.setName(name = "1055 San Gabriel Av.");
		user.setAddress(addr);
		return user;
		//return "index";
	}
	
	/**
	 * 获取Cookie的值
	 * @return
	 */
	@RequestMapping("/cookieTest")
	public String getCookie(@CookieValue(value="JSESSIONID") String sessionId){
		System.out.println(sessionId);
		return "index";
	}
	
	@RequestMapping("/addUser")
	public String getPOJO(User user){
		System.out.println(user);
		return "index";
	}
}