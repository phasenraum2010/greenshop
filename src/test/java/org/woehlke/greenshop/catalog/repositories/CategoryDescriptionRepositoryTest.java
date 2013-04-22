package org.woehlke.greenshop.catalog.repositories;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.woehlke.greenshop.catalog.entities.CategoryDescription;
import org.woehlke.greenshop.catalog.entities.Language;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/servlet-context.xml")
public class CategoryDescriptionRepositoryTest {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryDescriptionRepositoryTest.class);
	
	@Inject
	private CategoryDescriptionRepository categoryDescriptionRepository;
	
	@Inject
	private CategoryDescriptionRepositoryDao categoryDescriptionRepositoryDao;
	
	@Inject
	private LanguageRepository languageRepository;
	
	@Test
	public void testGetAll() throws Exception {
		for (CategoryDescription p : categoryDescriptionRepository.findAll()){
			logger.info(p.toString());
		}
	}
	
	@Test
	public void findRootCategoriesTest() throws Exception {
		Language language=languageRepository.findByCode("en");
		for (CategoryDescription p : categoryDescriptionRepositoryDao.findRootCategories(language)){
			Assert.assertEquals(0L, p.getCategory().getParentId());
		}
	}
	
	@Test
	public void findCategoriesByParentIdTest() throws Exception {
		Language language=languageRepository.findByCode("en");
		for (CategoryDescription p : categoryDescriptionRepositoryDao.findRootCategories(language)){
			for (CategoryDescription p2 : categoryDescriptionRepositoryDao.findCategoriesByParentId(p.getCategory().getId(),language)){
				Assert.assertEquals(p.getCategory().getId().longValue(), p2.getCategory().getParentId());
			}	
		}
	}
}