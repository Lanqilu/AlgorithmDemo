package api;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;


/**
 * @author lanqilu
 * @date Created in 2020/08/08  10:26
 * @description 随机数静态方法库的API
 */
public class StaRandomTest {
    @Test
    public void uniformTest() {
        //返回[0,N-1)之间的整数
        double random = StdRandom.uniform(0, 2);
        System.out.println(random);
    }

    @Test
    public void bernoulliTest() {
        //返回真的概率为p
        boolean bernoulli = StdRandom.bernoulli(0.9);
        System.out.println(bernoulli);
    }

    @Test
    public void gaussianTest() {
        //正态分布,期望为m，标准差为s
        double gaussian = StdRandom.gaussian();
        System.out.println(gaussian);
    }

    @Test
    public void shuffleTest() {
        // 随机将double数组中的元素排序
        double[] a = {1, 2, 3, 4, 5};
        StdRandom.shuffle(a);
        for (double i : a) {
            System.out.print(i + ",");
        }
    }

}
