package chapter01;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  15:09
 * @description
 */
public class Demo12 {
    public static void main(String[] args) {
        Demo12 demo12 = new Demo12();

        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        demo12.traversal(a);

        for (int i = 0; i < 10; i++) {
            a[i]=a[a[i]];
        }
        demo12.traversal(a);

        for (int i = 0; i < 10; i++) {
            System.out.print(i+", ");
        }
    }

    public void traversal(int[] a){
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print(a[i]+"]");
            }else{
                System.out.print(a[i]+", ");
            }
        }
        System.out.println("\n******************************");
    }
}
