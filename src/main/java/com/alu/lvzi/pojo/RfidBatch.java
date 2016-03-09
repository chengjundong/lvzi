package com.alu.lvzi.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;

@Entity
@Table(name="rfidbatch")
public class RfidBatch implements Serializable
{
	private static final long serialVersionUID = 5381763176481453228L;
	
	private Integer id;
	private String fileName;
	private Integer rfidCount;
	private Admin operator;
	private Timestamp importingTime;
	private String originPlace;
	private String originPlacePic;
	private String pickingTime;
	private String pickingTimePic;
	private String squeezingTime;
	private String squeezingTimePic;
	private String packagingTime;
	private String packagingTimePic;
	private String shippingTime;
	private String shippingTimePic;
	private String inPortTime;
	private String inPortTimePic;
	private String subpackagingTime;
	private String subpackagingTimePic;
	private String marketingTime;
	private String marketingTimePic;

	public RfidBatch()
	{

	}

	@Id
	@Column(name="bno")
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

	@Column(name="fileName")
	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	@Column(name="rfidCount")
	public Integer getRfidCount()
	{
		return rfidCount;
	}

	public void setRfidCount(Integer rfidCount)
	{
		this.rfidCount = rfidCount;
	}

	@JSON(serialize=false)
	@JoinColumn(name="operatorNo", referencedColumnName="ano")
	@ManyToOne(targetEntity=Admin.class,fetch=FetchType.LAZY)
	public Admin getOperator()
	{
		return operator;
	}

	public void setOperator(Admin operator)
	{
		this.operator = operator;
	}

	@Column(name="importingTime")
	public Timestamp getImportingTime()
	{
		return importingTime;
	}

	public void setImportingTime(Timestamp importingTime)
	{
		this.importingTime = importingTime;
	}

	@Column(name="originPlace")
	public String getOriginPlace()
	{
		return originPlace;
	}

	public void setOriginPlace(String originPlace)
	{
		this.originPlace = originPlace;
	}

	@Column(name="originPlacePic")
	public String getOriginPlacePic()
	{
		return originPlacePic;
	}

	public void setOriginPlacePic(String originPlacePic)
	{
		this.originPlacePic = originPlacePic;
	}

	@Column(name="pickingTime")
	public String getPickingTime()
	{
		return pickingTime;
	}

	public void setPickingTime(String pickingTime)
	{
		this.pickingTime = pickingTime;
	}

	@Column(name="pickingTimePic")
	public String getPickingTimePic()
	{
		return pickingTimePic;
	}

	public void setPickingTimePic(String pickingTimePic)
	{
		this.pickingTimePic = pickingTimePic;
	}

	@Column(name="squeezingTime")
	public String getSqueezingTime()
	{
		return squeezingTime;
	}

	public void setSqueezingTime(String squeezingTime)
	{
		this.squeezingTime = squeezingTime;
	}

	@Column(name="squeezingTimePic")
	public String getSqueezingTimePic()
	{
		return squeezingTimePic;
	}

	public void setSqueezingTimePic(String squeezingTimePic)
	{
		this.squeezingTimePic = squeezingTimePic;
	}

	@Column(name="packagingTime")
	public String getPackagingTime()
	{
		return packagingTime;
	}

	public void setPackagingTime(String packagingTime)
	{
		this.packagingTime = packagingTime;
	}

	@Column(name="packagingTimePic")
	public String getPackagingTimePic()
	{
		return packagingTimePic;
	}

	public void setPackagingTimePic(String packagingTimePic)
	{
		this.packagingTimePic = packagingTimePic;
	}

	@Column(name="shippingTime")
	public String getShippingTime()
	{
		return shippingTime;
	}

	public void setShippingTime(String shippingTime)
	{
		this.shippingTime = shippingTime;
	}

	@Column(name="shippingTimePic")
	public String getShippingTimePic()
	{
		return shippingTimePic;
	}

	public void setShippingTimePic(String shippingTimePic)
	{
		this.shippingTimePic = shippingTimePic;
	}

	@Column(name="inPortTime")
	public String getInPortTime()
	{
		return inPortTime;
	}

	public void setInPortTime(String inPortTime)
	{
		this.inPortTime = inPortTime;
	}

	@Column(name="inPortTimePic")
	public String getInPortTimePic()
	{
		return inPortTimePic;
	}

	public void setInPortTimePic(String inPortTimePic)
	{
		this.inPortTimePic = inPortTimePic;
	}

	@Column(name="subpackagingTime")
	public String getSubpackagingTime()
	{
		return subpackagingTime;
	}

	public void setSubpackagingTime(String subpackagingTime)
	{
		this.subpackagingTime = subpackagingTime;
	}

	@Column(name="subpackagingTimePic")
	public String getSubpackagingTimePic()
	{
		return subpackagingTimePic;
	}

	public void setSubpackagingTimePic(String subpackagingTimePic)
	{
		this.subpackagingTimePic = subpackagingTimePic;
	}

	@Column(name="marketingTime")
	public String getMarketingTime()
	{
		return marketingTime;
	}

	public void setMarketingTime(String marketingTime)
	{
		this.marketingTime = marketingTime;
	}

	@Column(name="marketingTimePic")
	public String getMarketingTimePic()
	{
		return marketingTimePic;
	}

	public void setMarketingTimePic(String marketingTimePic)
	{
		this.marketingTimePic = marketingTimePic;
	}

	@Override
	public String toString()
	{
		return "RfidBatch [id=" + id + ", fileName=" + fileName
				+ ", rfidCount=" + rfidCount + ", importingTime="
				+ importingTime + ", originPlace=" + originPlace
				+ ", originPlacePic=" + originPlacePic + ", pickingTime="
				+ pickingTime + ", pickingTimePic=" + pickingTimePic
				+ ", squeezingTime=" + squeezingTime + ", squeezingTimePic="
				+ squeezingTimePic + ", packagingTime=" + packagingTime
				+ ", packagingTimePic=" + packagingTimePic + ", shippingTime="
				+ shippingTime + ", shippingTimePic=" + shippingTimePic
				+ ", inPortTime=" + inPortTime + ", inPortTimePic="
				+ inPortTimePic + ", subpackagingTime=" + subpackagingTime
				+ ", subpackagingTimePic=" + subpackagingTimePic
				+ ", marketingTime=" + marketingTime + ", marketingTimePic="
				+ marketingTimePic + "]";
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
		RfidBatch other = (RfidBatch) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
