package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.board.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("")
	public String goHome() {
		return "home";
	}
	
	//조인 화면 처리
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		
		return "member/join";
	}
	
	//로그인 화면 처리
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "member/login";
	}
	
	//ajax 요청 받기
	//json 라이브러리를 이용해서 처리
//	<dependency>
//	    <groupId>com.fasterxml.jackson.core</groupId>
//	    <artifactId>jackson-databind</artifactId>
//	    <version>2.15.2</version>
//	</dependency>
	@RequestMapping(value="/checkId", method=RequestMethod.POST) 
	@ResponseBody
	//@ResponseBody : 페이지 이동 없이 데이터를 주고 받음. 
	//메서드에서 리턴되는 값은 view리졸버로 전달되지 않고 해당 메서드를 호출한 곳으로 결과를 반환
	public int checkId(@RequestParam("id") String id) {
		int result = memberService.idCheck(id);
		
		return result;
	}
	
	
	
	//ajax test
	@RequestMapping("/ajax_test")
	public String ajaxTest() {
		return "member/ajax_test";
	}
}
