package sparsearray;

/**
 * @author lanqilu
 * 稀疏数组（用于节省空间）
 * @date 2020/2/1  16:26
 **/
public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        int[][] chessArr = new int[11][11];

        //0表示没有棋子,1表示黑子,2表示白子
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;

        //输出原始二维数组
        System.out.println("原始的二维数组");
        for (int[] row : chessArr) {
            for (int date : row) {
                System.out.printf("%d\t", date);
            }
            System.out.println();
        }

        //二维数组转稀疏数组
        //1.遍原始的二维数组，得到有效数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr.length; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        System.out.println();
        System.out.println("sum=" + sum);

        //2.根据sum就创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr.length;
        sparseArr[0][2] = sum;

        //3.遍历二维数组的有效数据数据存入到稀疏数组
        //count用于记录第几个非零数据
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr.length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        //4.输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        //稀疏数组恢复成原始的二维数组

        //1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] reChessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.读取稀疏数组后几行的数据(从第二行开始)，并赋给二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            reChessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出二维数组
        System.out.println("稀疏数组转换后的二维数组");
        for (int[] row : reChessArr) {
            for (int date : row) {
                System.out.printf("%d\t", date);
            }
            System.out.println();
        }

        //TODO:后续优化,将数据保存到本地,并读取

    }

}


