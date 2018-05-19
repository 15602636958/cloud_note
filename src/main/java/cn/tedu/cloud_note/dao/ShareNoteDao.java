package cn.tedu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.tedu.cloud_note.entity.ShareNote;

public interface ShareNoteDao {
	
	//����ʼ�
	int shareNote(ShareNote shareNote);
	
	//���ݱʼ�id(cn_note_id)��ѯ����ʼǱ��еļ�¼
	ShareNote findByNoteId(String noteId);
	
	//���ݱʼ����ؼ��ֲ�ѯ����ʼǱ��еļ�¼
	List<ShareNote> findByKeyword(Map<String, Object> map);
	
	//���ݷ���ʼ�id��ѯ����ʼǵ�����
	ShareNote findByShareNoteId(String shareNoteId);
}
