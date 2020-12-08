package leetcode_0001;

/**
 * @author lanqilu
 * @date Created in 2020/12/04  23:48
 * @description
 */

class Main {
    public static void main(String[] args) {
        SolutionByEnum solutionByEnum = new SolutionByEnum();
        SolutionByHash solutionByHash = new SolutionByHash();
        int[] ints = {2, 9, 4, 5, 6, 9, 11};
        int target = 9;
        int[] ints1 = solutionByEnum.twoSum(ints, target);
        for (int i : ints1) {
            System.out.println(i);
        }

        int[] ints2 = solutionByHash.twoSum(ints, target);
        for (int i : ints2) {
            System.out.println(i);
        }

    }
}
