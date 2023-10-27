package org.zerock.board.service;

import org.zerock.member.command.MemberVO;

public interface MemberService {
	public int idCheck(String id);
	public int join(MemberVO vo);
	public int login(MemberVO vo);
}
