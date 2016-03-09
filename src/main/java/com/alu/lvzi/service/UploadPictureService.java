package com.alu.lvzi.service;

import java.io.File;

public interface UploadPictureService
{
	/**
	 * 保存图片
	 * 
	 * @param img  从Web页面上传过来的临时图片文件
	 * @param path 图片需要保存到的完整路径
	 * @param fileName 原始文件名
	 */
	abstract public void savePicture(File img, String path, String fileName);
}
