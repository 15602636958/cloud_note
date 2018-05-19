package cn.tedu.cloud_note.service;

import java.util.List;

import cn.tedu.cloud_note.entity.NoteBook;
import cn.tedu.cloud_note.util.NoteResult;

public interface NoteBookService {
	//�����û���userId��ѯ�����û������бʼǱ�
	NoteResult<List<NoteBook>> loadUserBook(String userId);
	
	//��ӱʼǱ�
	NoteResult<NoteBook> addNoteBook(String name,String userId);
	
	//�޸ıʼǱ�����
	NoteResult<Object> renameNoteBook(String bookId,String bookName);
	
	//ɾ���ʼǱ�
	NoteResult<Object> deleteNoteBook(String bookId);
}
