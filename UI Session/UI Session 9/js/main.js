var initialize = function () {
    for (var fieldNumber = 1; fieldNumber <= totalField; fieldNumber++) {
        var inputField = document.getElementById(prefix + fieldNumber);
        inputField.addEventListener('keyup', enterKeyHandler);
    }
};

document.addEventListener('DOMContentLoaded', initialize);

var empId = 1;
var count = 2;
var employeeName;
var message;
var vehicleType;
var formControlClass = 'form-control';
var totalField = 10;
var prefix = 'input-field-';
var namePattern = /^[a-zA-Z]{2,}$/;
var emailPattern = /^[a-zA-Z]+[\.\-\_]?[a-zA-Z]+[0-9]*@[a-zA-Z]+[\.]{1}[a-zA-Z]{1,}$/;
var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
var contactNumberPattern = /^[0-9]{10,15}$/;
var maleGenderId = 'male';
var femaleGenderId = 'female';
var otherGenderId = 'other';
var isEmployeeDetailsValid = false;
var passType = 'daily';
var currencyType = 'USD';
var cyclePassPrice = [5, 100, 500];
var motorcyclePassPrice = [10, 200, 1000];
var fourwheelersPassPrice = [20, 500, 3500];
var currentPassPrice = 0;

var validateField = function (id, pattern) {
    var inputField = document.getElementById(id);
    var valueEntered = inputField.value;
    if (valueEntered.match(pattern) == null) {
        inputField.className = formControlClass + " redBorder";
        return false;
    }
    else {
        inputField.className = formControlClass + " greenBorder";
        return true;
    }
};

var validatePassword = function (id, pattern) {
    var inputField = document.getElementById(id);
    var valueEntered = inputField.value;
    var isValid = false;
    // Password is weak.
    if (valueEntered.length < 8) {
        inputField.className = formControlClass + " redBorder";
        // Password is valid.
    }
    else {
        // Password is normal.
        if (valueEntered.match(pattern) == null) {
            inputField.className = formControlClass + " orangeBorder";
            // Password is strong.
        }
        else {
            inputField.className = formControlClass + " greenBorder";
        }
        isValid = true;
    }
    return isValid;
};

var validateConfirmPassword = function (confirmPasswordFieldId, passwordFieldId) {
    var password = document.getElementById(passwordFieldId);
    var confirmPassword = document.getElementById(confirmPasswordFieldId);
    if (validatePassword(confirmPasswordFieldId, passwordPattern)) {
        var passwordValue = password.value;
        var confirmPasswordValue = confirmPassword.value;
        if (passwordValue == confirmPasswordValue) {
            return true;
        }
        else {
            confirmPassword.className = formControlClass + " redBorder";
        }
    }
    return false;
};

var validateEmployeeDetails = function () {
    isEmployeeDetailsValid = true;
};

var findAndValidateField = function (fieldNumber) {
    var isFieldValid = false;
    switch (fieldNumber) {
        case 1:
            isFieldValid = validateField(prefix + fieldNumber, namePattern);
            break;
        case 2:
            isFieldValid = validateField(prefix + fieldNumber, emailPattern);
            break;
        case 3:
            isFieldValid = validatePassword(prefix + fieldNumber, passwordPattern);
            break;
        case 4:
            isFieldValid = validateConfirmPassword(prefix + fieldNumber, prefix + (fieldNumber - 1));
            break;
        case 5:
            isFieldValid = validateField(prefix + fieldNumber, contactNumberPattern);
            break;
        default:
            console.log("Id mismatch");
    }
    if (fieldNumber >= 6) {
        isFieldValid = true;
    }
    return isFieldValid;
};

var showNextInputField = function () {
    if (count <= totalField) {
        // To get the employee name for message.
        if (count == 2) {
            employeeName = document.getElementById(prefix + (count - 1)).value;
            message = 'Hi ' + employeeName + ', Can I know your ';
        }
        console.log('Count : ' + count);
        // To get the vehicle type.
        if (count == 9) {
            var vehicleTypeField = document.getElementById(prefix + (count - 1));
            vehicleType = vehicleTypeField.options[vehicleTypeField.selectedIndex].value;
            console.log(vehicleType);
        }
        document.getElementById(prefix + (count - 1)).parentElement.style.display = 'none';
        var nextField = document.getElementById(prefix + count).parentElement;
        nextField.style.display = 'block';
        // Getting the name of next field
        var nextFieldNameArray = nextField.id.split('-');
        var nextFieldFullName = '';
        // To get the full field name for e.g. 'confirm' + 'password' will become 'confirm password'.
        for (var index = 1; index < nextFieldNameArray.length; index++) {
            nextFieldFullName += nextFieldNameArray[index] + ' ';
        }
        // Setting the message in the paragraph tag before field.
        nextField.children[0].innerHTML = message + nextFieldFullName;
        count++;
    }
};

