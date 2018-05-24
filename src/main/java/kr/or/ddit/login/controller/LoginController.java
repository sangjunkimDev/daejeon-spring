package kr.or.ddit.login.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVO;
import kr.or.ddit.login.service.LoginServiceInf;
import kr.or.ddit.member.model.MemberVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("loginController")
public class LoginController {
	
	@Resource(name="loginService")
	private LoginServiceInf loginService;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * Method : login
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 로그인 폼 요청
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login/login";
	}
	
	/**
	 * Method : login
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 로그인 처리
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(MemberVO memberVO, HttpSession session, Model model) {
		
		Map<String, Object> resultMap = loginService.loginProcess(memberVO);
		
		boolean loginPassed = (boolean) resultMap.get("loginPassed");
		//로그인 성공
		if (loginPassed) {
			//loginPassed에서 리턴한 resultVO 값을 session에 LOGIN_USER KEY로 설정
			//main/main 화면으로 이동
			
			session.setAttribute("LOGIN_USER", resultMap.get("resultVO"));
			model.addAttribute("boardList", makeTempBoardList());
			
			return "main/main";
		}
		//login 실패
		else {			
			//login/login 화면으로 이동
			return "login/login";
		}
	}
	
	
	/**
	 * Method : loginMav
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @return
	 * Method 설명 : ModelAndView 객체를 이용한 로그인 처리
	 */
	@RequestMapping(value="/loginMav", method=RequestMethod.POST)
	public ModelAndView loginMav(MemberVO memberVO, HttpSession session){
		logger.debug("{}", "loginMav()");
		Map<String, Object> resultMap = loginService.loginProcess(memberVO);
		
		boolean loginPassed = (boolean) resultMap.get("loginPassed");
		
		//new ModelAndView(view이름);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		mav.addObject("boardList", makeTempBoardList());
		
		//로그인 성공
		if (loginPassed) {
			//loginPassed에서 리턴한 resultVO 값을 session에 LOGIN_USER KEY로 설정
			//main/main 화면으로 이동
			session.setAttribute("LOGIN_USER", resultMap.get("resultVO"));
			
			mav.setViewName("main/main");
		}
		return mav;
	}
	
	
	private List<BoardVO> makeTempBoardList(){
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		boardList.add(new BoardVO(1, "첫번째 글입니다", "첫번째 글 내용입니다", "brown", new Date()));
		boardList.add(new BoardVO(2, "두번째 글입니다", "두번째 글 내용입니다", "jessica", new Date()));
		boardList.add(new BoardVO(3, "세번째 글입니다", "세번째 글 내용입니다", "james", new Date()));
		boardList.add(new BoardVO(4, "네번째 글입니다", "네번째 글 내용입니다", "sally", new Date()));
		boardList.add(new BoardVO(5, "다섯번째 글입니다", "다섯번째 글 내용입니다", "cony", new Date()));
		
		return boardList;
	}
	
	
}
