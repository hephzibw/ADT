package main;

import com.sun.tools.corba.se.idl.constExpr.Equal;
import main.Number;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/29/12
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Order {
    public enum OrderType {
        EQUAL, GREATER, LESSER
    }

    public static OrderType compare(Number number1, Number number2) {
        OrderType orderType = null;
        if (number1.getBase() == number2.getBase()) {
            if (number1.getPositionValue().size() == number2.getPositionValue().size()) {
                if (number1.getPositionValue().getFirst() > number2.getPositionValue().getFirst()) {
                    orderType = OrderType.GREATER;
                } else if (number1.getPositionValue().getFirst() < number2.getPositionValue().getFirst()) {
                    orderType = OrderType.LESSER;
                } else {
                    System.out.print(number1.getPositionValue());
                    System.out.print(number2.getPositionValue());
                    if (number1.getPositionValue().size() == 1 && number2.getPositionValue().size() == 1) {
                        System.out.print("ok");
                        orderType = OrderType.EQUAL;
                    } else {
                        LinkedList<Integer> posVal1 = (LinkedList<Integer>) number1.getPositionValue().clone();
                        posVal1.removeFirst();
                        LinkedList<Integer> posVal2 = (LinkedList<Integer>) number2.getPositionValue().clone();
                        posVal2.removeFirst();
                        Order.compare(new Number(number1.getBase(), posVal1), new Number(number2.getBase(), posVal2));
                    }
                }
            } else {
                if (number1.getPositionValue().size() > number2.getPositionValue().size()) {
                    orderType = OrderType.GREATER;
                } else {
                    orderType = OrderType.LESSER;
                }
            }

        } else {
            compare(Number.convert(number1, number2.getBase()), number2);
        }
        return orderType;
    }

}
