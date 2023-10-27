package org.zerock.member.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.member.command.MemberVO;
import org.zerock.member.mapper.MemberMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class MyBatisMemberTest {
	
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void mapper() {
		System.out.println("----- mapper 객체 생성 확인 : "+mapper);
	}
	
	@Test
	public void join() {
		MemberVO vo = new MemberVO("tester", "testpw", "testuser", null);
		int result = mapper.join(vo);
		System.out.println("join test 성공");
	}
	
	@Test
	public void idCheck() {
		String id = "tester";
		int result = mapper.idCheck(id);
		if(result == 1)System.out.println("idCheck 성공");
		else System.out.println("idCheck 실패 : "+result);
	}
	
	@Test
	public void login() {
		MemberVO vo = new MemberVO("tester", "testpw", null, null);
		int result = mapper.login(vo);
		if(result == 1)System.out.println("login 성공");
		else System.out.println("login 실패 : "+result);
	}
}

