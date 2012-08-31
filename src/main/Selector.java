package main;

public class Selector {
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
        Number pivotValue = getMedian(numbers, start, end);
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

    private static Number getMedian(Number[] numbers, int start, int end) {
        Number[] medianArray = new Number[]{numbers[start], numbers[start + (end - start) / 4], numbers[start + (end - start) / 2], numbers[end - (end - start) / 4], numbers[end]};
        return insertionSort(medianArray);
    }

    private static Number insertionSort(Number[] medians) {
        for (int i = 1; i < medians.length; i++) {
            int index = i;
            Number item = medians[index];
            while (index > 0 && Order.compare(medians[index - 1], item) == Order.OrderType.GREATER) {
                swap(medians, index - 1, index);
                index--;
            }
            medians[index] = item;
        }
        return medians[2];
    }

    private static void swap(Number[] numbers, int start, int end) {
        Number temp = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = temp;
    }
}
