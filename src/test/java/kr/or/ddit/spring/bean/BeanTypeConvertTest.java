package kr.or.ddit.spring.bean;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:kr/or/ddit/spring/bean/application-context-typeconvert.xml")
public class BeanTypeConvertTest {
	Logger logger = LoggerFactory.getLogger(BeanTypeConvertTest.class);
	
	@Resource(name="boardVo")
	BoardVo boardVo;
	
	@Test
	public void boardVoTypeConvertTest() {
		/***Given***/
		Integer board_seq = 1;
		String title = "title";
		String contents = "contents";
		String reg_id = "brown";
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, Calendar.MAY, 21, 0, 0, 0);
		Date reg_dt = calendar.getTime();
		
		logger.debug("{} : {}", "reg_dt.toString()", reg_dt.toString());
		logger.debug("{} : {}", "boardVo.getReg_dt().toString()", boardVo.getReg_dt().toString());
		/***When***/

		/***Then***/
		assertNotNull(boardVo);
		assertEquals(board_seq, boardVo.getBoard_seq());
		assertEquals(title, boardVo.getTitle());
		assertEquals(contents, boardVo.getContents());
		assertEquals(reg_id, boardVo.getReg_id());
		assertEquals(reg_dt.toString(), boardVo.getReg_dt().toString());
		assertEquals(1234, boardVo.getReadCnt());
	}
}
