<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
	<!-- =simpledataformat과 같다. 날짜 포맷 맞추기 위해 사용 -->
<!DOCTYPE html>
<html lang="en">

<head>

</head>

<body id="page-top">
	<!-- Page Wrapper -->

	<%@include file="../include/header.jsp"%>

	<!-- Begin Page Content -->
	

		<!-- Page Heading -->
		<h1 class="h3 mb-2 text-gray-800">게시판</h1>


		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">공지사항 샘플 게시판
                    <button type="button" class="btn btn-primary btn-sm float-right" onclick="location.href='register'">글쓰기</button>
                </h6>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>수정일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${board_list}">
							<tr>
								<td>${list.num }</td>
								<td>
									<!-- 7. 조회 페이지 이동 -->
									<!-- 상세 페이지 이동 후 목록 화면으로 이동할 때, 기존 페이지를 유지하지 못하는 문제
									유지하고 싶다면 페이지 이동시 pageNum 값을 가지고 다녀야 한다. -->
									<a href="content?num=${list.num }&pageNum=${pageMaker.cri.pageNum}">${list.title }</a>
								</td>
								<td>${list.writer }</td>
								<td>
									<fmt:formatDate value="${list.regdate }" pattern="yyyy-MM-dd hh:mm"/>
								</td>
								<td>
									<fmt:formatDate value="${list.updatedate }" pattern="yyyy-MM-dd hh:mm"/>
								</td>
							</tr>
							</c:forEach>
						</tbody>
						
					</table>
					<!-- 페이징 처리 부분 부트스트랩 참고 -->
					<ul class="pagination justify-content-center">
						<!-- 1. 이전 버튼 활성화 여부 -->
						<c:if test="${pageMaker.prev }">
           	 			<li class="page-item">
           	 				<!-- 6. 이전 페이지 버튼 활성화 링크 -->
							<a class="page-link" href="list?pageNum=${pageMaker.startPage-1 }">Previous</a>
						</li>
						</c:if>
					   <!-- 3. 페이지 번호 활성화 -->
					   <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
				    	<!-- 4. 페이지 별 나오게 값을 전달하면서 동시에 어떤 페이지인지 표시할 수 있게 active 활성화 -->
					    <li class="page-item  ${num==pageMaker.cri.pageNum?'active':''}">
					    	<a class="page-link" href="list?pageNum=${num }">${num }</a>
					    </li>
					   </c:forEach>
					   <!-- 2. 다음 버튼 활성화 -->
					   <c:if test="${pageMaker.next }">
					    <li class="page-item">
					    	<!-- 5. next 버튼 활성화 링크 -->
					      <a class="page-link" href="list?pageNum=${pageMaker.endPage+1 }">Next</a>
					    </li>
					   </c:if>
				    </ul>
					<!-- 페이징 처리 끝 -->
				</div>
			</div>
		</div>
	<!-- End of Main -->

	<%@ include file="../include/footer.jsp"%>
</body>

</html>
