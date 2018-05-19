package cn.tedu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.Note;

public interface NoteDao {
	//���ݱʼǱ�id��ѯ��صıʼ�
	List<Map<String,String>> findByBookId(String bookId);
	
	//���ݱʼ�id��ѯ�ʼǵ��������
	Note findByNoteId(String noteId);
	
	//���±ʼ�����,��������ΪintΪupdate�ı������
	int updateNote(Note note);
	
	//�����ʼ�
	int addNote(Note note);
	
	//ɾ���ʼ�(���ʼǷŽ�����վ)
	int deleteByNoteId(String noteId);
	
	//�����û�id��ѯ����վ�ıʼ�
	List<Map<String,String>> findByUserId(String userId);
	
	//����ɾ���ʼ�
	int deleteForever(String noteId);
	
	//���ʼ��ƶ�����һ���ʼǱ���
	int moveNote(Note note);
	
	//������վ�еıʼǸ�ԭ
	int rollbackNote(Note note);
	
}
