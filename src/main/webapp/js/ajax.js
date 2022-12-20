
function addNewTask(destination) {
  var xhttp = new XMLHttpRequest();
  
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        document.getElementById(destination).innerHTML = this.responseText;
    }
  };
  
  var _taskName = document.getElementById("taskName").value;
  var _taskContent = document.getElementById("taskContent").value;
  
  xhttp.open("POST", "kanban?taskName=" + _taskName + "&taskContent=" + _taskContent, true);
  xhttp.send();
}

function removeTask(taskName, columnID) {
  var xhttp = new XMLHttpRequest();
  
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        document.getElementById(columnID).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("DELETE", "kanban?taskName=" + taskName + "&columnID=" + columnID, true);
  xhttp.send();
}
