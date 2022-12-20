
function addNewTask(destination) {
  var xhttp = new XMLHttpRequest();
  
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        document.getElementById(destination).innerHTML = this.responseText;
    }
  };
  
  var _taskName = document.getElementById("taskName").value;
  var _taskContent = document.getElementById("taskContent").value;
  
  xhttp.open("PUT", "kanban?taskName=" + _taskName + "&taskContent=" + _taskContent, true);
  xhttp.send();
}

function removeTask(taskName, destination) {
  var xhttp = new XMLHttpRequest();
  
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        document.getElementById(destination).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("GET", "kanban?taskName=" + taskName + "&destination=" + destination, true);
  xhttp.send();
}

function insertTask(taskName, destination) {
  var xhttp = new XMLHttpRequest();
  
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        document.getElementById(destination).innerHTML = this.responseText;
    }
  };
  
  xhttp.open("POST", "kanban?taskName=" + taskName + "&destination=" + destination, true);
  xhttp.send();
}
