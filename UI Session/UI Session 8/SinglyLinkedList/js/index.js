function Node(item, node) {
    this.item = item;
    this.next = node;
}

function SinglyLinkedList() {
    let length = 0;
    let head = null;

    this.addItemAtEnd = function(item) {
        if (head == null) {
            head = new Node(item, null);
        } else {
            let iterator = head;
            while(iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = new Node(item, null); 
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
            if (iterator.next != null) {
                traversal += ' --> ';
            }
            iterator = iterator.next;
        }
        console.log(traversal);
    }

    this.deleteItemFromEnd = function() {
        if (head == null) {
            throw new Error('List is empty.');
        }
        
        let previousNode = null;
        let currentNode = head; 
        
        while (currentNode.next != null) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (previousNode == null) {
            head = null;
        } else {
            previousNode.next = null;
        }
        length--;
    }
}

let list = new SinglyLinkedList();
list.addItemAtEnd(10);
list.deleteItemFromEnd();
list.traverseList();
list.addItemAtEnd(20);
list.addItemAtEnd(30);
list.traverseList();
console.log(list.getLength());
