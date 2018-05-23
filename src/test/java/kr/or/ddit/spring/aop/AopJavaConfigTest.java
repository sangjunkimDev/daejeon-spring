package kr.or.ddit.spring.aop;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.or.ddit.spring.bean.user.dao.UserDaoInf;
import kr.or.ddit.spring.bean.user.service.UserServiceInf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AopJavaConfigTest.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 23. "K.S.J" 최초 생성
 *
 * </pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AopJavaConfig.class})
public class AopJavaConfigTest {
	
	@Resource(name="userDao")
	private UserDaoInf userDao;
	
	@Resource(name="userService")
	private UserServiceInf userService;
	
	@Test
	public void userDaoBeanCreateTest() {
		/***Given***/

		/***When***/
		
		/***Then***/
		assertNotNull(userDao);
		assertEquals(25, userDao.getUserList().size());
	}
	
	@Test
	public void userServiceCreateTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(userService);
		assertEquals(userDao, userService.getUserDao());
		assertEquals(25, userService.getUserList().size());
	}
}
