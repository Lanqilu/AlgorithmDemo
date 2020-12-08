package demo;

/**
 * @author lanqilu
 * @version v0.0
 * @package demo
 * @date Created in 2020/07/21  17:21
 * @description 实际编程中遇到的问题
 **/
public class Replace {
    public static void main(String[] args) {
        String str = "Java,Java,Hello,World!";
        String newStr = str.replaceAll("Java", "Halo");
        System.out.println("newStr = " + newStr);
        //newStr = Halo,Halo,Hello,World!

        /*
        问：试写出用单链表表示的字符串类及字符丰结点类的定义，
        并依次实现它的构造函数、以及计算串长度、串赋值、
        判断两串相等求子串、两串连接、求子串在串中位置等7个成员函数。
         */
    }
}
