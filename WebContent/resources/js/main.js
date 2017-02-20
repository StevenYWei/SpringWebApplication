
function showDeptDetail(deptId){
	
	$(document).ready(function() {
		console.log('Console log info');
		$.ajax({
			type: "GET",
			dataType: 'json',
			url: "getDeptDetail",
			data:{"deptId":deptId},
			success:function(data) {
				// Browser logging for testing.
				console.log("Suceess!");
				console.log(data);
				console.log(data.deptId);
				console.log(data.deptName);
				console.log(data.deptEmail);
				console.log(data.employeeList);
				
				var allEmpLine = "";
				
				$.each(data.employeeList, function(ListKey,emp) {
					var empLine = "";
					$.each(emp, function(empKey, value) {
						if(empKey != "@empId" && empKey != "department") {
							empLine = empLine + "<td>" + value + "</td>";
						}
					});
					allEmpLine = allEmpLine + "<tr>" + empLine + "</tr>";
				});
				$("#deptEmpId_"+ deptId).html(allEmpLine);
				
				if ($("#hiddenRowId_" + deptId).css('display') == 'none') {
					$("#hiddenRowId_" + deptId).show(1000);
				} else {
					$("#hiddenRowId_" + deptId).hide(1500);
				}		
			},
			error:function() {
				alert("Not working")
			}
		});

	});
}

function deleteDept(deptId) {
	console.log("Try to delete department with ID " + deptId);
	
	$.ajax({
		type: "GET",
		dataType: "text",
		url: "deleteDept",
		data:{"deptId":deptId},
		success:function(result) {
			console.log(result);
			if(result == "1") {
				console.log("Successfuly delete...");
				$("#deptRowId_" + deptId).hide(1000);
			} else {
				console.log("Delete fail...");
			}
		},
		error:function() {
			alert("Error in deleting...");
		}
	});
}

function deleteEmp(empId) {
	console.log("Try to delete employee with ID " + empId);
	
	$.ajax({
		type: "GET",
		dataType: "text",
		url: "deleteEmp",
		data:{"empId":empId},
		success:function(result) {
			console.log(result);
			if(result == "1") {
				console.log("Successfuly delete...");
				$("#empRowId_" + empId).hide(1000);
			} else {
				console.log("Delete fail...");
			}
		},
		error:function() {
			alert("Error in deleting...");
		}
	});
}

function updateDeptInfo(deptId) {
	console.log("Show editable department information with ID " + deptId);
	
	$.ajax({
		type: "GET",
		dataType: 'json',
		url: "getDeptDetail",
		data:{"deptId":deptId},
		success:function(deptData) {
			$("#deptNameId_" + deptId).html("<input id='deptNameInputId_" + deptId + "' type='text'  autofocus='autofocus' value='"+ deptData.deptName +"'>");
			$("#deptEmailId_" + deptId).html("<input id='deptEmailInputId_" + deptId + "' type='text' value='"+ deptData.deptEmail +"'>");
			$("#deptUpdateCellId_" + deptId).html("<button type='button' onclick='confirmDeptChange(" + deptId + ")'>Comfirm Change</button>");
		},
		error:function() {
			alert("Error in deleting...");
		}
	});
}

function confirmDeptChange(deptId) {
	console.log("Try to update department with ID " + deptId);
	
	var deptName = $("#deptNameInputId_" + deptId).val();
	var deptEmail = $("#deptEmailInputId_" + deptId).val();
	console.log(deptName);
	console.log(deptEmail);
	
	$.ajax({
		type: "GET",
		dataType: 'json',
		url: "updateDept",
		data:{
			"deptId": deptId,
			"deptName": deptName,
			"deptEmail": deptEmail
		},
		success:function(deptData) {
			$("#deptNameId_" + deptId).html(deptName);
			$("#deptEmailId_" + deptId).html(deptEmail);
			$("#deptUpdateCellId_" + deptId).html("<button type='button' onclick='updateDept(" + deptId + ")'>Update</button>");
		},
		error:function() {
			alert("Error in deleting...");
		}
	});
}