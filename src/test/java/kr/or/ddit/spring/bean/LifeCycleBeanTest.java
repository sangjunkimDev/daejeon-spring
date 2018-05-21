package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-lifecycle.xml")
public class LifeCycleBeanTest {
	//lifeCycleBean을 주입
	@Resource(name="lifeCycle")
	LifeCycleBean lifeCycleBean;
	
	//spring bean의 lifecycle 테스트
	//테스트 메서드 작명
	@Test
	public void springBeanLifeCycleTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertNotNull(lifeCycleBean);
		
	}

}
