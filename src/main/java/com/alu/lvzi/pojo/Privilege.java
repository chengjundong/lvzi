package com.alu.lvzi.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="privilege")
public class Privilege implements Serializable
{
	private static final long serialVersionUID = -4897142426119842745L;
	
	private Integer id;
	private String name;
	private String url;
	private String description;
	private Privilege parent;

	public Privilege()
	{

	}

	@Id
	@Column(name="pno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId()
	{
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Integer id)
	{
		this.id = id;
	}

	@Column(name="pname")
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Column(name="url")
	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	@Column(name="description")
	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	@JoinColumn(name="parentNo")
	@ManyToOne(targetEntity=Privilege.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public Privilege getParent()
	{
		return parent;
	}

	public void setParent(Privilege parent)
	{
		this.parent = parent;
	}

	@Override
	public String toString()
	{
		return "Privilege [id=" + id + ", name=" + name + ", url=" + url
				+ ", description=" + description + "]";
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
		Privilege other = (Privilege) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
