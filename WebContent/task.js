
function checkInsertInfo(){
	var mytask = document.getElementById("mytask");
	var form = document.getElementById("insertForm");
	var deadline = document.getElementById("currentDate");
	
	if(deadline.value == ""){
		alert("마감일의 올바른 형식을 지켜주세요. Ex. 1995-05-28");
		return;
	}
	var taskString = mytask.value;
	if(taskString.charAt(0) == " "){
		alert("Task의 시작은 공백을 입력할 수 없습니다.");
		return;
	}
	
	var temp = new Date().toISOString().slice(0, 10);
	var currDate = temp.split("-");
	var currYear = parseInt(currDate[0]);
	var currMonth = parseInt(currDate[1]);
	var currDay = parseInt(currDate[2]);
	
	var inputDeadline = deadline.value;
	var idx = inputDeadline.split("-");
	var inputYear = parseInt(idx[0]);
	var inputMonth = parseInt(idx[1]);
	var inputDay = parseInt(idx[2]);
	var maxYear = 2040;
	
	if(taskString == ""){
		alert("텍스트를 입력해주세요.");
		return;
	}
	if(inputYear < currYear || inputMonth < currMonth || inputDay < currDay){
		alert("마감일을 금일 이후로 부탁드립니다.");
		return;
	}
	if(maxYear < inputYear){
		alert("년도를 2040년보다 작게 설정하세요.");
		return;
	}
	form.action = "insertTask.do";
	form.submit();
}

function insertItemInit(){
	var task = document.getElementById("mytask");
	var date = document.getElementById("currentDate");
	var form = document.getElementById("insertForm");
	task.value = "";
	date.value = new Date().toISOString().slice(0,10);
	date.min = new Date().toISOString().slice(0,10);
	form.action="";
}

function initDate(frm){
	frm.todoDate.min = new Date.toISOString().slice(0, 10);
	frm.todoDate.max = 2040 + "-" + 12 + "-" + 31;
}

function checkUpdate(frm){
	var temp = new Date().toISOString().slice(0, 10);
	var datSplit = temp.split("-");
	var currYear = parseInt(datSplit[0]);
	var currMonth = parseInt(datSplit[1]);
	var currDay = parseInt(datSplit[2]);
	
	if(frm.todoDate.value == ""){
		alert("마감일의 올바른 형식을 지켜주세요. Ex. 1995-05-28");
		return;
	}
	var taskString = frm.todoTask.value;
	if(taskString.charAt(0) == " "){
		alert("Task의 시작은 공백을 입력할 수 없습니다.");
		return;
	}
	
	temp = frm.todoDate.value;
	var inputDate = temp.split("-");
	var inputYear = parseInt(inputDate[0]);
	var inputMonth = parseInt(inputDate[1]);
	var inputDay = parseInt(inputDate[2]);
	var maxYear = 2040;
	
	if(frm.todoTask.value == ""){
		alert("텍스트를 입력해 주세요.");
		return;
	}
	if(inputYear < currYear || inputMonth < currMonth || inputDay < currDay){
		alert("마감일을 금일 이후로 부탁드립니다.");
		return;
	}
	if(maxYear < inputYear){
		alert("년도를 2040년보다 작게 설정하세요.");
		return;
	}
	frm.action = "updateTodo.do";
	frm.submit();
}

function checkDelete(frm){
	frm.action = "deleteTodo.do";
	frm.submit();
}

function popup(id){
	var url = "modify.jsp?id="+id;
	window.open(url, "modify", "width=360px,height='500px,resizable=0,toolbars=no,scrollbars=no");
}

function deleteSelect(status){
	if(!confirm("삭제 요청을 하시겠습니까?")){
		return;
	}
	deleteForm.status.value = status;
	deleteForm.action = "deleteTodoByStatus.do";
	deleteForm.submit();
}