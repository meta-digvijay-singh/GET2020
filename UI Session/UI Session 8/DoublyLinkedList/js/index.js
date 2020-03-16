function Node(previousNode, item, nextNode) {
    this.previousNode = previousNode;
    this.item = item;
    this.nextNode = nextNode;
}

function DoublyLinkedList() {
    let length = 0;
    let head = null;

    this.addItemAtEnd = function(item) {
        if (head == null) {
            head = new Node(null, item, null);
            head.previousNode = head;
        } else {
            let iterator = head;
            while(iterator.nextNode != null) {
                iterator = iterator.nextNode;
            }
            iterator.nextNode = new Node(iterator, item, null); 
        }
        length++;
    }

    this.getLength = function() {
        return length;
    }

    this.traverseList = function() {
        let iterator = head;
        let traversal = '';
        while(iterator != null) {
            traversal += iterator.item;
            if (iterator.nextNode != null) {
                traversal += ' --> ';
            }
            iterator = iterator.nextNode;
        }
        console.log(traversal);
    }

    this.deleteItemFromEnd = function() {
        if (head == null) {
            throw new Error('List is empty.');
        }
        
        let previousNode = null;
        let currentNode = head; 
        
        while (currentNode.nextNode != null) {
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        if (previousNode == null) {
            head = null;
        } else {
            previousNode.nextNode = null;
        }
        length--;
    }
}

let list = new DoublyLinkedList();
list.addItemAtEnd(10);
list.addItemAtEnd(20);
list.deleteItemFromEnd();
list.traverseList();
console.log(list.getLength());
list.addItemAtEnd(20);
list.addItemAtEnd(30);
list.traverseList();
console.log(list.getLength());
