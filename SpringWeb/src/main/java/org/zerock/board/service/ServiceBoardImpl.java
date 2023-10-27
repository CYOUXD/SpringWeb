package org.zerock.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;
import org.zerock.board.mapper.BoardMapper;

@Service("boardService") //??????? 이게 뭐더라...?
//답 : 이 어노테이션을 달면 루트 컨텍스트에 자동으로 bean 객체로 생성해 준다.
//root-context에서는 다음과 같다.
//<bean id="hotel" class="test02.construct.Hotel">
//	<constructor-arg ref="chef" />
//</bean>
//= "Hotel hotel = new Hotel(chef)"를 한 것과 같음
//여기서 class의 값이 자동으로 제일 앞 글자가 소문자로 변형되어 연결된다. = boardService
//= BoardService 클래스(인터페이스)를 ServiceBoardImpl로 생성(구현)한다는 의미와 같다.
public class ServiceBoardImpl implements BoardService {
	
	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		//전체 게시글 리스트 불러오기
		return mapper.getList();
	}

	@Override
	public void register(BoardVO vo) {
		//게시글 등록
		mapper.insertBoard(vo);
	}

	@Override
	public BoardVO getContent(String num) {
		//게시글 상세보기
		return mapper.getContent(num);
	}

	@Override
	public void update(BoardVO vo) {
		//게시글 수정하기
		boolean result = mapper.updateBoard(vo);
		System.out.println("수정 성공, 실패 : " +result);
	}

	@Override
	public void delete(String num) {
		//게시글 삭제하기
		mapper.deleteBoard(num);
	}
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		return mapper.pagingList(cri);
	}
	
	@Override
	public int getTotal() {
		return mapper.getTotal();
	}

}
