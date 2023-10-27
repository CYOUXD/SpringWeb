package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.board.command.BoardVO;
import org.zerock.board.command.Criteria;
import org.zerock.board.command.PageVO;
import org.zerock.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("")
	public String goHome() {
		return "home"; //잘못 입력 시(=없는 경로) 목록보기나 메인으로 이동. 
		//목록으로 이동하려면 redirect로 이동해야 데이터가 같이 들어 갈 수 있다.
	}
	
	//페이징 처리 전
//	@RequestMapping(value="/list", method=RequestMethod.GET)
//	public String list(Model model) {
//		//게시글 가져오기
//		List<BoardVO> list = boardService.getList();
//		
//		//model에 담아서 전달
//		model = model.addAttribute("board_list", list);
//		
//		return "board/list";		
//	}
	
	//페이징 처리 후
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model, Criteria cri) {
		//페이징 게시글 가져오기
		List<BoardVO> list = boardService.getList(cri);
		
		//model에 담아서 전달
		model = model.addAttribute("board_list", list);
		
		//pageVO 전달
		int total = boardService.getTotal();
		model.addAttribute("pageMaker", new PageVO(cri, total));
		
		return "board/list";		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register() { //글 작성 페이지로 이동
		System.out.println("글 작성 페이지로 화면 이동");
		return "board/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(BoardVO vo) { //오버로드	
		System.out.println(vo);
		boardService.register(vo);
		
		return "redirect:/board/list";	//그냥 리스트를 써도 된다..? 왜? 상대경로라서?
		//list의 화면만 보여주는게 아니라 데이터를 같이 보여줘야 하니까 페이지 이동인 redirect해 준다.
	}
	
	//상세보기 및 수정 페이지 보기
	@RequestMapping(value={"/content", "/modify"})
	public void content(@RequestParam("num") String num, Model model, @ModelAttribute("cri") Criteria cri) { //상세보기
		//@ModelAttribute("cri") Criteria cri : 8. 페이징에서 추가함
		BoardVO vo = boardService.getContent(num);
		model = model.addAttribute("board", vo);
		//반환 값이 void면 value="/content" 를 뷰 리졸버로 넘긴다
	}
	
	//수정 작업 진행
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(BoardVO vo) {
		System.out.println("--------수정 컨트롤러 계층 -------");
		//수정 서비스 호출 처리
		boardService.update(vo);
		return "redirect:/board/list"; //컨텐츠로 가도 됨
	}
	
	//게시판 삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") String num) {
		boardService.delete(num);
		
		return "redirect:/board/list";
	}
}
