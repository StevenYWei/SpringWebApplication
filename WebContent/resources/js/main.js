
function showDeptDetail(deptId){
	var empList = "";
	
	$(document).ready(function() {
		console.log('Console log info');
		$.ajax({
			type: "POST",
			dataType: 'json',
			url: "getDeptDetail",
			data:{"deptId":deptId},
			success:function(data) {
				console.log("Suceess!");
				console.log(data);
				console.log(data.deptId);
				console.log(data.deptName);
				console.log(data.deptEmail);
				console.log(data.employeeList);
				var allEmpLine = "";
				
				$.each(data.employeeList, function(key,emp) {
					var empLine = "";
					$.each(emp, function(no, value) {
						empLine = empLine + "<td>" + value + "</td>";
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

$(".clickable").click(function() {

    $(this).next().hide();

});