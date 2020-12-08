package complexity;

/**
 * @author lanqilu
 * @date Created in 2020/09/11  23:16
 * @description
 */
public class Demo08 {

    public static void main(String[] args) {
        Demo08 demo08 = new Demo08();
        demo08.add(1);
        demo08.add(2);
        demo08.add(3);
        demo08.add(4);

    }


    int[] array = new int[3];
    int len = 3;
    int i = 0;


    private void add(int element) {
        // 数组空间不够了
        if (i >= len) {
            // 重新申请一个2倍大小的数组空间
            int new_array[] = new int[len * 2];
            // 把原来array数组中的数据依次copy到new_array
            for (int j = 0; j < len; ++j) {
                new_array[j] = array[j];
            }
            // new_array复制给array，array现在大小就是2倍len了
            array = new_array;
            len = 2 * len;
        }
        // 将element放到下标为i的位置，下标i加一
        array[i] = element;
        ++i;

        System.out.print("[");
        for (int x:array){
            System.out.print(x+",");
        }
        System.out.println("]");
        System.out.println();
    }
}