var enterKeyHandler = function (event) {
    console.log("key pressed");
    var target = event.currentTarget;
    var char = event.char || event.charCode || event.which;
    if (findAndValidateField((count - 1))) {
        if (char == 13) {
            console.log('Enter Clicked...');
            showNextInputField();
        }
    }
};

var switchForm = function (currentFormId, nextFormId) {
    console.log(isEmployeeDetailsValid);
    if (isEmployeeDetailsValid) {
        document.getElementById(nextFormId).style.display = 'block';
        document.getElementById(currentFormId).style.display = 'none';
        document.getElementById('empId').innerHTML = 'You have successfully registered with employee id : ' + empId;
        empId++;
        count++;
    }
};

var showPassInfo = function () {
    document.getElementById('vehicle-form').style.display = 'none';
    document.getElementById(vehicleType).style.display = 'block';
    currentPassPrice = getPassPrice();
};

var getPassPrice = function () {
    var passPrice = 0;
    if (passType == 'daily') {
        if (vehicleType == 'cycle') {
            passPrice = cyclePassPrice[0];
        }
        else if (vehicleType == 'motorcycle') {
            passPrice = motorcyclePassPrice[0];
        }
        else if (vehicleType == 'fourwheelers') {
            passPrice = fourwheelersPassPrice[0];
        }
    }
    else if (passType == 'monthly') {
        if (vehicleType == 'cycle') {
            passPrice = cyclePassPrice[1];
        }
        else if (vehicleType == 'motorcycle') {
            passPrice = motorcyclePassPrice[1];
        }
        else if (vehicleType == 'fourwheelers') {
            passPrice = fourwheelersPassPrice[1];
        }
    }
    else if (passType == 'yearly') {
        if (vehicleType == 'cycle') {
            passPrice = cyclePassPrice[2];
        }
        else if (vehicleType == 'motorcycle') {
            passPrice = motorcyclePassPrice[2];
        }
        else if (vehicleType == 'fourwheelers') {
            passPrice = fourwheelersPassPrice[2];
        }
    }
    return passPrice;
};

var updatePrice = function (passTypeField, passPriceId, passDurationId) {
    passType = passTypeField.options[passTypeField.selectedIndex].value;
    console.log(passType);
    var passPriceView = document.getElementById(passPriceId);
    var passDurationView = document.getElementById(passDurationId);
    currentPassPrice = getPassPrice();
    passPriceView.children[0].innerHTML = Math.round(convertCurrency()).toString();
    if (currencyType == 'YEN') {
        passPriceView.children[1].innerHTML = '&#165;';
    }
    else if (currencyType == 'INR') {
        passPriceView.children[1].innerHTML = '&#8377;';
    }
    else {
        passPriceView.children[1].innerHTML = '&#36;';
    }
    if (passType == 'daily') {
        passDurationView.innerHTML = '/day';
    }
    else if (passType == 'monthly') {
        passDurationView.innerHTML = '/month';
    }
    else if (passType == 'yearly') {
        passDurationView.innerHTML = '/year';
    }
    else {
        passDurationView.innerHTML = '';
    }
};

var convertCurrency = function () {
    if (currencyType == 'USD') {
        return currentPassPrice;
    }
    else if (currencyType == 'INR') {
        return currentPassPrice * 73.96;
    }
    else if (currencyType == 'YEN') {
        return currentPassPrice * 107.94;
    }
    else {
        return 0;
    }
};

var updateCurrency = function (currencyTypeField, passPriceId, passDurationId) {
    currencyType = currencyTypeField.options[currencyTypeField.selectedIndex].value;
    var passPriceView = document.getElementById(passPriceId);
    passPriceView.children[0].innerHTML = Math.round(convertCurrency()).toString();
    if (currencyType == 'YEN') {
        // YEN Symbol.
        passPriceView.children[1].innerHTML = '&#165;';
    }
    else if (currencyType == 'INR') {
        // INR Symbol.
        passPriceView.children[1].innerHTML = '&#8377;';
    }
    else {
        // Dollar Symbol.
        passPriceView.children[1].innerHTML = '&#36;';
    }
};
