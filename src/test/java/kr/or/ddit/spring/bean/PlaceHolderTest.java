package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * PlaceHolderTest.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 21. "K.S.J" 최초 생성
 *
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-ph.xml")
public class PlaceHolderTest {
	@Resource(name="dbProperties")
	DbProperties dbProperties;
	
	//dbProperties spring bean 생성확인
	//test method 이름, 테스트 코드 작성
	//getMethod를 통해서 각 속성이 설정한 값으로 설정되었는지 테스트
	@Test
	public void dbPropertiesCreateTest() {
		/***Given***/
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "pc17";
		String password = "java";
		
		/***When***/
		
		/***Then***/
		assertNotNull(dbProperties);
		assertEquals(driver, dbProperties.getDriver());
		assertEquals(url, dbProperties.getUrl());
		assertEquals(username, dbProperties.getUsername());
		assertEquals(password, dbProperties.getPassword());
	}

	
	
}
