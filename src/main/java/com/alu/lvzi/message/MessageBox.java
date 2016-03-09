package com.alu.lvzi.message;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * ������ʾ������Ŀ������Ϣ���࣬ͨ����̨���������Զ�̬�޸���ʾ��Ϣ
 * 
 * @author jundonch
 * @since 2106-1-22
 *
 */
public enum MessageBox
{
	// ��̨��½�����Ϣ
	Login_Success(100),
	Login_ValidationCodeFailure(101),
	Login_NoUser(102),
	Login_WrongPassword(103),
	Login_LockedAccount(104),
	Login_WrongBoundedIpAddress(105);
	
	private static ResourceBundle MESSAGES;
	
	static
	{
		loadMessages();
	}
	
	public static void loadMessages()
	{
		MESSAGES = ResourceBundle.getBundle("message", Locale.CHINESE);
	}
	
	private final int code;
	private MessageBox(int code)
	{
		this.code = code;
	}

	public int getCode()
	{
		return code;
	}
	
	public String getMessage()
	{
		String result = "δ����Ĵ�����Ϣ";
		try
		{
			result = new String(MESSAGES.getString(String.valueOf(code)).getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			
		}
		return result ;
	}
	
}
