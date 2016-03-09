package com.alu.lvzi.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin implements Serializable
{
	private static final long serialVersionUID = -3304187799165469790L;
	
	private Integer id;
	private String name;
	private String password;
	private String nickName;
	private String email;
	private Timestamp lastLoginTime;
	private String lastLoginIP;
	private Integer loginCount;
	private Boolean locked;
	private String boundedIP;
	private String privileges;

	public Admin()
	{

	}

	@Id
	@Column(name = "ano")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId()
	{
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name = "aname")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name = "apwd")
	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Column(name = "nickName")
	public String getNickName()
	{
		return nickName;
	}

	public void setNickName(String nickName)
	{
		this.nickName = nickName;
	}

	@Column(name = "email")
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@Column(name = "lastLoginTime")
	public Timestamp getLastLoginTime()
	{
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	@Column(name = "lastLoginIP")
	public String getLastLoginIP()
	{
		return lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP)
	{
		this.lastLoginIP = lastLoginIP;
	}

	@Column(name = "loginCount")
	public Integer getLoginCount()
	{
		return loginCount;
	}

	public void setLoginCount(Integer loginCount)
	{
		this.loginCount = loginCount;
	}

	@Column(name = "locked")
	public Boolean getLocked()
	{
		return null == locked ? false : locked;
	}

	public void setLocked(Boolean locked)
	{
		this.locked = locked;
	}

	@Column(name="boundedIP")
	public String getBoundedIP()
	{
		return boundedIP;
	}

	public void setBoundedIP(String boundedIP)
	{
		this.boundedIP = boundedIP;
	}

	@Column(name="privileges")
	public String getPrivileges()
	{
		return privileges;
	}

	public void setPrivileges(String privileges)
	{
		this.privileges = privileges;
	}

	@Override
	public String toString()
	{
		return "Admin [id=" + id + ", name=" + name + ", password=" + password
				+ ", nickName=" + nickName + ", email=" + email
				+ ", lastLoginTime=" + lastLoginTime + ", lastLoginIP="
				+ lastLoginIP + ", loginCount=" + loginCount + ", locked="
				+ locked + ", boundedIP=" + boundedIP + ", privileges="
				+ privileges + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
