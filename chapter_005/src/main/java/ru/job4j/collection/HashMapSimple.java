package ru.job4j.collection;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Chashkov
 * @version 0.0.0.1
 * @project junior
 * @since 25.06.2020
 */
public class HashMapSimple<K, V> implements Iterable<V> {
    private int capacity = 10;
    private Node<K,V>[] table;
    private int occupancy = 0;
    private float loadFactor = 0.75f;
    private int modCount = 0;

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;
        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private void resize() {
        capacity = capacity * 2;
        Node<K,V>[] tableNew = (Node<K,V>[]) new Node[capacity];
        for (int i = 0; i < capacity / 2; i++) {
            Node<K,V> node = table[i];
            if (node != null) {
                do {
                    Node<K,V> newNode = new Node(node.hash, node.key, node.value, null);
                    Node<K, V> oldNode = tableNew[(capacity - 1) & node.hash];
                    if (oldNode == null || node.hash == oldNode.hash) {
                        tableNew[(capacity - 1) & node.hash] = newNode;
                    } else if (node.hash != oldNode.hash) {
                        while (oldNode.next != null)
                            oldNode = oldNode.next;
                        oldNode.next = newNode;
                    }
                    node = node.next;
                } while ((node != null));
            }

        }
        table = tableNew;
    }

    public boolean insert(K key, V value) {
        Node<K,V> node = new Node(hash(key), key, value, null);
        Node<K,V> oldNode = table[(capacity - 1) & node.hash];
        if (oldNode == null || node.hash == oldNode.hash) {
            table[(capacity - 1) & node.hash] = node;
            if (oldNode == null) {
                occupancy++;
                modCount++;
            }
        } else if (node.hash != oldNode.hash) {
            while (oldNode.next != null) {
                oldNode = oldNode.next;
                if (node.hash == oldNode.hash) {
                    Node<K,V> nx = oldNode.next;
                    oldNode = node;
                    oldNode.next = nx;
                    return true;
                }
            }
            oldNode.next = node;
            occupancy++;
            modCount++;
        }

        if (occupancy > capacity * loadFactor) {
            resize();
        }
        return true;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (int)((h - (h % Math.pow(2, 16))) / Math.pow(2, 16));
    }

    public V get(K key) {
        Node<K, V> node = table[(capacity - 1) & hash(key)];
        if (node == null)
            return null;

        do {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        } while ((node != null));
        return null;
    }

    public boolean delete(K key) {
        Node<K, V> node = table[(capacity - 1) & hash(key)];
        if (node != null) {
            do {
                if (node.key.equals(key)) {
                    table[(capacity - 1) & hash(key)] = node.next;
                    occupancy--;
                    return true;
                }
                node = node.next;
            } while (node != null);
        }
        return false;
    }

    @Override
    public Iterator<V> iterator() {
        return new HashMapSimple.HashMapSimpleIterator();
    }

    class HashMapSimpleIterator implements Iterator<V> {
        private int idxEl;
        private int modCountWhenCreate;
        private int idxArr = -1;
        Node<K, V> curNode = null;

        @Override
        public boolean hasNext() {
            return idxEl != occupancy ;
        }

        @Override
        public V next() {
            if (modCount != modCountWhenCreate) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (curNode != null) {
                curNode = curNode.next;
                if (curNode != null) {
                    idxEl++;
                    return curNode.value;
                }
            }
            do {
                idxArr++;
                curNode = table[idxArr];
                if (curNode != null) {
                    idxEl++;
                    return curNode.value;
                }
            } while (table[idxArr] == null && table.length > idxArr);


            return curNode.value;
        }

        public HashMapSimpleIterator() {
            this.idxEl = 0;
            this.modCountWhenCreate = modCount;
        }
    }

    public HashMapSimple() {
        this.table = (Node<K,V>[]) new Node[capacity];
    }
}
