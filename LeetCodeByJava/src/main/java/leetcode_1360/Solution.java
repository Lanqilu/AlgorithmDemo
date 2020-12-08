package leetcode_1360;

/**
 * @author lanqilu
 * @date Created in 2020/12/03  23:02
 * @description
 */
class Solution {
    private int[][] Month = {
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };
    private int[] Day = {365, 366};


    public int daysBetweenDates(String date1, String date2) {
        //计算两个日期分别与1971.01.01日的差，之后再做差取绝对值即可
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");
        int year1 = Integer.valueOf(d1[0]), year2 = Integer.valueOf(d2[0]);
        int month1 = Integer.valueOf(d1[1]), month2 = Integer.valueOf(d2[1]);
        int day1 = Integer.valueOf(d1[2]), day2 = Integer.valueOf(d2[2]);
        int s1 = gap(year1, month1, day1);
        int s2 = gap(year2, month2, day2);
        return Math.abs(s1 - s2);
    }


    public int gap(int year, int month, int day) {
        //计算一个日期与1971.01.01日的日期差
        int sum = 0;
        int flag = isleapyear(year);
        for (int i = 1971; i < year; i++) {
            sum += Day[isleapyear(i)];
        }
        for (int i = 1; i < month; i++) {
            sum += Month[flag][i];
        }
        sum += day;
        return sum;
    }


    public int isleapyear(int year) {
        //判断是否闰年
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return 1;
        }
        return 0;
    }


}

