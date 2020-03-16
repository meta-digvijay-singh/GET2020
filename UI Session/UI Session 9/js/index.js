document.addEventListener('DOMContentLoaded', init);
let empId = 1;
let count = 2;
let name;
let message;
let vehicleType;
const totalField = 10;
const prefix = 'input-field-';
const namePattern = /^[a-zA-Z]{2,}$/;
const emailPattern = /^[a-zA-Z]+[\.\-\_]?[a-zA-Z]+[0-9]*@[a-zA-Z]+[\.]{1}[a-zA-Z]{1,}$/;
const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
const contactNumberPattern = /^[0-9]{10,15}$/;
const maleGenderId = 'male';
const femaleGenderId = 'female';
const otherGenderId = 'other';
let isEmployeeDetailsValid = false;
let passType = 'daily';
let currencyType = 'USD';
let cyclePassPrice = [5, 100, 500];
let motorcyclePassPrice = [10, 200, 1000];
let fourwheelersPassPrice = [20, 500, 3500];
let currentPassPrice = 0;

function init() {
    for (let fieldNumber = 1; fieldNumber <= totalField; fieldNumber++) {
        let inputField = document.getElementById(prefix + fieldNumber);
        inputField.addEventListener('keyup', enterKeyHandler);
    }
}

function validateField(id, pattern) {
    let inputField = document.getElementById(id);
    let valueEntered = inputField.value;
    if (valueEntered.match(pattern) == null) {
        inputField.style.border = '2px solid red';
        return false;
    } else {
        inputField.style.border = '2px solid green';
        return true;
    }
}

function validatePassword(id, pattern) {
    let inputField = document.getElementById(id);
    let valueEntered = inputField.value;
    let isValid = false;
    // Password is weak.
    if (valueEntered.length < 8) {
        inputField.style.border = '2px solid red';
    // Password is valid.
    } else {
        // Password is normal.
        if (valueEntered.match(pattern) == null) {
            inputField.style.border = '2px solid orange';
        // Password is strong.
        } else {
            inputField.style.border = '2px solid green';
        }
        isValid = true;
    }
    return isValid;
}

function validateConfirmPassword(confirmPasswordFieldId, passwordFieldId) {
    let password = document.getElementById(passwordFieldId);
    let confirmPassword = document.getElementById(confirmPasswordFieldId);
    if (validatePassword(confirmPasswordFieldId, passwordPattern)) {
        let passwordValue = password.value;
        let confirmPasswordValue = confirmPassword.value;
        if (passwordValue == confirmPasswordValue) {
            return true;
        } else {
            confirmPassword.style.border = '2px solid red';
        }
    }
    return false;
}

function validateGender() {
    isEmployeeDetailsValid = true;
}

