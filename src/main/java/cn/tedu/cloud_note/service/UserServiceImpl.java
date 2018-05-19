package cn.tedu.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;


@Service("UserService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;

	public NoteResult<User> checkLogin(String username, String password) {
		NoteResult<User> result=new NoteResult<User>();
		User user=userDao.findByName(username);
		
		if(user==null) {
			result.setStatus(1);
			result.setMsg("�û�������");
			return result;
		}
		
		String md5password=NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5password)) {
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		result.setStatus(0);
		result.setMsg("��¼�ɹ�");
		result.setData(user);
		return result;
	}
	
	//ע���û�
	public NoteResult<Object> addUser(String username,String password,String nick) {
		NoteResult<Object> result=new NoteResult<Object>();
		
		//�����û��������ݿ���ң����û����Ƿ��Ѿ�����
		User u=userDao.findByName(username);
		if(u!=null) {
			//1��ʾ�û����Ѿ�����
			result.setStatus(1);
			result.setMsg("�û����Ѿ�����");
			return result;
		}
		
		//����user
		User user=new User();
		user.setCn_user_name(username);
		user.setCn_user_nick(nick);
		user.setCn_user_id(NoteUtil.createId());
		user.setCn_user_password(NoteUtil.md5(password));
		userDao.save(user);
		result.setStatus(0);
		result.setMsg("ע��ɹ�");
		return result;
		
	}
	
	//�û��޸�����
	public NoteResult<Object> changePasaword(String userId, String lastPassword, String newPassword) {
		NoteResult<Object> result=new NoteResult<Object>();
		User user=new User();
		user=userDao.findByUserId(userId);
		String password=NoteUtil.md5(lastPassword);
		//�û�ԭ���������ݿ��е����벻ƥ��
		if(!password.equals(user.getCn_user_password())) {
			result.setStatus(1);
			result.setMsg("ԭ�����������������");
			return result;
		}else {
			//�޸��û�����
			user.setCn_user_password(NoteUtil.md5(newPassword));
			int rows=userDao.changePassword(user);
			if(rows==1) {
				result.setStatus(0);
				result.setMsg("�޸�����ɹ�");
				return result;
			}else {
				result.setStatus(2);
				result.setMsg("�޸������쳣");
				return result;
			}
		}
	}
}
