package org.zerock.board.service;

import java.util.List;

import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;

//@Service 어노테이션은 여기 말고 실제 구현체에 써준다.
public interface BoardService {
	public List<BoardVO> getList(); //게시글 리스트 메서드
	public void register(BoardVO vo); //게시글 등록 메서드
	public BoardVO getContent(String num); //게시글 상세 보기 메서드
	public void update(BoardVO vo); //게시글 수정
	public void delete(String num); //게시글 삭제
	
	//페이징 처리
	public List<BoardVO> getList(Criteria cri); //페이징 처리된 게시글
	public int getTotal(); //전체 게시글 수
}
