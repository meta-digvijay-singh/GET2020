package stackimpl;

import pojo.Node;
import stack.Stack;

public class StackImpl implements Stack {
    private Node top;
    private int length;
    
    public StackImpl() {
        this.top = null;
        this.length = 0;
    }

    @Override
    public void push(String value) {
        if (top == null) {
            top = new Node(value, null);
        } else {
            Node newNode = new Node(value, top);
            top = newNode;
        }
        length++;
    }

    @Override
    public String pop() {
        String value = null;
        if (top != null) {
            value = top.item;
            top = top.next;
            length--;
        }
        return value;
    }

    @Override
    public String peek() {
        if (top == null) {
            return null;
        } else {
            return top.item;
        }
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public int getLength() {
        return length;
    }
    
}
