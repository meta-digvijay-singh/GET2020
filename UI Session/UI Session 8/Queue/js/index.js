function Queue() {
    let elements = [];
    let length = 0;

    this.enqueue = function(element) {
        elements.push(element);
        length++;
    }

    this.dequeue = function() {
        if (elements.length !== 0) {
            length--;
            return elements.shift();
        }
        return null;
    }

    this.getQueue = function() {
        return [...elements];
    }

    this.getLength = function() {
        return length;
    }
}

let queue = new Queue();
queue.enqueue(10);
queue.enqueue(10);
queue.enqueue(30);
queue.enqueue(20);
console.log(queue.getQueue());
queue.dequeue();
queue.dequeue();
console.log(queue.getQueue());