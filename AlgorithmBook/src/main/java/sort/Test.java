package sort;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  16:53
 * @description
 */
public class Test {
    public static void main(String[] args) {
        String fileName = ".\\tiny.txt";
        try{
            FileInputStream input = new FileInputStream(fileName);
            System.setIn(input);
            System.out.println(input);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
