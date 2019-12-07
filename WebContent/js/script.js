    function validation() {
    var a = document.forms["form"]["title"].value;                            
	if(a=="") {
		alert("Title is Required.");
		return false;
	}
	  
	if ((a.length < 2) || (a.length > 30)) {
        alert("Title should have 2 to 65 characters.");
        return false;
    }
	  
    var b = document.forms["form"]["Gross($)"].value;
    if(b=="") {
        alert("Gross is Required.");
        return false;
    }
    
    var c = document.forms["form"]["dateOfLaunch"].value;
    if(c=="") {
        alert("Date of Launch is required.");
        return false;
    }
    var d = document.forms["form"]["Category"].value;
    if(d=="") {
        alert("Category is required.");
        return false;
    }
    }
	 
	 
	 