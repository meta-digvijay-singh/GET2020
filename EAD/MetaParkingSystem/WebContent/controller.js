let empId;
let dailyPassPrice;
let monthlyPassPrice;
let yearlyPassPrice;
let isNameValid = false;
let isEmailValid = false;
let isPasswordValid = false;
let isConfirmPasswordValid = false;
let isMobileNumberValid = false;
let isVehicleNameValid = false;
let isVehicleNumberValid = false;

function getValue(elementid) {
    return document.getElementById(elementid).value;
}

function makeVisible(elementId) {
    document.getElementById(elementId).style.visibility = "visible";
}

function makeInvisible(elementId) {
    document.getElementById(elementId).style.visibility = "hidden";
}

function validInputColor(elementId) {
    document.getElementById(elementId).style.borderBottom = "2px solid #2ed573";
}

function invalidInputColor(elementId) {
    document.getElementById(elementId).style.borderBottom = "2px solid #eb3b5a";
}

function validateFullName() {
	console.log("On FULL NAME");
    let fullName = getValue("fullName");
    let namePattern = /(^[A-Za-z]{2,}\s{1}[A-Za-z]{2,})/i;
    if (fullName.match(namePattern) != null) {
        validInputColor("fullName");
        makeInvisible("nameSuggestion");
        isNameValid = true;
    } else {
        invalidInputColor("fullName");
        makeVisible("nameSuggestion");
        isNameValid = false;
    }
}

function validateEmail() {
    let emailId = getValue("emailId");
    let mailPattern = /(^[a-zA-Z]+[_\-\.]?[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]+$)/i;
    if (emailId.match(mailPattern) != null) {
        validInputColor("emailId");
        makeInvisible("emailSuggestion");
        isEmailValid = true;
    } else {
        invalidInputColor("emailId");
        makeVisible("emailSuggestion");
        isEmailValid = false;
    }
}

