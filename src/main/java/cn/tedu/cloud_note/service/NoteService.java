package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;

public interface NoteService {
	
	//���ݱʼǱ�id��ѯ�ʼ�
	NoteResult<List<Map<String, String>>> loadNote(String bookId);
	
	//���ݱʼ�id��ѯ�ʼǵ��������
	NoteResult<Note> load(String noteId);
	
	
	//���±ʼ�����
	NoteResult<Object> updateNote(String noteId,String title,String body);
	
	//��ӱʼ�
	NoteResult<String> addNote(String userId,String bookId,String noteTitle);
	
	//ɾ���ʼ�(���ʼǱ��Ž�����վ)
	NoteResult<Object> removeNote(String noteId);
	
	//�����û�id��ѯ����վ�ıʼ� 
	NoteResult<List<Map<String, String>>> searchDelete(String userId);
	
	//����ɾ���ʼ�
	NoteResult<Object> deleteNote(String noteId);
	
	//���ʼ��ƶ�����һ���ʼǱ���
	NoteResult<Object> moveNote(String noteId,String bookId);
	
	//������վ�еıʼǸ�ԭ
	NoteResult<Object> rollbackNote(String noteId,String bookId);
}
