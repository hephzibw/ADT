package test;

import main.Order;
import main.Number;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;

public class OrderTest {
        @Test
    public void itShouldReturnEqualIfTheTwoNumbersAreEqual() {
        Number number1 = new Number(10, new LinkedList<Integer>(Arrays.asList(1, 2, 3)));
        Number number2 = new Number(10, new LinkedList<Integer>(Arrays.asList(1,2, 3)));
        assertEquals(Order.compare(number1, number2), Order.OrderType.EQUAL);

    }

    @Test
    public void itShouldReturnGreaterIfBaseIsEqualAndNumberOfNodesInOneIsGreaterThanOther() {
        Number number1 = new Number(10, new LinkedList<Integer>(Arrays.asList(1, 2, 3)));
        Number number2 = new Number(10, new LinkedList<Integer>(Arrays.asList(3, 5)));
        assertEquals(Order.compare(number1, number2), Order.OrderType.GREATER);
    }

     @Test
    public void itShouldReturnLesserIfBaseIsEqualAndNumberOfNodesInFirstIsLessThanOther() {
        Number number1 = new Number(10, new LinkedList<Integer>(Arrays.asList(1, 2, 3)));
        Number number2 = new Number(10, new LinkedList<Integer>(Arrays.asList(3, 5, 3, 3)));
        assertEquals(Order.compare(number1, number2), Order.OrderType.LESSER);
    }

    @Test
    public void itShouldReturnLesserIfBaseAndNumberOfNodesAreEqualButMSDInFirstIsLessThanOther() {
        Number number1 = new Number(10, new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4)));
        Number number2 = new Number(10, new LinkedList<Integer>(Arrays.asList(3, 5, 3, 3)));
        assertEquals(Order.compare(number1, number2), Order.OrderType.LESSER);
    }

    @Test
    public void itShouldReturnGreaterIfBaseAndNumberOfNodesAreEqualButMSDInFirstIsGreaterThanOther() {
        Number number1 = new Number(10, new LinkedList<Integer>(Arrays.asList(4, 2, 3, 4)));
        Number number2 = new Number(10, new LinkedList<Integer>(Arrays.asList(3, 5, 3, 3)));
        assertEquals(Order.compare(number1, number2), Order.OrderType.GREATER);
    }

    @Test
    public void itShouldConvertNumbersToTheSameBaseAndCompare() {
        Number number1 = new Number(10, new LinkedList<Integer>(Arrays.asList(4, 2, 3, 4)));
        Number number2 = new Number(5, new LinkedList<Integer>(Arrays.asList(3, 5, 3, 3)));
        assertEquals(Order.compare(number1, number2), Order.OrderType.GREATER);
    }

}
