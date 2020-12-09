package structure;


/**
 * @author lanqilu
 * @date Created in 2020/12/09  23:03
 * @description
 */
class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> integers = new Queue<>();
        int[] items = {100, 99, 101, 120, 98, 107, 109, 81, 101, 90};

        // 向队列中添加元素
        for (int item : items) {
            integers.enqueue(item);
        }

        // 返回队列的大小
        int size = integers.size();
        System.out.println("队列大小为：" + size);

        // 出队列到新数组中
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i] = integers.dequeue();
        }

        // 输出新数组
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
}
