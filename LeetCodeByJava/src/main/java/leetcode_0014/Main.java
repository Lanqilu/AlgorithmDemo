package leetcode_0014;

/**
 * @author lanqilu
 * @date Created in 2020/12/06  14:37
 * @description
 */
class Main {
    public static void main(String[] args) {
        SolutionByTransverse solutionByTransverse = new SolutionByTransverse();
        SolutionByCompare solutionByCompare = new SolutionByCompare();


        String[] strings = {"flower", "flow", "flight"};
        System.out.println(solutionByTransverse.longestCommonPrefix(strings));
        System.out.println(solutionByCompare.longestCommonPrefix(strings));

    }
}
