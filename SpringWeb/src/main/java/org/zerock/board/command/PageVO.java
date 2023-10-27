package org.zerock.board.command;

public class PageVO {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean  next;
	private int total;
	private Criteria cri;
	
	//기본 값을 지정할 수 없어 기본 생성자는 만들 수 없음.
	//필드 생성자
	public PageVO(Criteria cri, int total) {
		super();
		this.total = total;
		this.cri = cri;
		
		//여기서 다른 데이터를 만들어야 한다.
		//endPage
		//공식 : (int)Math.ceil(페이지번호/(double)한번에 보여질 페이지 수) * 한번에 보여질 페이지 수;
		this.endPage = (int)Math.ceil(cri.getPageNum()/(double)10) * 10;
		
		//startPage
		//공식 : endPage - 한번에 보여질 페이지 개수 + 1
		this.startPage = endPage - 10 +1;
		
		//realEndPage : endPage 보다 실제 페이지의 끝 번호가 큰 경우, 작은 경우(endPage = realEnd)
		int realEnd = (int)Math.ceil(total/(double)cri.getCount());
		if(this.endPage > realEnd) { //realEnd가 endPage 보다 작은 경우
			this.endPage = realEnd;
		}
		
		//이전 버튼
		this.prev = this.startPage > 1; //활성화 여부
		
		//다음 페이지
		this.next = realEnd > this.endPage; //활성화 여부
		
//		System.out.println("[endPage] : "+endPage);		
//		System.out.println("[startPage] : "+startPage);		
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
}
