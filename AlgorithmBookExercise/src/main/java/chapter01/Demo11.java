package chapter01;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  14:55
 * @description 打印二维数组
 */
public class Demo11 {
    public static void main(String[] args) {
        boolean[][] a = {
                {true, false, true},
                {false, true, true},
                {false, false, true},
                {false, false, true},
        };
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print("行号："+(i+1)+"\t");
                System.out.print("列号："+(j+1)+"\t");
                System.out.print("值:"+a[i][j]+"\t");
                if (a[i][j] == true) {
                    System.out.println("*");
                }else {
                    System.out.println(" ");
                }
            }
        }

    }
}
