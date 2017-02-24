
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

function updateEmpInfo(empId) {
	console.log("Show editable employee information with ID " + empId);
	
	$.ajax({
		type: "GET",
		dataType: 'json',
		url: "getEmpDetail",
		data:{"empId":empId},
		success:function(empData) {
			console.log(empData);
			$("#empFirstNameId_" + empId).html("<input id='empFirstNameInputId_" + empId + "' type='text'  autofocus='autofocus' value='"+ empData.empFirstName +"'>");
			$("#empLastNameId_" + empId).html("<input id='empLastNameInputId_" + empId + "' type='text' value='"+ empData.empLastName +"'>");
			$("#empAgeId_" + empId).html("<input id='empAgeInputId_" + empId + "' type='number'  value='"+ empData.empAge +"'>");
			
			var deptSelection = "<select id='empDeptSelectionID_"+ empId +"'>";
			
			$.ajax({
				type: "GET",
				dataType: 'json',
				url: "getDeptList",
				success:function(deptListData) {
					console.log(deptListData);
					$.each(deptListData, function(no,deptObj) {
						//console.log(deptObj.deptName);
						 
						// check which department is the previously assigned to the employee
						if(empData.department.deptId == deptObj.deptId) {
							// default select the old department
							deptSelection = deptSelection + "<option selected='selected' value='";
						} else {
							deptSelection = deptSelection + "<option value='";
						}
						// add the full opotion
						deptSelection = deptSelection + deptObj.deptId + "'>" + deptObj.deptName + "</option>";
						
					});
					// end the select
					deptSelection = deptSelection + "</select>";
					// assign the select list to the employee department area
					$("#empDeptId_" + empId).html(deptSelection);
				},
				error:function() {
					alert("getDeptList error...");
				}
			});
			
			$("#empUpdateCellId_" + empId).html(
					"<button type='button' onclick='confirmEmpChange(" + empId + ")'>Comfirm Change</button>");
		},
		error:function() {
			alert("Error in deleting...");
		}
	});
}

function confirmEmpChange(empId) {
	console.log("Try to update employee with ID " + empId);
	
	var empFirstName = $("#empFirstNameInputId_" + empId).val();
	var empLastName = $("#empLastNameInputId_" + empId).val();
	var empAge = $("#empAgeInputId_" + empId).val();
	var empDeptSelection = $("#empDeptSelectionID_" + empId ).val();
	console.log("empFirstName:" + empFirstName);
	console.log("empLastName: " + empLastName);
	console.log("empAge: " + empAge);
	console.log("empDeptSelection: " + empDeptSelection);
	
	$.ajax({
		type: "GET",
		dataType: 'json',
		url: "updateEmp",
		data:{
			"empId":empId,
			"empFirstName": empFirstName,
			"empLastName": empLastName,
			"empAge": empAge,
			"deptNo": empDeptSelection
		},
		success:function(empData) {
			// get the current data from each field
			$("#empFirstNameId_" + empId).html(empFirstName);
			$("#empLastNameId_" + empId).html(empLastName);
			$("#empAgeId_" + empId).html(empAge);
			$("#empUpdateCellId_" + empId).html("<button type='button' onclick='updateEmpInfo(" + empId + ")'>Update</button>");
			
			$.ajax({
				type: "GET",
				dataType: 'json',
				url: "getDeptDetail",
				data:{"deptId":empDeptSelection},
				success:function(deptData){
					console.log("Department data: ");
					console.log(deptData);
					$("#empDeptId_" + empId).html(deptData.deptName);
				}
			});
				
		},
		error:function() {
			alert("Error in deleting...");
		}
	});
}

function getDeptByPartialName() {
	var deptName = $("#deptNameSearch").val();
	$.ajax({
		type: "GET",
		dataType: 'json',
		url: "getDeptByPartialName",
		data:{"deptName":deptName},
		success:function(data) {
			console.log(data);
		},
		error: function() {
			alert("getDeptByPartialName failed...");
		}
	});
}

function getGeoIP() {
	var IP = $("#IPInput").val();
	console.log(IP);
	$.ajax({
		type: 'GET',
		url: 'getCountryName',
		data: {"IP":IP},
		success:function(msg) {
			console.log(msg);
			$("#IPInforDisplayArea").html('<strong>' + msg + '</strong>');
		},
		error : function() {
			alert("Get geo ip error...");
		}
		
	});
}