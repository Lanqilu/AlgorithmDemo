package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Halo
 * @Create 2021-03-13 下午 04:59
 * @Description
 */
public class TimeTest {

    public static void main(String[] args) {
        TestHard();
        TestBasic();
    }

    public static void TestBasic(int number) {

        System.out.println("数据量：" + number);
        TimeTest timeTest = new TimeTest();
        if (number <= 10_0000) {
            timeTest.TestBubbleSort(number);
        }
        timeTest.TestSelectionSort(number);
        timeTest.TestInsertSort(number);
        timeTest.TestShellSort(number);
        timeTest.TestQuickSort(number);
        timeTest.TestMergeSort(number);
        timeTest.TestRadixSort(number);
    }

    public static void TestBasic() {
        int number = 10_0000;
        TestBasic(number);
    }

    public static void TestHard(int number) {
        System.out.println("数据量：" + number);
        TimeTest timeTest = new TimeTest();
        timeTest.TestShellSort(number);
        timeTest.TestQuickSort(number);
        timeTest.TestMergeSort(number);
        if (number <= 1_0000_0000 && number >= 0) {
            timeTest.TestRadixSort(number);
        }

    }

    public static void TestHard() {
        int number = 1000_0000;
        TestHard(number);
    }


    public static int[] Data(int number) {
        // 大量数据测试
        Random random = new Random(1);
        int[] arr = new int[number];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (random.nextDouble() * number * 100);
        }
        return arr;
    }

    public void TestShellSort(int number) {

        int[] data = Data(number);
        ShellSort shellSort = new ShellSort();

        System.out.print("希尔排序开始计时\t");
        long shellSortBefore2 = System.currentTimeMillis();
        shellSort.toSortByRemove(data);
        long shellSortAfter2 = System.currentTimeMillis();

        System.out.println("希尔排序耗时: " + (shellSortAfter2 - shellSortBefore2) + "毫秒");
    }

    public void TestBubbleSort(int number) {
        int[] data = Data(number);
        BubbleSort bubbleSort = new BubbleSort();

        System.out.print("冒泡排序开始计时\t");
        long bubbleSortBefore = System.currentTimeMillis();
        bubbleSort.toSort(data);
        long bubbleSortAfter = System.currentTimeMillis();

        System.out.println("冒泡排序耗时: " + (bubbleSortAfter - bubbleSortBefore) + "毫秒");

    }

    public void TestSelectionSort(int number) {
        int[] data = Data(number);
        SelectionSort selectionSort = new SelectionSort();

        System.out.print("选择排序开始计时\t");
        long selectionSortBefore = System.currentTimeMillis();
        selectionSort.toSort(data);
        long selectionSortAfter = System.currentTimeMillis();

        System.out.println("选择排序耗时: " + (selectionSortAfter - selectionSortBefore) + "毫秒");
    }

    public void TestInsertSort(int number) {
        int[] data = Data(number);
        InsertSort insertSort = new InsertSort();

        System.out.print("插入排序开始计时\t");
        long insertSortBefore = System.currentTimeMillis();
        insertSort.toSort(data);
        long insertSortAfter = System.currentTimeMillis();

        System.out.println("插入排序耗时: " + (insertSortAfter - insertSortBefore) + "毫秒");

    }

    public void TestQuickSort(int number) {
        int[] data = Data(number);
        QuickSort quickSort = new QuickSort();

        System.out.print("快速排序开始计时\t");
        long quickSortBefore = System.currentTimeMillis();
        quickSort.toSort(data);
        long quickSortAfter = System.currentTimeMillis();

        System.out.println("快速排序耗时: " + (quickSortAfter - quickSortBefore) + "毫秒");
    }

    public void TestMergeSort(int number) {
        int[] data = Data(number);
        MergeSort mergeSort = new MergeSort();

        System.out.print("归并排序开始计时\t");
        long quickSortBefore = System.currentTimeMillis();
        mergeSort.toSort(data);
        long quickSortAfter = System.currentTimeMillis();

        System.out.println("归并排序耗时: " + (quickSortAfter - quickSortBefore) + "毫秒");
    }

    public void TestRadixSort(int number) {
        int[] data = Data(number);
        RadixSort radixSort = new RadixSort();

        System.out.print("基数排序开始计时\t");
        long quickSortBefore = System.currentTimeMillis();
        radixSort.toSort(data);
        long quickSortAfter = System.currentTimeMillis();

        System.out.println("基数排序耗时: " + (quickSortAfter - quickSortBefore) + "毫秒");
    }


}





