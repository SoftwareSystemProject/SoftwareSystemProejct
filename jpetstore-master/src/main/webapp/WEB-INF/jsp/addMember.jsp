<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" 
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorate="~{layout/default}">
	<!-- 사용자 정의 title -->
	<th:block layout:fragment="customTitle">
		<title th:text="${title}"></title>
	</th:block>
	<th:block layout:fragment="customContents">
		<form th:action="@{/member/addMember}" method="post" >
			<table border="1">
				<tbody>
					<tr>
						<td>회원아이디</td>
						<td>
							<input type="text" name="user_id">
						</td>
					</tr>
					<tr>
						<td>회원비밀번호</td>
						<td>
							<input type="text" name="password">
						</td>
					</tr>
					<tr>
						<td>회원이름</td>
						<td>
							<input type="text" name="user_name">
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>
							<input type="text" name="email">
						</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td>
							<input type="text" name="phone">
						</td>
					</tr>
					<tr>
						<td>우편번호</td>
						<td>
							<input type="text" name="zip">
						</td>
					</tr>
					<tr>
						<td>상세주소1</td>
						<td>
							<input type="text" name="address1">
						</td>
					</tr>
					<tr>
						<td>상세주소2</td>
						<td>
							<input type="text" name="address2">
						</td>
					</tr>
					<tr>
						<td>성별</td>
						<td>
							<select name="gender" style="width:100%;">
								<option value="1">남성</option>
								<option value="2">여성</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td>
							<input type="text" name="birth">
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button type="submit">회원가입</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</th:block>
</html>