<%@include file="/WEB-INF/views/includes/header.jsp"%>

<h1 align="center">Welcome ${principal.username} !</h1>

<div align="center">
	<h3>This is the main page!</h3>
	<br> Please choose from the below link:<br>
</div>
<div align="center">
	<!-- Department Link -->
	<a href="departmentPage">Department</a>
	<!-- Employee Link -->
	<a href="employeePage">Employee</a>
</div>

<div align="center"><a href="logout">Logout</a></div>

<div align="center">
	<h3>
		<strong>Existing Department</strong>
	</h3>
</div>


<div align="center">
	<table border="1" class="deptTable">
		<tr>
			<th>Department ID</th>
			<th>Department Name</th>
		</tr>
		<c:forEach var="dept" items="${deptList}">
			<tr onclick="showDeptDetail(${dept.getDeptId()})"
				id="deptId_${dept.getDeptId()}">
				<td>${dept.getDeptId()}</td>
				<td>${dept.getDeptName()}</td>
			</tr>
			<tr>
				<td colspan="2">
					<table class="empTable" hidden="true" border="1" id="hiddenRowId_${dept.getDeptId()}">
						<thead><tr><th>Employee ID</th><th>Employee Firstname</th><th>Employee Lastname</th><th>Employee Age</th></tr></thead>
						<tbody id="deptEmpId_${dept.getDeptId()}"></tbody>
					</table>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>








