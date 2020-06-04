package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 03.06.2020
 */

public class SimpleLinkedList<E> implements Iterable<E> {
    private Node head = null;
    private Node tail = null;
    private int idx;
    private int modCount = 0;

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void add(E value) {
        if (head == null) {
            head = new Node(null, value, null);
            tail = head;
        } else {
            Node node = new Node(tail, value, null);
            if (head.next == null) {
                head.next = node;
            }
            tail.next = node;
            tail = node;
        }
        idx++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, idx + 1);
        Node<E> x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.value;
    }

    public void deleteLast() {
        if (head == tail) {
            head = tail.prev;
        }
        tail = tail.prev;
    }

    public SimpleLinkedList() {
        this.idx = -1;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator();
    }

    class SimpleLinkedListIterator implements Iterator<E> {
        private Node curElement;
        private int modCountWhenCreate;

        @Override
        public boolean hasNext() {
            return curElement.next != null;
        }

        @Override
        public E next() {
            if (modCount != modCountWhenCreate) {
                throw new ConcurrentModificationException();
            }
            Node result = curElement;
            if (result == null) {
                throw new NoSuchElementException();
            }
            curElement = curElement.next;
            return (E) result.value;
        }

        public SimpleLinkedListIterator() {
            this.curElement = head;
            this.modCountWhenCreate = modCount;
        }
    }


}
