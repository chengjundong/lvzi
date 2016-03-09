package com.alu.lvzi.action.background;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.alu.lvzi.service.UploadPictureService;
import com.opensymphony.xwork2.ActionSupport;

public class UploadPictureAction extends ActionSupport
{
	private static final long serialVersionUID = 2667045775535790206L;
	
	private String type;
	private File uploadedImg;
	private String uploadedImgFileName;
	private String uploadedImgContentType;
	private UploadPictureService uploadPictureService;

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public File getUploadedImg()
	{
		return uploadedImg;
	}

	public void setUploadedImg(File uploadedImg)
	{
		this.uploadedImg = uploadedImg;
	}

	public UploadPictureService getUploadPictureService()
	{
		return uploadPictureService;
	}

	public void setUploadPictureService(
			UploadPictureService uploadPictureService)
	{
		this.uploadPictureService = uploadPictureService;
	}
	
	public String getUploadedImgFileName()
	{
		return uploadedImgFileName;
	}

	public void setUploadedImgFileName(String uploadedImgFileName)
	{
		this.uploadedImgFileName = uploadedImgFileName;
	}

	public String getUploadedImgContentType()
	{
		return uploadedImgContentType;
	}

	public void setUploadedImgContentType(String uploadedImgContentType)
	{
		this.uploadedImgContentType = uploadedImgContentType;
	}

	@Override
	public String execute() throws Exception
	{
		return SUCCESS;
	}

	public String doUpload()
	{
		String realPath = ServletActionContext.getServletContext().getRealPath("/image/verify/"+type);
		uploadPictureService.savePicture(uploadedImg, realPath+"/", uploadedImgFileName);
		return SUCCESS;
	}
}
