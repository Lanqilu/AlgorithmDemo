package complexity;

/**
 * @author lanqilu
 * @date Created in 2020/09/11  23:00
 * @description 往数组中插入数据的功能
 */
public class Demo07 {
    public static void main(String[] args) {
        insert(1);
        insert(2);
        insert(3);
        insert(4);
    }

    static int n = 3;
    static int[] array = new int[n];
    static int count = 0;

    private static void insert(int val) {
        if (count == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; ++i) {
                sum = sum + array[i];
            }
            array[0] = sum;
            count = 1;
        }

        array[count] = val;
        ++count;

        System.out.print("[");
        for (int x:array){
            System.out.print(x+",");
        }
        System.out.println("]");
        System.out.println();
    }
}
