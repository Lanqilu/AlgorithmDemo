package cases;

import edu.princeton.cs.algs4.Bag;

/**
 * @author lanqilu
 * @date Created in 2020/11/14  22:41
 * @description 背包典型案例
 * 
 * 背包用于收集元素并迭代遍历的元素
 */
public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        numbers.add(100.0);
        numbers.add(99.0);
        numbers.add(101.0);
        numbers.add(120.0);
        numbers.add(98.0);
        numbers.add(107.0);
        numbers.add(109.0);
        numbers.add(81.0);
        numbers.add(101.0);
        numbers.add(90.0);
        
        int n = numbers.size();
        
        double sum = 0.0;
        
        for (double x : numbers) {
            sum += x;
        }
        double mean = sum/n;
        
        sum = 0.0;
        for (double x : numbers) {
            
        }
    
    
    }
}
