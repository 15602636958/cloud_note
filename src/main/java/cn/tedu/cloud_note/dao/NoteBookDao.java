package cn.tedu.cloud_note.dao;

import java.util.List;

import cn.tedu.cloud_note.entity.NoteBook;

public interface NoteBookDao {
	
	//�����û�id�����û������бʼǱ�
	List<NoteBook> findByUserId(String userId);
	
	//��ӱʼǱ�
	int add(NoteBook noteBook);
	
	//�޸ıʼǱ�����
	int update(NoteBook noteBook);
	
	//���ݱʼǱ�idɾ���ʼǱ�
	int delete(String bookId);
}
