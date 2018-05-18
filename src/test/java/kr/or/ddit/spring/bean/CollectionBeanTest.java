package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * CollectionBeanTest.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 18.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 18. "K.S.J" 최초 생성
 *
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-collection.xml")
public class CollectionBeanTest {
	
	@Resource(name="collectionBean")
	private CollectionBean collectionBean;
	
	@Test
	public void collectionBeanMapTest() {
		/***Given***/
		
		/***When***/
		Map<String, String> map = collectionBean.getMap();
		
		/***Then***/
		//userId : brown, alias : sally
		assertEquals("brown", map.get("userId"));
		assertEquals("sally", map.get("alias"));
		
	}
	
	@Test
	public void collectionBeanListTest() {
		/***Given***/
		
		/***When***/
		List<String> list = collectionBean.getList();
		
		/***Then***/
		//userId : brown, alias : sally
		assertEquals("brown", list.get(0));
		assertEquals("sally", list.get(1));
		assertEquals("cony", list.get(2));
	}
	
	@Test
	public void collectionBeanSetTest() {
		/***Given***/
		
		/***When***/
		Set<String> set = collectionBean.getSet();
		
		/***Then***/
		assertTrue(set.contains("brown"));
		assertTrue(set.contains("sally"));
		assertTrue(set.contains("cony"));
	}
	
	@Test
	public void collectionBeanPropertiesTest() {
		/***Given***/
		
		/***When***/
		Properties properties = collectionBean.getProperties();
		
		/***Then***/
		properties.get(properties.get("userId"));
		properties.get(properties.get("alias"));
	}
	
	

}
