package utils;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  12:19
 * @description
 */
public class Io {
    public static void main(String[] args) {
        ArrayList<Integer> integers = readFileByLines("E:\\Project\\AlgorithmDemo\\AlgorithmBook\\src\\main\\resources\\tinyT.txt");
        for (Integer integer : integers) {
            System.out.print(integer+",");
        }

    }

    public static ArrayList<Integer> readFileByLines(String path) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            File file = new File(path);
            InputStreamReader input = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(input);
            // 按行读取字符串
            String str;
            while ((str = bf.readLine()) != null) {
                arrayList.add(Integer.parseInt(str));
            }
            bf.close();
            input.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
