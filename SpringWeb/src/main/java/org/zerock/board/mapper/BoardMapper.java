package org.zerock.board.mapper;

import java.util.List;

import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;

public interface BoardMapper {
	
	//게시판 등록
	public void insertBoard(BoardVO vo);
	//게시판 수정
	public boolean updateBoard(BoardVO vo);
	//게시판 삭제
	public void deleteBoard(String num); //delete는 반환값이 나오지 않는다. insert,update만 반환 값이 있다.
	//게시판 목록 가져오기
	public List<BoardVO> getList();
	//게시판 상세 보기
	public BoardVO getContent(String num);
	
	//페이징 쿼리문 : 매개변수로 Criteria 클래스를 받아서 특정 페이지의 게시글을 출력하는 메서드
	public List<BoardVO> pagingList(Criteria cri);
	//전체 게시글 데이터 수
	public int getTotal();
}
