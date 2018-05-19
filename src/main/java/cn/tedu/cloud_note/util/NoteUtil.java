package cn.tedu.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class NoteUtil {
	
	//UUID��ȡid
	public static String createId() {
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString();
		//�����ɵ�UUID�ַ����е�-ȥ��
		return id.replace("-", "");
	}
	
	//md5����
	public static String md5(String str) {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] input = str.getBytes();
			byte[] output = md.digest(input);

			// ����base64�㷨���ֽ�����ת��Ϊ�ַ���
			String ret = Base64.encode(output);
			return ret;
		} catch (Exception e) {
			throw new NoteException("����ʧ��", e);
		}
	}

	public static void main(String[] args) {
		System.out.println(md5("123"));
	}
}
