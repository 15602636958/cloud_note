package cn.tedu.cloud_note.service;

import java.util.List;

import cn.tedu.cloud_note.entity.ShareNote;
import cn.tedu.cloud_note.util.NoteResult;

public interface ShareNoteService {
	//����ʼ�
	NoteResult<Object> share(String noteId);
	
	//���ݱʼ����ؼ��ֲ�ѯ����ʼǱ��еļ�¼
	NoteResult<List<ShareNote>> findByKeyword(String keyword,int page);
	
	//���ݷ���ʼ�id��ѯ����ʼǵ�����
	NoteResult<ShareNote> findByShareNoteId(String shareNoteId);
}
