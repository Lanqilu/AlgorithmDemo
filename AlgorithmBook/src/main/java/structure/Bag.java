package structure;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author lanqilu
 * @date Created in 2020/12/09  00:13
 * @description 背包
 * <p>
 * 背包: 不支持从中删除元素的集合数据类型。
 * 用于收集元素并迭代遍历所有收集到的元素。
 */
public class Bag<Item> implements Iterable<Item> {
    /**
     * beginning of bag
     */
    private Node<Item> first;
    /**
     * number of elements in bag
     */
    private int n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
