package com.alu.lvzi.test.message;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Assert;
import org.junit.Test;

import com.alu.lvzi.message.MessageBox;

public class MessageBoxTest
{
	private static ResourceBundle MESSAGES = ResourceBundle.getBundle("message", Locale.CHINESE);
	
	@Test
	public void testLoginMessages() throws UnsupportedEncodingException
	{
		Assert.assertEquals(new String(MESSAGES.getString("100").getBytes("ISO-8859-1"), "UTF-8"), 
				MessageBox.Login_Success.getMessage());
		Assert.assertEquals(new String(MESSAGES.getString("101").getBytes("ISO-8859-1"), "UTF-8"),
				MessageBox.Login_ValidationCodeFailure.getMessage());
		Assert.assertEquals(new String(MESSAGES.getString("102").getBytes("ISO-8859-1"), "UTF-8"), 
				MessageBox.Login_NoUser.getMessage());
		Assert.assertEquals(new String(MESSAGES.getString("103").getBytes("ISO-8859-1"), "UTF-8"), 
				MessageBox.Login_WrongPassword.getMessage());
		Assert.assertEquals(new String(MESSAGES.getString("104").getBytes("ISO-8859-1"), "UTF-8"), 
				MessageBox.Login_LockedAccount.getMessage());
		Assert.assertEquals(new String(MESSAGES.getString("105").getBytes("ISO-8859-1"), "UTF-8"), 
				MessageBox.Login_WrongBoundedIpAddress.getMessage());
	}
}
