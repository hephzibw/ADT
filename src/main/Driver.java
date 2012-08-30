package main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/29/12
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */

//function select(list, left, right, k)
//        if left = right // If the list contains only one element
//        return list[left]  // Return that element
//        // select pivotIndex between left and right
//        pivotNewIndex := partition(list, left, right, pivotIndex)
//        pivotDist := pivotNewIndex - left + 1
//        // The pivot is in its final sorted position,
//        // so pivotDist reflects its 1-based position if list were sorted
//        if pivotDist = k
//        return list[pivotNewIndex]
//        else if k < pivotDist
//        return select(list, left, pivotNewIndex - 1, k)
//        else
//        return select(list, pivotNewIndex + 1, right, k - pivotDist)

public class Driver {
    public static Number[] numbers;

    public static void main(String[] args) {

    }

    public static Number quickSelect(Number[] numbers, int size, int k) {
        int start = 0;
        int end = size - 1;
        int index = 0;
        if (size == 1) {
            index = 0;
        } else {
            while (start < end) {
                System.out.println(222222);
                int pivotIndex = partition(numbers, start, end);
                System.out.println(pivotIndex);
                if (k == pivotIndex) {
                    index = pivotIndex - 1;
                    System.out.println(66666666);
                    break;
                } else {
                    if (k > pivotIndex) {
                        start = pivotIndex + 1;
                    } else {
                        end = pivotIndex - 1;
                    }
                }
            }

        }
        return numbers[index];
    }

    private static int partition(Number[] numbers, int start, int end) {
        int pivot = (start + end) / 2;
        Number pivotValue = numbers[pivot];
        while (start <= end && !numbers[start].equals(pivotValue)) {
            while (Order.compare(numbers[start], pivotValue).equals(Order.OrderType.LESSER)) {
                start++;
            }

            while (Order.compare(numbers[end], pivotValue).equals(Order.OrderType.GREATER)) {
                end--;
            }
            swap(numbers,start,end);
        }
        return start;
    }

    private static void swap(Number[] numbers, int start, int end) {
        Number temp = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = temp;
    }

}
