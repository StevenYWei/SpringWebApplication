<%@include file="/WEB-INF/views/includes/header.jsp"%>

<h1 align="center">This is department page!</h1>
<div align="center">Current User: <strong>${userName}</strong><br></div>

<div align="center">
	<!-- A form to add the department -->
	<strong>Please input new department information:</strong>
	<form action="addDept" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<table>
			<tr>
				<td>Department Name:</td>
				<td><input type="text" name="deptName" value="HR" required="required"/></td>
			</tr>
			<tr>
				<td>Department Email:</td>
				<td><input type="text" name="deptEmail" value="*@antra.net" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="Add Department" /></td>
				<td><input type="reset" name="action" value="Reset" /></td>
			</tr>
		</table>
	</form>
</div>
<div align="center"><a href="getDeptEmpListAtMain">Back to Main Page</a></div>

<!-- Display the department and employee information -->
<div align="center"><h3><strong>Existing Department and Employee</strong></h3></div>
<div align="center">
	<table border="1" class="deptTable">
		<tr>
			<th>Department ID</th>
			<th>Department Name</th>
			<th>Department Email</th>
			<th>Department Employee</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach var="dept" items="${deptList}">
			<tr id="deptRowId_${dept.getDeptId()}">
				<td>${dept.getDeptId()}</td>
				<td id="deptNameId_${dept.getDeptId()}">${dept.getDeptName()}</td>
				<td id="deptEmailId_${dept.getDeptId()}">${dept.getDeptEmail()}</td>
				<td>
					<c:forEach var="emp" items="${dept.getEmployeeList()}">
						${emp.getEmpFirstName()}${emp.getEmpLastName()};
					</c:forEach>
				</td>
				<td><c:if test="${empty dept.getEmployeeList()}">
						<button id="deptDeleteBtnId_${dept.getDeptId()}" type="button" onclick="deleteDept(${dept.getDeptId()})">Delete</button>
					</c:if>
					<c:if test="${!empty dept.getEmployeeList()}">
						<button id="deptDeleteBtnId_${dept.getDeptId()}" type="button" onclick="deleteDept(${dept.getDeptId()})" disabled="disabled">Delete</button>
					</c:if>
				</td>
				<td id="deptUpdateCellId_${dept.getDeptId()}">
					<button type="button" onclick="updateDeptInfo(${dept.getDeptId()})">Update</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@include file="/WEB-INF/views/includes/footer.jsp"%>