function findAndValidateField(fieldNumber) {
    let isFieldValid = false;
    switch(fieldNumber) {
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
}

function showNextInputField() {
    if (count <= totalField) {
        // To get the name for message.
        if (count == 2) {
            name = document.getElementById(prefix + (count-1)).value;
            message = 'Hi ' + name + ', Can I know your ';
        }
        console.log('Count : ' + count);
        // To get the vehicle type.
        if (count == 9) {
            let vehicleTypeField = document.getElementById(prefix + (count - 1));
            vehicleType = vehicleTypeField.options[vehicleTypeField.selectedIndex].value;
            console.log(vehicleType);
        }
        document.getElementById(prefix + (count-1)).parentElement.style.display = 'none';
        let nextField = document.getElementById(prefix + count).parentElement;
        nextField.style.display = 'block';
        // Getting the name of next field
        let nextFieldNameArray = nextField.id.split('-');
        let nextFieldFullName = '';

        // To get the full field name for e.g. 'confirm' + 'password' will become 'confirm password'.
        for (let index = 1; index < nextFieldNameArray.length; index++) {
            nextFieldFullName += nextFieldNameArray[index] + ' ';
        }
        // Setting the message in the paragraph tag before field.
        nextField.children[0].innerHTML = message + nextFieldFullName;
        count++;
    }
}

function enterKeyHandler(event) {
    console.log("key pressed");
    let target = event.currentTarget;
    let tag = target.tagName;
    let char = event.char || event.charCode || event.which;
    let s = String.fromCharCode(char);
    if (findAndValidateField((count-1))) {
        if (char == 13) {
            console.log('Enter Clicked...');
            showNextInputField();
        }
    }
}

function switchForm(currentFormId, nextFormId) {
    console.log(isEmployeeDetailsValid);
    if (isEmployeeDetailsValid) {
        document.getElementById(nextFormId).style.display = 'block';
        document.getElementById(currentFormId).style.display = 'none';
        document.getElementById('empId').innerHTML = 'You have successfully registered with employee id : ' + empId;
        empId++;
        count++;
    }
}

function showPassInfo() {
    document.getElementById('vehicle-form').style.display = 'none';
    document.getElementById(vehicleType).style.display = 'block';
    currentPassPrice = getPassPrice();
}

function getPassPrice() {
    let passPrice = 0;
    if (passType == 'daily') {
        if (vehicleType == 'cycle') {
            passPrice = cyclePassPrice[0];
        } else if (vehicleType == 'motorcycle') {
            passPrice = motorcyclePassPrice[0];
        } else if (vehicleType == 'fourwheelers') {
            passPrice = fourwheelersPassPrice[0];
        } 
    } else if (passType == 'monthly') {
        if (vehicleType == 'cycle') {
            passPrice = cyclePassPrice[1];
        } else if (vehicleType == 'motorcycle') {
            passPrice = motorcyclePassPrice[1];
        } else if (vehicleType == 'fourwheelers') {
            passPrice = fourwheelersPassPrice[1];
        } 
    } else if (passType == 'yearly') {
        if (vehicleType == 'cycle') {
            passPrice = cyclePassPrice[2];
        } else if (vehicleType == 'motorcycle') {
            passPrice = motorcyclePassPrice[2];
        } else if (vehicleType == 'fourwheelers') {
            passPrice = fourwheelersPassPrice[2];
        } 
    }
    return passPrice;
}

function updatePrice(passTypeField, passPriceId, passDurationId) {
    passType = passTypeField.options[passTypeField.selectedIndex].value;
    console.log(passType);
    let passPriceView = document.getElementById(passPriceId);
    let passDurationView = document.getElementById(passDurationId);
    currentPassPrice = getPassPrice();
    
    passPriceView.children[0].innerHTML = Math.round(convertCurrency());
    
    if (currencyType == 'YEN') {
        passPriceView.children[1].innerHTML = '&#165;';
    } else if (currencyType == 'INR') {
        passPriceView.children[1].innerHTML = '&#8377;';
    } else {
        passPriceView.children[1].innerHTML = '&#36;';
    }

    if (passType == 'daily') {
        passDurationView.innerHTML = '/day';
    } else if (passType == 'monthly') {
        passDurationView.innerHTML = '/month';
    } else if (passType == 'yearly') {
        passDurationView.innerHTML = '/year';
    } else {
        passDurationView.innerHTML = '';
    }    
}

function convertCurrency() {
    if (currencyType == 'USD') {
        return currentPassPrice;
    } else if (currencyType == 'INR') {
        return currentPassPrice * 73.96;
    } else if (currencyType == 'YEN') {
        return currentPassPrice * 107.94;
    } else {
        return 0;
    }
}

function updateCurrency(currencyTypeField, passPriceId, passDurationId) {
    currencyType = currencyTypeField.options[currencyTypeField.selectedIndex].value;
    let passPriceView = document.getElementById(passPriceId);
    passPriceView.children[0].innerHTML = Math.round(convertCurrency());
    if (currencyType == 'YEN') {
        // YEN Symbol.
        passPriceView.children[1].innerHTML = '&#165;';
    } else if (currencyType == 'INR') {
        // INR Symbol.
        passPriceView.children[1].innerHTML = '&#8377;';
    } else {
        // Dollar Symbol.
        passPriceView.children[1].innerHTML = '&#36;';
    }
}
