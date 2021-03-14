package stack;

/**
 * @Author Halo
 * @Create 2021-03-10 下午 08:53
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int check = stack.check();
        System.out.println(check);

    }
}
