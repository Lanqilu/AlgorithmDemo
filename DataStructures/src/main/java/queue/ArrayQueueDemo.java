package queue;

import java.util.Scanner;

/**
 * @author lanqilu
 * 数组模拟队列
 * @date ate 2020/2/1  18:05
 **/
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建队列
        ArrayQueue queue = new ArrayQueue(3);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        //loop控制循环
        boolean loop = true;
        //输出菜单界面
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头部数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            //判断
            switch (key) {
                //显示队列
                case 's':
                    queue.showQueue();
                    break;
                //添加数据到队列
                case 'a':
                    System.out.print("请输入一个数:");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                //队列取出数据
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                //查看队列头部数据
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是:%d\n", res);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                //退出程序
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}


/**
 * 数组模拟队列
 **/
class ArrayQueue {
    /**
     * 数组的最大容量
     **/
    private int maxSize;
    /**
     * 指向队列头[不含]
     **/
    private int front;
    /**
     * 指向队列尾部[含]
     **/
    private int rear;
    /**
     * 模拟队列的数组，用于存放数据
     **/
    private int[] arr;

    /**
     * 创建队列的构造器
     **/
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //指向队列头，不包含队列头，队列头的前一个位置
        front = -1;
        //指向队列尾，包含队列尾，队列的最后一个数据
        rear = -1;
    }

    /**
     * 判断队列是否满
     **/
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     **/
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 数据进队列
     **/
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        //rear后移
        rear++;
        arr[rear] = n;
    }

    /**
     * 数据出队列
     **/
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //抛异常而不是返回-1，且不需要return
            throw new RuntimeException("队列为空");
        }
        //front后移
        front++;
        return arr[front];
    }

    /**
     * 显示队列的所有数据
     **/
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空");
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据,不同于取数据
     **/
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];

    }

    //存在问题,不能复用，只能使用一次
    //使用环形队列进行解决,详见CircleArrayQueueDemo.java
}
