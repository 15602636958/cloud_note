package cn.tedu.cloud_note.dao;

import cn.tedu.cloud_note.entity.User;

public interface UserDao {
	//�����û�id�����û�
	User findByUserId(String userId);
	
	//�����û��������û�
	 User findByName(String name);
	 
	 //����û�
	 void save(User user);
	 
	 //�޸�����
	 int changePassword(User user);
}
