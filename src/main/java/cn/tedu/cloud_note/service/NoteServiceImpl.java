package cn.tedu.cloud_note.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	
	@Resource
	private NoteDao noteDao;
	//���ݱʼǱ�id��ѯ�ʼ�
	public NoteResult<List<Map<String, String>>> loadNote(String bookId) {
		NoteResult<List<Map<String, String>>> result=new NoteResult<List<Map<String,String>>>();
		
		List<Map<String, String>> list=noteDao.findByBookId(bookId);
		result.setData(list);
		result.setStatus(0);
		result.setMsg("��ѯ�ʼǳɹ�");
		return result;
	}
	
	//���ݱʼ�id��ѯ�ʼǵ��������
	public NoteResult<Note> load(String noteId) {
		NoteResult<Note> result=new NoteResult<Note>();
		Note note=noteDao.findByNoteId(noteId);
		result.setData(note);
		result.setMsg("��ѯ�ʼ����ݳɹ�");
		result.setStatus(0);
		return result;
	}

	public NoteResult<Object> updateNote(String noteId, String title, String body) {
		NoteResult<Object> result=new NoteResult<Object>();
		
		Note note=new Note();
		note.setCn_note_body(body);
		note.setCn_note_last_modify_time(new Date().getTime());
		note.setCn_note_title(title);
		note.setCn_note_id(noteId);
		int status=noteDao.updateNote(note);
		result.setStatus(status);
		if(status==1) {
			result.setMsg("����ʼǳɹ�");
			return result;
		}else {
			result.setMsg("����ʼ�ʧ��");
			return result;
		}
		
	}

	public NoteResult<String> addNote(String userId, String bookId, String noteTitle) {
		NoteResult<String> result=new NoteResult<String>();
		
		Note note=new Note();
		long time=System.currentTimeMillis();
		note.setCn_note_create_time(time);
		String noteId=NoteUtil.createId();
		note.setCn_note_status_id("1");
		note.setCn_note_id(noteId);
		note.setCn_note_last_modify_time(time);
		note.setCn_note_title(noteTitle);
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(userId);
		
		int rows=noteDao.addNote(note);
		if(rows==1) {
			result.setData(noteId);
			result.setMsg("�����ʼǳɹ�");
			result.setStatus(1);
			return result;
		}
		else {
			result.setMsg("�����ʼ��쳣");
			result.setStatus(0);
			return result;
		}
	}

	public NoteResult<Object> removeNote(String noteId) {
		NoteResult<Object> result=new NoteResult<Object>();
		int rows=noteDao.deleteByNoteId(noteId);
		if(rows==1) {
			result.setStatus(0);
			result.setMsg("ɾ���ɹ�");
			return result;
		}else {
			result.setStatus(1);
			result.setMsg("ɾ���ʼ��쳣");
			return result;
		}
	}

	public NoteResult<List<Map<String, String>>> searchDelete(String userId) {
		NoteResult<List<Map<String, String>>> result=new NoteResult<List<Map<String,String>>>();
		List<Map<String, String>> list=noteDao.findByUserId(userId);
		
		result.setData(list);
		result.setMsg("��ѯ�ɹ�");
		result.setStatus(0);
		return result;
	}

	public NoteResult<Object> deleteNote(String noteId) {
		NoteResult<Object> result=new NoteResult<Object>();
		int rows=noteDao.deleteForever(noteId);
		if(rows==1) {
			result.setMsg("ɾ���ʼǳɹ�");
			result.setStatus(0);
			return result;
		}else {
			result.setMsg("ɾ���ʼ��쳣");
			result.setStatus(1);
			return result;
		}
	}

	public NoteResult<Object> moveNote(String noteId, String bookId) {
		NoteResult<Object> result=new NoteResult<Object>();
		
		Note note=new Note();
		long time=System.currentTimeMillis();
		note.setCn_note_last_modify_time(time);
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		
		int rows=noteDao.moveNote(note);
		if(rows==1) {
			result.setMsg("�Ƴ��ʼǳɹ�");
			result.setStatus(0);
			return result;
		}else {
			result.setMsg("�Ƴ��ʼ��쳣");
			result.setStatus(1);
			return result;
		}
	}

	public NoteResult<Object> rollbackNote(String noteId, String bookId) {
		NoteResult<Object> result=new NoteResult<Object>();
		
		Note note=new Note();
		note.setCn_note_id(noteId);
		long time=System.currentTimeMillis();
		note.setCn_note_last_modify_time(time);
		note.setCn_notebook_id(bookId);
		
		int rows=noteDao.rollbackNote(note);
		if(rows==1) {
			result.setMsg("��ԭ�ʼǳɹ�");
			result.setStatus(0);
			return result;
		}else {
			result.setMsg("��ԭ�ʼ��쳣");
			result.setStatus(1);
			return result;
		}
	}

}
