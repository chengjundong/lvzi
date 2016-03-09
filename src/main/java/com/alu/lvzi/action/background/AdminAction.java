package com.alu.lvzi.action.background;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.alu.lvzi.pojo.Admin;
import com.alu.lvzi.pojo.Privilege;
import com.alu.lvzi.service.AdminService;
import com.alu.lvzi.service.PrivilegeService;
import com.alu.lvzi.user.LoginInfor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 关于所有用户操作的Action
 * 
 * @author jundonch
 *
 */
public class AdminAction extends ActionSupport
{
	private static final long serialVersionUID = 7984673256529793613L;
	
	public static final String IP_LOCK = "lock";
	public static final String IP_UNLOCK = "unlock";
	public static final String IP_LOCK_SUCCESS = "lock success";
	public static final String IP_UNLOCK_SUCCESS = "unlock success";
	
	// 登陆登出用
	private AdminService adminService;
	private String username;
	private String password;
	private String vcode;
	private String result;
	
	// 绑定IP用
	private String operation;
	
	// 权限菜单控制用
	private PrivilegeService privilegeService;
	private List<Privilege> privileges;

	public AdminService getAdminService()
	{
		return adminService;
	}

	public void setAdminService(AdminService adminService)
	{
		this.adminService = adminService;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getVcode()
	{
		return vcode;
	}

	public void setVcode(String vcode)
	{
		this.vcode = vcode;
	}

	public String getResult()
	{
		return result;
	}

	public void setResult(String result)
	{
		this.result = result;
	}
	
	public String getOperation()
	{
		return operation;
	}

	public void setOperation(String operation)
	{
		this.operation = operation;
	}
	
	public PrivilegeService getPrivilegeService()
	{
		return privilegeService;
	}

	public void setPrivilegeService(PrivilegeService privilegeService)
	{
		this.privilegeService = privilegeService;
	}

	public List<Privilege> getPrivileges()
	{
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges)
	{
		this.privileges = privileges;
	}

	/**
	 * 用户登录
	 * 
	 * @return String
	 */
	public String login()
	{
		// 检验验证码
		String vcodeInSession = (String) ActionContext.getContext().getSession().get("adminVcode");
		if (null == vcodeInSession)
		{
			result = "页面过期";
		} else if (!vcodeInSession.equalsIgnoreCase(vcode))
		{
			result = "验证码错误";
		} else
		{
			// 检验用户名和密码
			LoginInfor loginInfor = new LoginInfor()
					.inputUserName(username)
					.inputPassword(password)
					.inputIpAddress(ServletActionContext.getRequest().getRemoteAddr());
			loginInfor = adminService.login(loginInfor);
			result = loginInfor.getMessage();

			// 成功后将用户放入Session
			if (null != loginInfor.getAdmin())
			{
				ActionContext.getContext().getSession().put("user", loginInfor.getAdmin());
			}
		}

		return SUCCESS;
	}
	
	/**
	 * 用户登出
	 * 
	 * @return String
	 */
	public String logout()
	{
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
	
	/**
	 * 绑定/解绑用户IP
	 * 
	 * @return String
	 */
	public String lockIP()
	{
		Admin admin =  getLoginAdmin();
		if(IP_LOCK.equals(operation))
		{
			admin.setBoundedIP(ServletActionContext.getRequest().getRemoteAddr());
			adminService.update(admin);
			result = IP_LOCK_SUCCESS;
		}
		else if (IP_UNLOCK.equals(operation))
		{
			admin.setBoundedIP(null);
			adminService.update(admin);
			result = IP_UNLOCK_SUCCESS;
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询当前用户权限
	 * 
	 * @return String
	 */
	public String findPrivileges()
	{
		Admin admin =  getLoginAdmin();
		privileges = privilegeService.findPrivileges(admin);

		return SUCCESS;
	}
	
	private Admin getLoginAdmin()
	{
		Object object = ActionContext.getContext().getSession().get("user");
		if (object instanceof Admin)
		{
			return (Admin) object;
		}
		return null;
	}
}
