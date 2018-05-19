package cn.tedu.cloud_note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.CollectionNoteDao;
import cn.tedu.cloud_note.dao.ShareNoteDao;
import cn.tedu.cloud_note.entity.CollectionNote;
import cn.tedu.cloud_note.entity.ShareNote;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Service("collectionNoteService")
public class CollectionNoteServiceImpl implements CollectionNoteService {
	@Resource
	private CollectionNoteDao collectionNoteDao;
	@Resource
	private ShareNoteDao shareNoteDao;
	public NoteResult<Object> collectNote(String userId, String shareId) {
		NoteResult<Object> result=new NoteResult<Object>();
		CollectionNote collectionNote;
		//�Ȳ鿴�ղر����Ƿ����м�¼
		collectionNote=collectionNoteDao.findByShareId(shareId);
		if(collectionNote!=null) {
			result.setMsg("�ñʼ��Ѿ����ղ���");
			result.setStatus(2);
			return result;
		}else {//û�м�¼ʱ����ӱʼǵ��ղر���
			collectionNote=new CollectionNote();
			collectionNote.setCn_collection_id(NoteUtil.createId());
			collectionNote.setCn_collection_user_id(userId);
			collectionNote.setCn_collection_share_id(shareId);
			int rows=collectionNoteDao.addNote(collectionNote);
			if(rows==1) {
				result.setMsg("�ղسɹ�");
				result.setStatus(0);
				return result;
			}else {
				result.setMsg("�ղرʼ��쳣");
				result.setStatus(1);
				return result;
			}
		}
		
	}
	public NoteResult<List<Map<String, String>>> searchCollection(String userId) {
		
		NoteResult<List<Map<String, String>>> result=new NoteResult<List<Map<String,String>>>();
		List<Map<String, String>> list=collectionNoteDao.findByUserId(userId);
		result.setData(list);
		result.setMsg("�鿴�ղسɹ�");
		result.setStatus(0);
		return result;
	}
	public NoteResult<ShareNote> loadCollectionNote(String collectionId) {
		NoteResult<ShareNote> result=new NoteResult<ShareNote>();
		ShareNote shareNote=collectionNoteDao.findByCollectionId(collectionId);
		result.setData(shareNote);
		result.setMsg("�鿴�ʼǳɹ�");
		result.setStatus(0);
		return result;
	}
	public NoteResult<Object> deleteCollection(String collectionId) {
		NoteResult<Object> result=new NoteResult<Object>();
		int rows=collectionNoteDao.deleteByCollectionId(collectionId);
		if(rows==1) {
			result.setMsg("ɾ���ɹ�");
			result.setStatus(0);
			return result;
		}else {
			result.setMsg("ɾ���ʼ��쳣");
			result.setStatus(1);
			return result;
		}
	}

}
