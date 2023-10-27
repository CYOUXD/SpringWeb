package org.zerock.board.command;

import java.sql.Timestamp;

public class BoardVO {
	//VO 객체는 DB 컬럼과 1:1 매칭이 될 수 있도록 생성해야 한다.
	//VO 객체는 DB 컬럼명과 동일하게 만들어 사용한다.
	//VO 객체는 은닉변수로 선언, getter, setter를 이용하여 차단
	//VO 객체는 모든 멤버변수를 초기화하는 생성자, 기본 생성자 2개를 선언한다.
	
	private int num;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private Timestamp updatedate;
	
	public BoardVO() {}

	public BoardVO(int num, String title, String content, String writer, Timestamp regdate, Timestamp updatedate) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", updatedate=" + updatedate + "]";
	}
}
