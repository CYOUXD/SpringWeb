<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ include file="../include/header.jsp" %>

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header">Board Register</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="card">
      <div class="card-header bg-primary text-white">게시글 등록</div>
      <div class="card-body">
      
        <form role="form" action="register" method="post" id="regForm">
          <div class="form-group">
            <label>제목</label>
            <input class="form-control" name='title' id="title">
          </div>

          <div class="form-group">
            <label>내용</label>
            <textarea class="form-control" rows="5" name='content' id="content"></textarea>
          </div>

          <div class="form-group">
            <label>작성자</label>
            <input class="form-control" name='writer' id="writer">
          </div>
          <button type="button" class="btn btn-primary" onclick="register()">등록</button>
          <button type="button" class="btn btn-primary" onclick="loation.href='list'">취소</button>
        </form>
        
      </div>
      <!--  end card-body -->
    </div>
    <!--  end card-body -->
  </div>
  <!-- end card -->
</div>
<!-- /.row -->
<%@ include file="../include/footer.jsp" %>
<script>
	function register() {
		//$("#아이디") : HTML의 아이디 속성에 접근 - 제이쿼리
		//val() 함수를 사용하면 해당 값에 접근이 가능함
		if($("#title").val() == "") { //document.폼이름.title.values
			alert("제목은 필수 입니다.");
		}else if($("#writer") == "") {
			alert("작성자는 필수 입니다.");
		}else if(confirm("등록하시겠습니까?")) {
			$("#regForm").submit(); //스크립트 서브밋 처리
		}
	}
</script>

</body>
</html>