package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.ShareNote;
import cn.tedu.cloud_note.util.NoteResult;

public interface CollectionNoteService {
	//�ղرʼ�
	NoteResult<Object> collectNote(String userId,String shareId);
	
	//�鿴�ղصıʼ��б�
	NoteResult<List<Map<String, String>>> searchCollection(String userId);
	
	//�鿴�ղرʼǵ�����
	NoteResult<ShareNote> loadCollectionNote(String collectionId);
	
	//ɾ���ղصıʼ�
	NoteResult<Object> deleteCollection(String collectionId);
}
