package ir.javacup.dq;

import java.util.*;

public class DequeUtilImpl<T> implements DequeUtil<T> {
    private Deque<T> deque = new LinkedList<>();

    @Override
    public Deque<T> getDeque() {
        return deque;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= deque.size())
            throw new IllegalArgumentException("index should be between 0 and size-1");
        int count = 0;
        Iterator<T> iterator;
        for (iterator = deque.iterator(); iterator.hasNext() && count < index; ) {
            iterator.next();
            ++count;
        }
        return iterator.next();
    }

    @Override
    public boolean push(T element, int index) {
        if (index < 0 || index >= deque.size())
            return false;
        Stack<T> stack = new Stack<>();
        while (index > 0) {
            stack.add(deque.removeFirst());
            --index;
        }
        deque.addFirst(element);
        while (!stack.isEmpty()) {
            deque.addFirst(stack.pop());
        }
        return true;
    }

    @Override
    public boolean replace(T element, int index) {
        if (index < 0 || index >= deque.size())
            return false;
        Stack<T> stack = new Stack<>();
        while (index > 0) {
            stack.add(deque.removeFirst());
            --index;
        }
        deque.removeFirst();
        deque.addFirst(element);
        while (!stack.isEmpty()) {
            deque.addFirst(stack.pop());
        }
        return true;
    }

    @Override
    public boolean reverse(int first, int second) {
        if (first < 0 || first >= deque.size()
                || second < 0 || second >= deque.size()
                || first > second)
            return false;
        Stack<T> stack = new Stack<>();
        int index = 0;
        while (index < first) {
            stack.add(deque.removeFirst());
            ++index;
        }
        LinkedList<T> queue = new LinkedList<>();
        while (index <= second) {
            queue.add(deque.removeFirst());
            ++index;
        }
        while (!queue.isEmpty()) {
            deque.addFirst(queue.pop());
        }
        while (!stack.isEmpty()) {
            deque.addFirst(stack.pop());
        }
        return true;
    }
}