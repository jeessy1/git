package cn.jie.session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.management.RuntimeErrorException;

import org.apache.catalina.util.Base64;
import org.apache.catalina.websocket.MessageInbound;

//���Ʒ�����
public class TokenProcessor {
	
	/**
	 * 1.�ѹ��췽��˽�л�
	 * 2.�Լ�����һ��
	 * 3.���Ⱪ¶һ�������������ȡ���洴���Ķ���
	 */
	
	private TokenProcessor(){
		
	}
	
	private static final TokenProcessor instance = new TokenProcessor();
	
	public static TokenProcessor getInstance(){

		return instance;
		
	}
	public String generateToken(){
		String token = System.currentTimeMillis() + new Random().nextInt()+"";
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5=	md.digest(token.getBytes());
			
			//base64����
			return Base64.encode(md5);
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
