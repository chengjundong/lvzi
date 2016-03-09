package com.alu.lvzi.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.io.FileUtils;

import com.alu.lvzi.service.UploadPictureService;

public class UploadPictureServiceImpl implements UploadPictureService
{
	// 缩略图的制定图片大小
	private static final int THUMB_WIDTH = 80;
	private static final int THUMB_HEIGHT = 40;
	
	@Override
	public void savePicture(File img, String path, String fileName)
	{
		// 文件保存到对应的path底下
		String newFileName = this.generateRandomFileName(fileName);
		copyOriginalPicture(img, path+newFileName);
		// 生成缩略图并保存到Thumb底下
		generateAndSaveThumbPicture(img, path+"/thumb/thumb_"+newFileName);
	}

	private void generateAndSaveThumbPicture(File img, String fileName)
	{
		try
		{
			Thumbnails.of(img).size(THUMB_WIDTH, THUMB_HEIGHT).keepAspectRatio(false)
				.toFile(new File(fileName));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void copyOriginalPicture(File img, String fileName)
	{
		try
		{
			FileUtils.copyFile(img, new File(fileName));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成一个随机的图片名称
	 * 
	 * @param fileName 原始图片文件名
	 * @return String
	 */
	private String generateRandomFileName(String fileName)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append(System.currentTimeMillis());
		buffer.append(ThreadLocalRandom.current().nextInt(10000, 99999));
		buffer.append(fileName.substring(fileName.lastIndexOf(".")));
		
		return buffer.toString();
	}
}
