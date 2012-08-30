package main;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/29/12
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */

public class Driver {

    public static void main(String[] args) {

    }

    public static Number quickSelect(Number[] numbers, int size, int k) {
        int start = 0;
        int end = size - 1;
        int index = 0;
        if (size == 1) {
            index = 0;
        } else {
            while (start <= end) {
                int pivotIndex = partition(numbers, start, end);
                System.out.println(pivotIndex);
                int pivotIndexDist = pivotIndex - start + 1;
                if (k == pivotIndexDist) {
                    index = pivotIndex;
                    break;
                } else {
                    if (k > pivotIndexDist) {
                        k = k - pivotIndexDist;
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
        while (start < end) {
            while (Order.compare(numbers[start], pivotValue).equals(Order.OrderType.LESSER)) {
                start++;
            }

            while (Order.compare(numbers[end], pivotValue).equals(Order.OrderType.GREATER)) {
                end--;
            }
            if (start >= end) {
                break;
            }
            swap(numbers, start, end);
        }
        return start;
    }

    public static void swap(Number[] numbers, int start, int end) {
        Number temp = numbers[start];
        numbers[start] = new Number(numbers[end].getBase(), numbers[end].getPositionValue());
        numbers[end] = new Number(temp.getBase(), temp.getPositionValue());
    }

}
