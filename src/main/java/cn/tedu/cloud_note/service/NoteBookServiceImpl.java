package cn.tedu.cloud_note.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.NoteBookDao;
import cn.tedu.cloud_note.entity.NoteBook;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("noteBookService")
public class NoteBookServiceImpl implements NoteBookService {

	@Resource
	private NoteBookDao noteBookDao;
	
	public NoteResult<List<NoteBook>> loadUserBook(String userId) {
		NoteResult<List<NoteBook>> result=new NoteResult<List<NoteBook>>();
		
		List<NoteBook> list=noteBookDao.findByUserId(userId);
		result.setStatus(0);
		result.setData(list);
		result.setMsg("��ѯ�ʼǱ��ɹ�");
		return result;
	}

	public NoteResult<NoteBook> addNoteBook(String name, String userId) {
		NoteResult<NoteBook> result=new NoteResult<NoteBook>();
		
		NoteBook noteBook=new NoteBook();
		noteBook.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		noteBook.setCn_notebook_id(NoteUtil.createId());
		noteBook.setCn_notebook_name(name);
		noteBook.setCn_user_id(userId);
		int rows=noteBookDao.add(noteBook);
		if(rows==1) {
			result.setStatus(1);
			result.setData(noteBook);
			result.setMsg("�����ʼǱ��ɹ�");
			return result;
		}else {
			result.setStatus(0);
			result.setMsg("�����ʼǱ��쳣");
			return result;
		}
	}

	public NoteResult<Object> renameNoteBook(String bookId, String bookName) {
		NoteResult<Object> result=new NoteResult<Object>();
		NoteBook noteBook=new NoteBook();
		noteBook.setCn_notebook_id(bookId);
		noteBook.setCn_notebook_name(bookName);
		int rows=noteBookDao.update(noteBook);
		if(rows==1) {
			result.setMsg("�޸ıʼǱ����ֳɹ�");
			result.setStatus(0);
			return result;
		}else {
			result.setMsg("�޸ıʼǱ������쳣");
			result.setStatus(1);
			return result;
		}
	}

	public NoteResult<Object> deleteNoteBook(String bookId) {
		NoteResult<Object> result=new NoteResult<Object>();
		int rows=noteBookDao.delete(bookId);
		if(rows==1) {
			result.setMsg("ɾ���ʼǱ��ɹ�");
			result.setStatus(0);
			return result;
		}else {
			result.setMsg("ɾ���ʼ��쳣");
			result.setStatus(1);
			return result;
		}
	}

}
