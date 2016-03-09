package com.alu.lvzi.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alu.lvzi.dao.CityDAO;
import com.alu.lvzi.pojo.City;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CityDAOTest
{
	@Autowired
	@Qualifier("cityDAO")
	private CityDAO cityDAO;
	
	@Test
	@Transactional
	public void testQuery()
	{
		List<City> cities = cityDAO.findAll();
		for (City city : cities)
		{
			System.out.println(city + " : "  + city.getRegion());
		}
	}
}
