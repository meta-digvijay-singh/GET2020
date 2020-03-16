function replaceConsecutiveChar(string, index, consecutiveCharCount) {
    if (index + consecutiveCharCount <= string.length) {
        return string.substr(0, index) + string.substr(index + consecutiveCharCount);    
    }
    return string;
}

function removeDuplicateConsecutiveLetters(string) {
    let position = 0;
    let isConsecutiveCharSame = false;
    while (position < string.length) {
        if (string.length > 1) {
            if (string.charAt(position) === string.charAt(position + 1)) {
                string = replaceConsecutiveChar(string, position, 2);
                isConsecutiveCharSame = true;
            }
        } 
        if (isConsecutiveCharSame) {
            position = 0;
            isConsecutiveCharSame = false;
        } else {
            position++;
        }
    }
    return string;
} 

console.log(removeDuplicateConsecutiveLetters('aaaabbbccb'));
