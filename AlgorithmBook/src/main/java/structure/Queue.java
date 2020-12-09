package structure;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author lanqilu
 * @date Created in 2020/12/09  00:45
 * @description 队列
 */
public class Queue<Item> implements Iterable<Item> {
    /**
     * 起始节点
     */
    private Node<Item> first;
    /**
     * 末节点
     */
    private Node<Item> last;
    /**
     * 元素个数
     */
    private int n;

    /**
     * 辅助链表类
     */
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * 初始化队列
     */
    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * @return 如果队列为空则返回true, 否则为false
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * @return 返回队列的大小
     */
    public int size() {
        return n;
    }

    /**
     * 返回最近添加到队列的项
     *
     * @return 返回最近添加到队列的项
     */
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return first.item;
    }

    /**
     * 添加元素(item)到队列当中
     *
     * @param item
     */
    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        n++;
    }

    /**
     * 删除并返回最先添加到队列的项
     *
     * @return 最先添加到队列的项
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    /**
     * @return 返回队列中元素的先后顺序, 用空格分割
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Item item : this) {
            stringBuilder.append(item);
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
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
