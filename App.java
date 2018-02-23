package com.tingyun.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 算法图解
 */
public class App {

    private static final Integer[] arr = {123, 343, 567, 322, 332, 2, 3567, 331, 789, 752};

    private static final List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));

    public static void main(String[] args){
//        int index = binarySearch(arr, 789);
//        System.out.println(index);

//        int smallestIndex = findSmallest(list);
//        System.out.println(smallestIndex);

//        List<Integer> selectionSortList = selectionSort(list);
//        for(Integer i : selectionSortList){
//            System.out.print(i + ", ");
//        }

//        int factorial = factorial(5);
//        System.out.println(factorial);

        List<Integer> quickSortList = quickSort(list);
        for(Integer i : quickSortList){
            System.out.print(i + ", ");
        }

    }

    /**
     * 二分查找
     * @param list
     * @param item
     * @return
     */
    public static int binarySearch(final Integer[] list, final int item){

        int low = 0;
        int hi = list.length - 1;

        while(low <= hi) {
            int mid = (low + hi) / 2;
            int guess = list[mid];
            if (guess == item) {
                return mid;
            } else if (guess > item) {
                hi = mid - 1;
            } else if (guess < item) {
                low = mid + 1;
            }
        }

        return -1;
    }

    /**
     * 查找最小值
     * @param list
     * @return
     */
    private static int findSmallest(List<Integer> list){

        int result = 0;
        Integer item = list.get(result);

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) < item){
                item = list.get(i);
                result = i;
            }
        }

        return result;
    }

    /**
     * 选择排序
     * @param list
     * @return
     */
    private static List<Integer> selectionSort(List<Integer> list){
        List<Integer> result = new ArrayList<Integer>();

        int size = list.size();
        for(int i = 0; i < size; i++){
            int smallestIndex = findSmallest(list);
            result.add(list.remove(smallestIndex));
        }

        return result;
    }

    /**
     * 递归 n 的阶乘
     * @param n
     * @return
     */
    private static int factorial(int n){
        if(n == 1){
            return n;
        }else{
            return n * factorial(n - 1);
        }
    }

    /**
     * 快速排序
     * @param list
     * @return
     */
    private static List<Integer> quickSort(List<Integer> list){
        if(list.size() < 2){
            return list;
        }else{
            int pivot = list.get(0);
            List<Integer> less = new ArrayList<Integer>();
            for(int i = 1; i < list.size(); i++){
                if(list.get(i) < pivot){
                    less.add(list.get(i));
                }
            }
            List<Integer> greater = new ArrayList<Integer>();
            for(int i = 1; i < list.size(); i++){
                if(list.get(i) > pivot){
                    greater.add(list.get(i));
                }
            }
            List<Integer> result = new ArrayList<Integer>();
            result.addAll(quickSort(less));
            result.add(pivot);
            result.addAll(quickSort(greater));
            return result;
        }
    }

}
