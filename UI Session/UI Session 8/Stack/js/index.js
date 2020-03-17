function Stack() {
    let elements = [];
    let length = 0;

    this.push = function(element) {
        elements.push(element);
        length++;
    }

    this.pop = function() {
        if (elements.length !== 0) {
            length--;
            return elements.pop();
        }
        return null;
    }

    this.getStack = function() {
        return [...elements];
    }

    this.getLength = function() {
        return length;
    }
}

let stack = new Stack();
stack.pop();
stack.push(10);
stack.push(20);
console.log(stack.getStack());
stack.pop();
console.log(stack.getStack());
