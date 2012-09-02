package main;


import java.util.LinkedList;

public class Order {
    public enum OrderType {
        EQUAL, GREATER, LESSER
    }

    public static OrderType compare(Number num1, Number num2) {
        OrderType orderType = null;
        if (!(num1.getBase() == num2.getBase())) {
            Number.convert(num1, num2.getBase());
        }

        if (num1.getPositionValue().size() == num2.getPositionValue().size()) {
            if (num1.getPositionValue().getFirst().equals(num2.getPositionValue().getFirst())) {
                if (num1.getPositionValue().size() == 1 && num2.getPositionValue().size() == 1) {
                    orderType = OrderType.EQUAL;
                } else {
                    return compare(num1.nextPositions(), num2.nextPositions());
                }
            } else {
                if (num1.getPositionValue().getFirst() > num2.getPositionValue().getFirst()) {
                    orderType = OrderType.GREATER;
                } else {
                    orderType = OrderType.LESSER;
                }
            }
        } else {
            if (num1.getPositionValue().size() > num2.getPositionValue().size()) {
                orderType = OrderType.GREATER;
            } else {
                orderType = OrderType.LESSER;
            }
        }

        return orderType;
    }
}
