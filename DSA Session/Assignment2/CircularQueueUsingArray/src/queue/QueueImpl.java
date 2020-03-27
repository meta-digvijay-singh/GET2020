package queue;

public class QueueImpl implements Queue {

    int[] elements;
    int front;
    int rear;
    int maxSize;
    
    public QueueImpl(int length) {
        this.maxSize = length;
        this.elements = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }
    
    @Override
    public void insert(int value) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if ((front == -1) && (rear == -1)) {
                front = rear = 0;
            } else if (rear == (maxSize - 1)) {
                rear = 0;
            } else {
                rear++;
            }
            elements[rear] = value;
        }
    }

    @Override
    public int delete() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty.");
        } else {
            int elementDeleted = elements[front];
            if (front == rear) {
                front = rear = -1;
            } else if (front == (maxSize - 1)) {
                front = 0;
            } else {
                front++;
            }
            return elementDeleted;
        }
    }

    @Override
    public boolean isEmpty() {
        return (front == -1);
    }

    @Override
    public boolean isFull() {
        return ((front == 0) && (rear == (maxSize - 1)) 
                || ((rear + 1) == front));
    }

    private void traverseQueue(int startPosition, int endPosition) {
        for (int index = startPosition; index <= endPosition; index++) {
            System.out.println(elements[index]);
        }
    }
    
    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            if (front > rear) {
                traverseQueue(front, maxSize - 1);
                int startPosition = 0;
                traverseQueue(startPosition, rear);
            } else {
                traverseQueue(front, rear);
            }
        }
    }
}
