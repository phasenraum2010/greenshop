package org.woehlke.greenshop.oodm.catalog.repositories;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.oodm.catalog.entities.Manufacturer;

import java.util.List;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class ManufacturerRepositoryTest {

	private static final Logger logger = LoggerFactory.getLogger(ManufacturerRepositoryTest.class);
	
	@Inject
	private ManufacturerRepository manufacturerRepository; 
	
	@Test
	public void testGetAll() throws Exception {
		List<Manufacturer> all = manufacturerRepository.findAll();
		logger.info("------------------------------------------------------");
		for (Manufacturer p : all){
			logger.info(p.toString());
		}
		logger.info("------------------------------------------------------");
	}
}
