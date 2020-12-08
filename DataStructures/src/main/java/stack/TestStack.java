package stack;

import java.util.Stack;

/**
 * @author lanqilu
 * @version v0.0
 * @package stack
 * @date Created in 2020/07/22  17:41
 * @description 栈的简单实例
 **/
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        //出栈
        while (stack.size() > 0) {
            //将栈顶的数据取出来
            System.out.println(stack.pop());
        }
    }
}
