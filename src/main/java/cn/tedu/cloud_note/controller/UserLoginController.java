package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user") //ƥ������·��
//�û���¼
public class UserLoginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login.do") //ƥ������
	@ResponseBody  //json���
	public NoteResult<User> execute(String username,String password){
		NoteResult<User> result=userService.checkLogin(username, password);
		return result;
	}
}
