package structure;

/**
 * @author lanqilu
 * @date Created in 2020/12/09  00:29
 * @description 使用背包类
 */
class BagDemo {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        int[] items = {100, 99, 101, 120, 98, 107, 109, 81, 101, 90};

        // 添加元素到背包
        for (int item : items) {
            numbers.add((double) item);
        }
        // 返回背包的大小
        int n = numbers.size();

        // 求平均数
        double sum = 0.0;
        for (Double number : numbers) {
            sum += number;
        }
        double mean = sum / n;

        // 求标准差
        sum = 0.0;
        for (Double number : numbers) {
            sum += (number - mean) * (number - mean);
        }
        double std = Math.sqrt(sum / (n - 1));

        // 输出
        System.out.printf("平均数: %.2f\n", mean);
        System.out.printf("标准差: %.2f\n", std);
    }
}
