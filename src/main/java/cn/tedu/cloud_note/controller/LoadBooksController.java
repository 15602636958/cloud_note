package cn.tedu.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.NoteBook;
import cn.tedu.cloud_note.service.NoteBookService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")//ƥ������·��
//�����û�ID��ѯ�û������бʼǱ�������json��ǰ��
public class LoadBooksController {
	@Resource
	private NoteBookService noteBookService;
	
	@RequestMapping("/loadbooks.do")//ƥ������
	@ResponseBody//json���
	public NoteResult<List<NoteBook>> execute(String userId){
		
		NoteResult<List<NoteBook>> result=noteBookService.loadUserBook(userId);
		return result;
	}
}
