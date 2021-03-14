package recursion;

/**
 * @Author Halo
 * @Create 2021-03-12 下午 09:59
 * @Description 八皇后问题
 */
public class EightQueenProblem {

    int queenNumber = 8;
    // 结果数组
    int[] array = new int[queenNumber];
    // 统计结果个数
    static int count=0;
    // 统计
    static int judgeCount = 0;
    /**
     * 将结果数组(皇后摆放的位置)输出
     */
    private void printResult() {
        count++;
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    /**
     * 查看当我们放置第n个皇后,检测该皇后是否和前面已经摆放的皇后冲突(同一列、行、斜线)
     */
    private boolean judge(int n) {
        judgeCount++;

        for (int i = 0; i < n; i++) {
            // 同一列 || 同一斜线(斜率)
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 放置第n个皇后
     */
    private void check(int n) {
        if (n == queenNumber) {
            printResult();
            return;
        }
        // 依次放入皇后并判断是否冲突
        for (int i = 0; i < queenNumber; i++) {
            // 把当前的这个皇后,放到该行的第i列
            array[n] = i;
            // 判断是否冲突
            if (judge(n)) {
                // 开始递归，放n+1个皇后
                check(n + 1);
            }
        }

    }

    public static void main(String[] args) {

        EightQueenProblem eightQueenProblem = new EightQueenProblem();
        eightQueenProblem.check(0);
        System.out.printf("一共有%d种解法\n", count);
        System.out.printf("一共判断了%d次\n", judgeCount);

    }
}
