package cn.tedu.cloud_note.service;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;

public interface UserService {
	//�û���¼
	 NoteResult<User> checkLogin(String username,String password);
	
	//�û�ע��
	 NoteResult<Object> addUser(String username,String password,String nick);
	 
	 //�޸�����
	 NoteResult<Object> changePasaword(String userId,String lastPassword,String newPassword);
	
}
