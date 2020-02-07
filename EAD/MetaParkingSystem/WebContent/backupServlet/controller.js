let autoEmpId = 1;
let empId;
let dailyPassPrice;
let monthlyPassPrice;
let yearlyPassPrice;

function validateFullName() {
    let fullName = document.getElementById("fullName").value;
    let namePattern = /(^[A-Za-z]{2,}\s{1}[A-Za-z]{2,})/i;
    return fullName.match(namePattern) != null;
}

function validateEmail() {
    let emailId = document.getElementById("emailId").value;
    let mailPattern = /(^[a-zA-Z]+[_\-\.]?[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]+$)/i;
    return emailId.match(mailPattern) != null;
}

function validatePassword() {
    let password = document.getElementById("password").value;
    let passwordPattern = /(^[a-zA-Z0-9.,!@#$%^&*~]{8,}$)/i;
    return password.match(passwordPattern) != null;
}

function validateMobileNumber() {
    let mobileNumber = document.getElementById("mobileNumber").value;
    let mobileNumberPattern = /^[0-9]{9,15}$/i;
    return mobileNumber.match(mobileNumberPattern) != null;
}

function validateVehicleName() {
    let vehicleNamePattern = /(^[a-zA-Z]{2,}[0-9]*$)/i;
    let vehicleName = document.getElementById("vehicleName").value;
    return vehicleName.match(vehicleNamePattern) != null;
}

function validateVehicleNumber() {
    let vehicleNumberPattern = /(^[a-zA-Z]{2}[a-zA-Z0-9]{4}[0-9]{4}$)/i;
    let vehicleNumber = document.getElementById("vehicleNumber").value;
    return vehicleNumber.match(vehicleNumberPattern) != null;
}

function register() {
    /*let error = "";
    let hasError = false;
    if (!validateFullName()) {
        error += "Name is not valid.\n";
        hasError = true;
    }
    if (!validateEmail()) {
        error += "Email is not valid.\n";
        hasError = true;
    }
    if (!validatePassword()) {
        error += "Password is not valid.\n";
        hasError = true;
    }
    if (!validateMobileNumber()) {
        error += "Mobile number is not valid.\n";
        hasError = true;
    }
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    if (password != confirmPassword) {
        error += "Password and confirm password are not same.";
        hasError = true;
    }
    let gender = document.getElementById("male").checked ? document.getElementById("male").value : document.getElementById("female").value;
    if (gender == null) {

    }
    if (hasError) {
        alert(error);
    } else {
        empId = autoEmpId;
        autoEmpId++;
        document.getElementById("registrationForm").style.display = "none";
        document.getElementById("registrationConfirmation").innerHTML = "Successfully registered Emp Id " + empId;
        document.getElementById("vehicleForm").style.display = "block";
    
    }*/
	
	     
	     
	     var ajaxdata = $("#fullName").val();
	     var value ='name='+ajaxdata;

	     $.ajax({
	     url: "saveIt",
	     type: "post",
	     data: value,
	     cache: false,
	     success: function(data) {
	     $("#fullName").val('');
	     document.getElementById("registrationForm").style.display = "none";
	     document.getElementById("vehicleForm").style.display = "block";
	     $("#registrationConfirmation").html(data).slideDown('slow');
	     }
	     });
	
	
    
}

function showCurrencyUnit(unit) {
    let currencyUnit = document.getElementsByClassName("unit");
    for (var index = 0; index < currencyUnit.length; index++) {
        currencyUnit[index].innerHTML = " " + unit;
    }
}

function showPassesPrice() {
    let error = "";
    let hasError = false;
    if (!validateVehicleName()) {
        error += "Vehicle name is not valid.\n";
        hasError = true;
    }

    if (!validateVehicleNumber()) {
        error += "Vehicle number is not valid.\n";
        hasError = true;
    }
    if (hasError) {
        alert(error);
    } else {
        let typeOfVehicle = document.getElementById("vehicleType");
        let type = typeOfVehicle.options[typeOfVehicle.selectedIndex].text;
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
        //document.getElementById("registrationForm").style.display = "none";
        document.getElementById("registrationConfirmation").style.display = "none";
        document.getElementById("vehicleForm").style.display = "none";
        document.getElementById("currencyForm").style.display = "block";
        document.getElementById("dailyPass").innerHTML = dailyPassPrice;
        document.getElementById("monthlyPass").innerHTML = monthlyPassPrice;
        document.getElementById("yearlyPass").innerHTML = yearlyPassPrice;
        showCurrencyUnit("INR");
    }
}

function convertPrice() {
    let currency = document.getElementById("currencyType");
    let currencyValue = currency.options[currency.selectedIndex].text;
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
