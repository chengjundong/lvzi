package com.alu.lvzi.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

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
@Table(name="rfid")
public class Rfid implements Serializable
{
	private static final long serialVersionUID = 4460449712254083874L;
	
	private Integer id;
	private String code;
	private RfidBatch batch;
	private Timestamp verificationTime1;
	private String verificationIP1;
	private Region verificationRegionNo1;
	private Timestamp verificationTime2;
	private String verificationIP2;
	private Region verificationRegionNo2;
	private Timestamp verificationTime3;
	private String verificationIP3;
	private Region verificationRegionNo3;

	public Rfid()
	{

	}

	@Id
	@Column(name="rno")
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

	@Column(name="code")
	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	@JoinColumn(name="batchNo",referencedColumnName="bno")
	@ManyToOne(targetEntity=RfidBatch.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public RfidBatch getBatch()
	{
		return batch;
	}

	public void setBatch(RfidBatch batch)
	{
		this.batch = batch;
	}

	@Column(name="verificationTime1")
	public Timestamp getVerificationTime1()
	{
		return verificationTime1;
	}

	public void setVerificationTime1(Timestamp verificationTime1)
	{
		this.verificationTime1 = verificationTime1;
	}

	@Column(name="verificationIP1")
	public String getVerificationIP1()
	{
		return verificationIP1;
	}

	public void setVerificationIP1(String verificationIP1)
	{
		this.verificationIP1 = verificationIP1;
	}

	@JoinColumn(name="verificationRegionNo1", referencedColumnName="rno")
	@ManyToOne(targetEntity=Region.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public Region getVerificationRegionNo1()
	{
		return verificationRegionNo1;
	}

	public void setVerificationRegionNo1(Region verificationRegionNo1)
	{
		this.verificationRegionNo1 = verificationRegionNo1;
	}

	@Column(name="verificationTime2")
	public Timestamp getVerificationTime2()
	{
		return verificationTime2;
	}

	public void setVerificationTime2(Timestamp verificationTime2)
	{
		this.verificationTime2 = verificationTime2;
	}

	@Column(name="verificationIP2")
	public String getVerificationIP2()
	{
		return verificationIP2;
	}

	public void setVerificationIP2(String verificationIP2)
	{
		this.verificationIP2 = verificationIP2;
	}

	@JoinColumn(name="verificationRegionNo2", referencedColumnName="rno")
	@ManyToOne(targetEntity=Region.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public Region getVerificationRegionNo2()
	{
		return verificationRegionNo2;
	}

	public void setVerificationRegionNo2(Region verificationRegionNo2)
	{
		this.verificationRegionNo2 = verificationRegionNo2;
	}

	@Column(name="verificationTime3")
	public Timestamp getVerificationTime3()
	{
		return verificationTime3;
	}

	public void setVerificationTime3(Timestamp verificationTime3)
	{
		this.verificationTime3 = verificationTime3;
	}

	@Column(name="verificationIP3")
	public String getVerificationIP3()
	{
		return verificationIP3;
	}

	public void setVerificationIP3(String verificationIP3)
	{
		this.verificationIP3 = verificationIP3;
	}

	@JoinColumn(name="verificationRegionNo3", referencedColumnName="rno")
	@ManyToOne(targetEntity=Region.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	public Region getVerificationRegionNo3()
	{
		return verificationRegionNo3;
	}

	public void setVerificationRegionNo3(Region verificationRegionNo3)
	{
		this.verificationRegionNo3 = verificationRegionNo3;
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
		Rfid other = (Rfid) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Rfid [id=" + id + ", code=" + code + ", verificationTime1="
				+ verificationTime1 + ", verificationIP1=" + verificationIP1
				+ ", verificationTime2=" + verificationTime2
				+ ", verificationIP2=" + verificationIP2
				+ ", verificationTime3=" + verificationTime3
				+ ", verificationIP3=" + verificationIP3 + "]";
	}

}