function validatePassword() {
    let password = getValue("password");
    let passwordPattern = /(^[a-zA-Z0-9.,!@#$%^&*~]{8,}$)/i;
    if (password.match(passwordPattern) != null) {
        validInputColor("password");
        makeInvisible("passwordSuggestion");
        isPasswordValid = true;
    } else {
        invalidInputColor("password");
        makeVisible("passwordSuggestion");
        isPasswordValid = false;
    }
}

function validateConfirmPassword() {
    let password = getValue("password");
    let confirmPassword = document.getElementById("confirmPassword").value;
    if (password == confirmPassword) {
        validInputColor("confirmPassword");
        makeInvisible("confirmPasswordSuggestion");
        isConfirmPasswordValid = true;
    } else {
        invalidInputColor("confirmPassword");
        makeVisible("confirmPasswordSuggestion");
        isConfirmPasswordValid = false;
    }
}

function validateMobileNumber() {
    let mobileNumber = getValue("mobileNumber");
    let mobileNumberPattern = /^[0-9]{9,15}$/i;
    if (mobileNumber.match(mobileNumberPattern) != null) {
        validInputColor("mobileNumber");
        makeInvisible("mobileNumberSuggestion");
        isMobileNumberValid = true;
    } else {
        invalidInputColor("mobileNumber");
        makeVisible("mobileNumberSuggestion");
        isMobileNumberValid = false;
    }
}

function validateVehicleName() {
    let vehicleNamePattern = /(^[a-zA-Z]{2,}[0-9]*$)/i;
    let vehicleName = document.getElementById("vehicleName").value;
    if (vehicleName.match(vehicleNamePattern) != null) {
    	validInputColor("vehicleName");
    	makeInvisible("vehicleNameSuggestion");
    	isVehicleNameValid = true;
    } else {
    	invalidInputColor("vehicleName");
    	makeVisible("vehicleNameSuggestion");
    	isVehicleNameValid = false;
    }
}

function validateVehicleNumber() {
    let vehicleNumberPattern = /(^[a-zA-Z]{2}[a-zA-Z0-9]{4}[0-9]{4}$)/i;
    let vehicleNumber = document.getElementById("vehicleNumber").value;
    if (vehicleNumber.match(vehicleNumberPattern) != null) {
    	validInputColor("vehicleNumber");
    	makeInvisible("vehicleNumberSuggestion");
    	isVehicleNumberValid = true;
    } else {
    	invalidInputColor("vehicleNumber");
    	makeVisible("vehicleNumberSuggestion");
    	isVehicleNumberValid = false;
    }
}

function register() {
    let gender;
    
    if (document.getElementById("male").checked) {
        gender = document.getElementById("male").value;
    } else if (document.getElementById("female").checked) {
        gender = document.getElementById("female").value;
    } else {
        gender = null;
    }

    if (isNameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid && isMobileNumberValid && (gender != null)) {
    	var fullName = $("#fullName").val();
    	var emailId = $("#emailId").val();
    	var password = $("#password").val();
    	var confirmPassword = $("#confirmPassword").val();
    	var mobileNumber = $("#mobileNumber").val();
    	var orgName = document.getElementById("orgName");
    	orgName = orgName.options[orgName.selectedIndex].value; 
        //document.getElementById("showEmpId").innerHTML = "Successfully registered Emp Id " + empId;
	    value = {
	    		"fullName": fullName,
	    		"gender": gender,
	    		"emailId": emailId,
	    		"password": password,
	    		"confirmPassword": confirmPassword,
	    		"mobileNumber": mobileNumber,
	    		"orgName": orgName
	    };
	    $.ajax({
	    url: "sendRegDetails",
	    type: "post",
	    data: value,
	    cache: false,
	    success: function(data) {
	    if (data != "-1") {
	    	document.getElementById("registrationForm").style.display = "none";
		    document.getElementById("vehicleForm").style.display = "block";
		    $("#showEmpId").html("Successfully registered with Employee Id : " + data).slideDown('slow');
		    empId = data.trim();
		    $("#dummyEmpId").val("Employee Id : " + data);
	    } else {
	    	$("#showEmpId").html("Details could not inserted.").slideDown('slow');
	    }
	    
	    },
	    error: function(data) {
	    $("#showEmpId").html(data).slideDown('slow');
	    }
	    });
	    
    } else {
        alert("fill all the entries.");
    }


    
}

function showCurrencyUnit(unit) {
    let currencyUnit = document.getElementsByClassName("unit");
    for (index = 0; index < currencyUnit.length; index++) {
        currencyUnit[index].innerHTML = " " + unit;
    }
}

function showPassesPrice() {
    if (isVehicleNameValid && isVehicleNumberValid) {
    	let typeOfVehicle = document.getElementById("vehicleType");
        let type = typeOfVehicle.options[typeOfVehicle.selectedIndex].value;
    	if (type == "Cycle") {
            dailyPassPrice = 5;
            monthlyPassPrice = 100;
            yearlyPassPrice = 500;
        } else if (type == "MotorCycle") {
            dailyPassPrice = 10;
            monthlyPassPrice = 200;
            yearlyPassPrice = 1000;
        } else {
            dailyPassPrice = 20;
            monthlyPassPrice = 500;
            yearlyPassPrice = 3500;
        }
        var vehicleName = $("#vehicleName").val();
        var vehicleNumber = $("#vehicleNumber").val();
        var vehicleType = type;
        var identification = $("#identification").val();
        
        let vehicleValues = {
        		"vehicleName": vehicleName,
        		"vehicleNumber": vehicleNumber,
        		"vehicleType": vehicleType,
        		"identification": identification,
        		"eid": empId
        };
        
        $.ajax({
    	    url: "sendVehicleDetails",
    	    type: "post",
    	    data: vehicleValues,
    	    cache: false,
    	    success: function(data) {
    	    	document.getElementById("showEmpId").style.display = "none";
    	    	document.getElementById("vehicleForm").style.display = "none";
    		    document.getElementById("currencyForm").style.display = "block";
    		    document.getElementById("dailyPass").innerHTML = dailyPassPrice;
    	        document.getElementById("monthlyPass").innerHTML = monthlyPassPrice;
    	        document.getElementById("yearlyPass").innerHTML = yearlyPassPrice;
    	        showCurrencyUnit("INR");
    	    },
    	    error: function(data) {
    	    $("#showEmpId").html(data).slideDown('slow');
    	    }
    	    });
        
    }
}

function convertPrice() {
    let currency = document.getElementById("currencyType");
    let currencyValue = currency.options[currency.selectedIndex].value;
    let USD_PRICE_INR = 71.24;
    let YEN_PRICE_INR = 0.65;
    let updateDailyPrice = dailyPassPrice;
    let updateMonthlyPrice = monthlyPassPrice;
    let updateYearlyPrice = yearlyPassPrice;
    if (currencyValue == "USD") {
        updateDailyPrice = dailyPassPrice / USD_PRICE_INR;
        updateMonthlyPrice = monthlyPassPrice / USD_PRICE_INR;
        updateYearlyPrice = yearlyPassPrice / USD_PRICE_INR;
    } else if (currencyValue == "YEN") {
        updateDailyPrice = dailyPassPrice / YEN_PRICE_INR;
        updateMonthlyPrice = monthlyPassPrice / YEN_PRICE_INR;
        updateYearlyPrice = yearlyPassPrice / YEN_PRICE_INR;
    } else {
        updateDailyPrice = dailyPassPrice;
        updateMonthlyPrice = monthlyPassPrice;
        updateYearlyPrice = yearlyPassPrice;
    }
    document.getElementById("dailyPass").innerHTML = updateDailyPrice.toFixed(2);
    document.getElementById("monthlyPass").innerHTML = updateMonthlyPrice.toFixed(2);
    document.getElementById("yearlyPass").innerHTML = updateYearlyPrice.toFixed(2);
    showCurrencyUnit(currencyValue);
}

function getPass() {
	let passType;
	let price;
	let USD_PRICE_INR = 71.24;
	if (document.getElementById("dailyPrice").checked) {
		passType = "daily";
		price = dailyPassPrice / USD_PRICE_INR;
		price = price.toFixed(2);
	} else if (document.getElementById("monthlyPrice").checked) {
		passType = "monthly";
		price = monthlyPassPrice / USD_PRICE_INR;
		price = price.toFixed(2);
		
	} else if (document.getElementById("yearlyPrice").checked) {
		passType = "yearly";
		price = yearlyPassPrice / USD_PRICE_INR;
		price = price.toFixed(2);
	} else {
		passType = null;
		price = null;
	}
	if (passType == null || price == null) {
		alert("Please select pass.");
	} else {
		var passValues = {
				"passType": passType,
				"price": price,
				"eid": empId
		};
		$.ajax({
    	    url: "sendPassDetails",
    	    type: "post",
    	    data: passValues,
    	    cache: false,
    	    success: function(data) {
    	    	window.location.replace("login.jsp");
    	    },
    	    error: function(data) {
    	    	
    	    }
    	    });
		
	}
	
}


