package stack;

import java.util.Scanner;

/**
 * @Author Halo
 * @Create 2021-03-10 下午 04:24
 * @Description 利用数组来模拟栈
 */
class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop ");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.print("number: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("pop number: " + res);
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

/**
 * 表示栈结构
 */
class ArrayStack {
    /**
     * 栈的大小
     */
    private int maxSize;
    /**
     * 数组来模拟栈,数据就放到数组中
     */
    private int[] stack;
    /**
     * top表示栈顶,初始化为-1
     */
    private int top = -1;

    /**
     * 构造器
     *
     * @param maxSize 设置栈的大小
     */
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断栈是否满
     *
     * @return true 表示栈满，false 表示栈未满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 判断是否为空
     *
     * @return true 表示栈空，false 表示栈未空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈操作
     * @param value 传入需要入栈的值
     * @return ture 表示入栈成功，false 表示入栈失败
     */
    public boolean push(int value) {
        // 前判断栈是否为空
        if(isFull()){
            return false;
        };
        top++;
        stack[top] = value;
        return true;
    }

    /**
     * 出栈,将栈顶的数据返回
     * @return 栈顶的值
     */
    public int pop() {
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历栈，从栈顶开始显示数据
     */
    public void list() {
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("栈空");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    /**
     * 用于查看当前栈顶的值
     *
     * @return 当前栈顶的值
     */
    public int check() {
        return stack[top];
    }

}