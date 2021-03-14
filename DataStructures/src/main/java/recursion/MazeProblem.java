package recursion;

/**
 * @Author Halo
 * @Create 2021-03-12 上午 11:42
 * @Description
 */
public class MazeProblem {
    public static void main(String[] args) {
        int[][] map = setMap();
        // 输出地图
        printMap(map);
        // 找路l
        setWay(map, 1, 1);
        printMap(map);

    }

    public static void printMap(int[][] map) {
        System.out.println("地图情况");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] setMap() {
        // 创建二维数组模拟迷宫
        int[][] map = new int[8][7];
        // 使用1表是墙
        // 上下置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 特殊位置的墙
        map[3][2] = 1;
        map[5][2] = 1;
        map[6][2] = 1;

        return map;
    }

    /**
     * 使用递归来给小球找路,到map[6][5]
     * map[i][j] 为0表示没有走过的路
     * map[i][j] 为1表示墙
     * map[i][j] 为2表示通路可以走
     * map[i][j] 为3表示已经走过但走不通
     * 走迷宫的策略 下->右->上->左 ,如果该点走不通再回溯
     *
     * @param map 地图
     * @param i,j 从那个位置开始找(1,1)
     * @return 找到路返回true
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        else {
            if (map[i][j] == 0) {
                // 下->右->上->左
                // 假定该点可以走通
                map[i][j] = 2;
                // 向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                }
                // 向右走
                else if (setWay(map, i, j + 1)) {
                    return true;
                }
                // 向上走
                else if (setWay(map, i - 1, j)) {
                    return true;
                }
                // 向左走
                else if (setWay(map, i, j - 1)) {
                    return true;
                }
                else {
                    // 说明该点是死路
                    map[i][j] = 3;
                    return false;
                }
            }
            else {
                return false;
            }
        }
    }

}
