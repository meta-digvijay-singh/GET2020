let initialize = (): void => {
    for (let fieldNumber: number = 1; fieldNumber <= totalField; fieldNumber++) {
        let inputField = (<HTMLInputElement>document.getElementById(prefix + fieldNumber));
        inputField.addEventListener('keyup', enterKeyHandler);
    }
};

document.addEventListener('DOMContentLoaded', initialize);

let empId: number = 1;
let count: number = 2;
let employeeName: string;
let message: string;
let vehicleType: string;
const formControlClass: string = 'form-control';
const totalField: number = 10;
const prefix: string = 'input-field-';
const namePattern: RegExp = /^[a-zA-Z]{2,}$/;
const emailPattern: RegExp = /^[a-zA-Z]+[\.\-\_]?[a-zA-Z]+[0-9]*@[a-zA-Z]+[\.]{1}[a-zA-Z]{1,}$/;
const passwordPattern: RegExp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})/;
const contactNumberPattern: RegExp = /^[0-9]{10,15}$/;
const maleGenderId: string = 'male';
const femaleGenderId: string = 'female';
const otherGenderId: string = 'other';
let isEmployeeDetailsValid: boolean = false;
let passType: string = 'daily';
let currencyType: string = 'USD';
const cyclePassPrice: number[] = [5, 100, 500];
const motorcyclePassPrice: number[] = [10, 200, 1000];
const fourwheelersPassPrice: number[] = [20, 500, 3500];
let currentPassPrice: number = 0;

let validateField = (id: string, pattern: RegExp): boolean => {
    let inputField = (<HTMLInputElement>document.getElementById(id));
    let valueEntered: string = inputField.value;
    if (valueEntered.match(pattern) == null) {
        inputField.className = `${formControlClass} redBorder`;
        return false;
    } else {
        inputField.className = `${formControlClass} greenBorder`;
        return true;
    }
}

let validatePassword = (id: string, pattern: RegExp): boolean => {
    let inputField = <HTMLInputElement>document.getElementById(id);
    let valueEntered: string = inputField.value;
    let isValid: boolean = false;
    // Password is weak.
    if (valueEntered.length < 8) {
        inputField.className = `${formControlClass} redBorder`;
    // Password is valid.
    } else {
        // Password is normal.
        if (valueEntered.match(pattern) == null) {
            inputField.className = `${formControlClass} orangeBorder`;
        // Password is strong.
        } else {
            inputField.className = `${formControlClass} greenBorder`;
        }
        isValid = true;
    }
    return isValid;
}

let validateConfirmPassword = (confirmPasswordFieldId: string, passwordFieldId: string): boolean => {
    let password: HTMLInputElement = <HTMLInputElement> document.getElementById(passwordFieldId);
    let confirmPassword: HTMLInputElement = <HTMLInputElement> document.getElementById(confirmPasswordFieldId);
    if (validatePassword(confirmPasswordFieldId, passwordPattern)) {
        let passwordValue: string = password.value;
        let confirmPasswordValue: string = confirmPassword.value;
        if (passwordValue == confirmPasswordValue) {
            return true;
        } else {
            confirmPassword.className = `${formControlClass} redBorder`;
        }
    }
    return false;
}

let validateEmployeeDetails = (): void => {
    isEmployeeDetailsValid = true;
}

let findAndValidateField = (fieldNumber: number): boolean => {
    let isFieldValid: boolean = false;
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

let showNextInputField = (): void => {
    if (count <= totalField) {
        // To get the employee name for message.
        if (count == 2) {
            employeeName = (<HTMLInputElement>document.getElementById(prefix + (count-1))).value;
            message = 'Hi ' + employeeName + ', Can I know your ';
        }
        console.log('Count : ' + count);
        // To get the vehicle type.
        if (count == 9) {
            let vehicleTypeField: HTMLSelectElement = <HTMLSelectElement>document.getElementById(prefix + (count - 1));
            vehicleType = vehicleTypeField.options[vehicleTypeField.selectedIndex].value;
            console.log(vehicleType);
        }
        document.getElementById(prefix + (count-1)).parentElement.style.display = 'none';
        let nextField: HTMLElement = document.getElementById(prefix + count).parentElement;
        nextField.style.display = 'block';
        // Getting the name of next field
        let nextFieldNameArray: string[] = nextField.id.split('-');
        let nextFieldFullName: string = '';

        // To get the full field name for e.g. 'confirm' + 'password' will become 'confirm password'.
        for (let index: number = 1; index < nextFieldNameArray.length; index++) {
            nextFieldFullName += nextFieldNameArray[index] + ' ';
        }
        // Setting the message in the paragraph tag before field.
        nextField.children[0].innerHTML = message + nextFieldFullName;
        count++;
    }
}

let enterKeyHandler = (event): void => {
    console.log("key pressed");
    let target: HTMLElement = event.currentTarget;
    let char: number = event.char || event.charCode || event.which;
    if (findAndValidateField((count-1))) {
        if (char == 13) {
            console.log('Enter Clicked...');
            showNextInputField();
        }
    }
}

let switchForm = (currentFormId: string, nextFormId: string): void => {
    console.log(isEmployeeDetailsValid);
    if (isEmployeeDetailsValid) {
        document.getElementById(nextFormId).style.display = 'block';
        document.getElementById(currentFormId).style.display = 'none';
        document.getElementById('empId').innerHTML = 'You have successfully registered with employee id : ' + empId;
        empId++;
        count++;
    }
}

let showPassInfo = (): void => {
    document.getElementById('vehicle-form').style.display = 'none';
    document.getElementById(vehicleType).style.display = 'block';
    currentPassPrice = getPassPrice();
}

let getPassPrice = (): number => {
    let passPrice: number = 0;
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

let updatePrice = (passTypeField: HTMLSelectElement, passPriceId: string, passDurationId: string) => {
    passType = passTypeField.options[passTypeField.selectedIndex].value;
    console.log(passType);
    let passPriceView: HTMLElement = document.getElementById(passPriceId);
    let passDurationView: HTMLElement = document.getElementById(passDurationId);
    currentPassPrice = getPassPrice();
    
    passPriceView.children[0].innerHTML = Math.round(convertCurrency()).toString();
    
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

let convertCurrency = (): number => {
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

let updateCurrency = (currencyTypeField: HTMLSelectElement, passPriceId: string, passDurationId: string) => {
    currencyType = currencyTypeField.options[currencyTypeField.selectedIndex].value;
    let passPriceView = document.getElementById(passPriceId);
    passPriceView.children[0].innerHTML = Math.round(convertCurrency()).toString();
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
