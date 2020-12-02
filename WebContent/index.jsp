<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>JSP AJAX 회원가입</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>
</head>
<body>
	<div class="container">
		<form action="./userRegister" method="post">
			<table class="table table-bordered table-hover"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"><h4>회원 등록 양식</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 120px;"><h5>아이디</h5></td>
						<td><input type="text" class="form-control" id="userID"
							name="userID" maxlength="20" /></td>
						<td style="width: 130px;"><button class="btn btn-primary"
								onclick="registerCheckFunction();" type="button">중복체크</button></td>
					</tr>
					<tr>
						<td style="width: 120px;"><h5>비밀번호</h5></td>
						<td colspan="2"><input type="password" class="form-control"
							id="userPW1" name="userPW1" maxlength="20" /></td>
					</tr>
					<tr>
						<td style="width: 130px;"><h5>비밀번호 확인</h5></td>
						<td colspan="2"><input type="password" class="form-control"
							id="userPW2" name="userPW2" maxlength="20" /></td>
					</tr>
					<tr>
						<td style="width: 120px;"><h5>이름</h5></td>
						<td colspan="2"><input type="text" class="form-control"
							id="userName" name="userName" maxlength="20" /></td>
					</tr>
					<tr>
						<td style="width: 120px;"><h5>나이</h5></td>
						<td colspan="2"><input type="text" class="form-control"
							id="userAge" name="userAge" maxlength="20" /></td>
					</tr>
					<tr>
						<td style="width: 120px;"><h5>성별</h5></td>
						<td colspan="2">
							<div class="form-group" style="text-align: center; margin: 0 auto;">
								<div class="btn-group" data-toggle="buttons">
									<label class="btn btn-primary active"> <input
										type="radio" name="userGender" autocomplete="off"
										value="남자">남자
									</label> <label class="btn btn-primary"> <input
										type="radio" name="userGender" autocomplete="off"
										value="여자">여자
									</label>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td style="width: 120px;"><h5>이메일</h5></td>
						<td colspan="2"><input type="email" class="form-control"
							id="userEmail" name="userEmail" maxlength="20" /></td>
					</tr>
					<tr>
						<td style="text-align: right" colspan="3">
							<input class="btn btn-primary" type="submit" value="회원가입"></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>