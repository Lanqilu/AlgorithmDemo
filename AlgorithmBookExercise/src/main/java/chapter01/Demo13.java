package chapter01;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  15:25
 * @description 打印出一个 M 行 N 列的二维数组的转置（交换行和列）
 */
public class Demo13 {
    public static void main(String[] args) {
        Demo13 demo13 = new Demo13();
        int[][] a = {
                {3, 2, 4, 9, 0},
                {3, 2, 4, 9, 0},
                {3, 2, 4, 9, 0},
                {3, 2, 4, 9, 0},
        };

        int[][] b = new int[5][4];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[j][i] = a[i][j];
            }
        }

        demo13.out(a);
        System.out.println("***************");
        demo13.out(b);
    }
    public void out(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
