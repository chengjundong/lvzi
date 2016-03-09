package com.alu.lvzi.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alu.lvzi.dao.RegionDAO;
import com.alu.lvzi.pojo.Region;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class RegionDAOTest
{
	@Autowired
	@Qualifier("regionDAO")
	private RegionDAO regionDAO;
	
	@Test
	@Transactional
	public void testQuery()
	{
		List<Region> regions = regionDAO.findAll();
		for (Region region : regions)
		{
			System.out.println(region);
		}
	}
}
