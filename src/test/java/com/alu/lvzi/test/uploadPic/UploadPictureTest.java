package com.alu.lvzi.test.uploadPic;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alu.lvzi.service.UploadPictureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UploadPictureTest
{
	@Autowired
	@Qualifier("uploadPictureService")
	private UploadPictureService service;
	
	@Test
	public void testSavePicture()
	{
		File img = new File("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");
		String path = "C:/Users/jundonch/Desktop/";
		service.savePicture(img, path, "Desert.jpg");
	}
}
