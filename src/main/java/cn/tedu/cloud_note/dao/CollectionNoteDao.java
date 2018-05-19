package cn.tedu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.CollectionNote;
import cn.tedu.cloud_note.entity.ShareNote;

public interface CollectionNoteDao {
	//�ղرʼ�(��ӱʼ�)
	int addNote(CollectionNote collectionNote);
	
	//���ݷ���ʼ�id�����ղر��еļ�¼
	CollectionNote findByShareId(String shareId);
	
	//�����û�id�����û����ղرʼ�
	List<Map<String, String>> findByUserId(String userId);
	
	//�鿴�ղرʼǵ�����
	ShareNote findByCollectionId(String collectionId);
	
	//����collectionidɾ���ղصıʼ�
	int deleteByCollectionId(String collectionId);
}
