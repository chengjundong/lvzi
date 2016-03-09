package com.alu.lvzi.user;

import org.springframework.util.DigestUtils;

import com.alu.lvzi.pojo.Admin;

/**
 * 用户登录信息
 * 
 * @author jundonch
 * @since 2016-1-22
 *
 */
public class LoginInfor
{
	private String inputUserName;
	private String inputPassword;
	private String inputIpAddress;
	private Admin admin;
	private String message;
	
	public LoginInfor()
	{
		
	}

	public String getInputUserName()
	{
		return inputUserName;
	}
	
	public LoginInfor inputUserName(String username)
	{
		this.inputUserName = username;
		return this;
	}
	
	public String getInputPassword()
	{
		return inputPassword;
	}
	
	public LoginInfor inputPassword(String password)
	{
		this.inputPassword = password;
		return this;
	}

	public String getInputIpAddress()
	{
		return inputIpAddress;
	}
	
	public LoginInfor inputIpAddress(String ipAddress)
	{
		this.inputIpAddress = ipAddress;
		return this;
	}

	public Admin getAdmin()
	{
		return admin;
	}

	public void setAdmin(Admin admin)
	{
		this.admin = admin;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
	
	/**
	 * 获取MD5加密后的password
	 * 
	 * @return String
	 */
	public String getMD5Password()
	{
		return null == inputPassword ? "" : DigestUtils.md5DigestAsHex(inputPassword.getBytes());
	}
}
