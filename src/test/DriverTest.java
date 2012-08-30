package test;

import main.Driver;
import org.junit.Test;
import main.Number;

import java.util.Arrays;
import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/29/12
 * Time: 3:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class DriverTest {
    @Test
    public void partitionShouldReturnOneForListOfSize1AndK1() {
        Number[] numbers = new Number[1];
        Number num1 = new Number(2, new LinkedList<Integer>(Arrays.asList(3, 5)));
        numbers[0] = num1;
        assertEquals(Driver.quickSelect(numbers, 1, 1), num1);
    }

    @Test
    public void partitionShouldReturnSecondSmallestElementForListOfSize3AndK2() {
        Number num1 = new Number(10, new LinkedList<Integer>(Arrays.asList(9, 5)));
        Number num2 = new Number(10, new LinkedList<Integer>(Arrays.asList(5)));
        Number num3 = new Number(10, new LinkedList<Integer>(Arrays.asList(9, 2)));
        Number[] numbers = new Number[]{num1, num2, num3};
        assertEquals(Driver.quickSelect(numbers, 3, 2).getPositionValue(), new LinkedList<Integer>(Arrays.asList(9, 2)));
    }

    @Test
    public void partitionShouldReturnCorrect() {
        Number num1 = new Number(10, new LinkedList<Integer>(Arrays.asList(9, 5)));
        Number num2 = new Number(10, new LinkedList<Integer>(Arrays.asList(5)));
        Number num3 = new Number(10, new LinkedList<Integer>(Arrays.asList(1, 1)));
        Number num4 = new Number(10, new LinkedList<Integer>(Arrays.asList(2)));
        Number num5 = new Number(10, new LinkedList<Integer>(Arrays.asList(9, 2, 8)));
        Number[] numbers = new Number[]{num1, num2, num3, num4, num5};

        assertEquals(Driver.quickSelect(numbers, 5, 3), num3);
    }

    @Test
    public void fifteenNumbersScenario() {
        Number num1 = new Number(10, new LinkedList<Integer>(Arrays.asList(9, 5)));
        Number num2 = new Number(10, new LinkedList<Integer>(Arrays.asList(5)));
        Number num3 = new Number(10, new LinkedList<Integer>(Arrays.asList(3, 7)));
        Number num4 = new Number(10, new LinkedList<Integer>(Arrays.asList(8, 2, 8)));
        Number num5 = new Number(10, new LinkedList<Integer>(Arrays.asList(1, 1)));
        Number num6 = new Number(10, new LinkedList<Integer>(Arrays.asList(2)));
        Number num7 = new Number(10, new LinkedList<Integer>(Arrays.asList(9, 6)));
        Number num8 = new Number(10, new LinkedList<Integer>(Arrays.asList(1, 2, 8)));
        Number num9 = new Number(10, new LinkedList<Integer>(Arrays.asList(8, 8)));
        Number num10 = new Number(10, new LinkedList<Integer>(Arrays.asList(0)));
        Number num11 = new Number(10, new LinkedList<Integer>(Arrays.asList(1, 7, 6)));
        Number num12 = new Number(10, new LinkedList<Integer>(Arrays.asList(1, 7)));
        Number num13 = new Number(10, new LinkedList<Integer>(Arrays.asList(6)));
        Number num14 = new Number(10, new LinkedList<Integer>(Arrays.asList(6, 9)));
        Number num15 = new Number(10, new LinkedList<Integer>(Arrays.asList(2, 2, 4)));
        Number[] numbers = new Number[]{num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12, num13, num14, num15};

        assertEquals(Driver.quickSelect(numbers, 15, 3).getPositionValue(), new LinkedList<Integer>(Arrays.asList(5)));

    }

    @Test
    public void swapShouldInterchangeValuesAtGivenIndex() {
        Number num1 = new Number(10, new LinkedList<Integer>(Arrays.asList(9, 5)));
        Number num2 = new Number(10, new LinkedList<Integer>(Arrays.asList(5)));
        Number num3 = new Number(10, new LinkedList<Integer>(Arrays.asList(9, 2)));
        Number[] numbers = new Number[]{num1, num2, num3};
        Driver.swap(numbers, 0, 1);
        assertEquals(numbers[0].getPositionValue(), new LinkedList<Integer>(Arrays.asList(5)));

    }
}
