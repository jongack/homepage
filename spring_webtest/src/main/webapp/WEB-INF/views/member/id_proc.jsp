<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="../ssi/ssi.jsp" %> 
<jsp:useBean id ="dao" class="member.MemberDAO"/>
<%
	String id = request.getParameter("id");

	boolean flag = dao.duplicateID(id);
%>
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
<style type="text/css"> 
*{ 
  font-family: ; 
  font-size: 24px; 
} 
</style> 
<script type="text/javascript">
	function use(){
		opener.frm.id.value='<%=id%>';
		self.close();
	}
</script>
<link href="<%=root%>/css/style.css" rel="Stylesheet" type="text/css">
</head> 
<!-- *********************************************** -->
<body>

<!-- *********************************************** -->
 
<DIV class="title">아이디 중복확인</DIV>
 <div class ="content">
 입력된 ID:<br><br>
 <%
 	if(flag){
 		out.print("중복되어서 사용할 수 없습니다.<br><br>");
 	}else{
 		out.print("중복아님,사용 가능합니다.<br><br>");
 		out.print("<input type='button' value='사용' onclick='use(id)'> ");
 	}
 %>
 </div>
  
  <DIV class='bottom'>
    <input type='button' value='다시시도' onclick="location.href='id_form.jsp' ">
    <input type='button' value='취소' onclick="window.close()">
  </DIV>

<!-- *********************************************** -->

</body>
<!-- *********************************************** -->
 
</html> 