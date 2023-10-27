package org.zerock.board.command;

public class Criteria {
	//페이지 당 게시글 수의 기준
	
	//mysql, mariadb : select * from tbl_board by num desc limit ?, ?; 시작, 갯수
	
	private int pageNum; //페이지 번호
	private int count;	//페이지당 개시글 수
	
	//기본생성자
	public Criteria() {
		//최초 게시판에 진입시 기본 값 설정 1번 페이지 10개의 게시글
		this.pageNum = 1;
		this.count = 10;
	}
	
	//페이지 시작 게시글 인덱스
	public int getPageStart() {
//		return (pageNum - 1)*count; //mysql, mariadb의 limit를 사용할 경우
		return ((pageNum -1)*count) +1; //오라클의 rownum은 1부터 시작하므로 1을 더해 줌
		//오라클에서 시작 위치를 가리키는 두번째 물음표 위치에 들어가는 값
	}
	
	//오라클을 위해 생성
	public int getPageEnd() {
		return pageNum * count;
	}
	
	//필드 생성자
	public Criteria(int pageNum, int count) {
		//전달된 매개변수를 이용한 페이지 값 출력
		this.pageNum = pageNum;
		this.count = count;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
