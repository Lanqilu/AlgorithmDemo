package leetcode_0204;

/**
 * @author lanqilu
 * @date Created in 2020/12/03  22:12
 * @description
 */
class Main {
    public static void main(String[] args) {
        SolutionBySieve solutionBySieve = new SolutionBySieve();
        SolutionByEnum solutionByEnum = new SolutionByEnum();
        SolutionByEuler solutionByEuler = new SolutionByEuler();

        // 开始时间
        long stime1 = System.currentTimeMillis();
        // 执行程序
        System.out.println(solutionByEnum.countPrimes(1000000));
        // 结束时间
        long etime1 = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长: %d 毫秒.", (etime1 - stime1));

        System.out.println();

        // 开始时间
        long stime2 = System.currentTimeMillis();
        // 执行程序
        System.out.println(solutionBySieve.countPrimes(1000000));
        // 结束时间
        long etime2 = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长: %d 毫秒.", (etime2 - stime2));

        System.out.println();

        // 开始时间
        long stime3 = System.currentTimeMillis();
        // 执行程序
        System.out.println(solutionByEuler.countPrimes(1000000));
        // 结束时间
        long etime3 = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长: %d 毫秒.", (etime3 - stime3));
    }
}
