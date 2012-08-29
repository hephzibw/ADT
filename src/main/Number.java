package main;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/26/12
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Number {
    public int base;
    public LinkedList<Integer> positionValue;

    public Number(int base, LinkedList<Integer> positionValue) {
        this.base = base;
        this.positionValue = positionValue;
    }

    public static Number createNumber(String s) {
        String[] result = s.split(" ");
        String[] temp_array = result[1].split("(?!^)");
        Integer[] new_array = new Integer[temp_array.length];
        for (int i = 0; i < temp_array.length; i++) {
            new_array[i] = Base.lookup(temp_array[i]);
        }
        Number number = new Number(Integer.parseInt(result[0]), new LinkedList(Arrays.asList(new_array)));
        return number;
    }

    public int getBase() {
        return base;
    }

    public LinkedList<Integer> getPositionValue() {
        return positionValue;
    }

    public static void printNumber(Number number) {
        String str = "(";
        Iterator<Integer> iterator = number.getPositionValue().iterator();
        while (iterator.hasNext()) {
            Integer value = (Integer) iterator.next();
            str += Base.translator[value];
        }
        str += ")" + number.getBase();
        System.out.print(str);
    }

    public static Number convert(Number number, int base) {
        List<Integer> list = new LinkedList();

        for (int value = number.toDecimalValue(); value > 0; value = value / base) {
            int link = value % base;
            list.add(link);
        }

        LinkedList<Integer> newList = new LinkedList();
        ListIterator<Integer> integerIterator = list.listIterator(list.size());
        while (integerIterator.hasPrevious())  {
            newList.add((Integer)integerIterator.previous());
        }
        number.base = base;
        number.positionValue = (LinkedList<Integer>) newList;
        return number;
    }

    public int toDecimalValue() {
        int value = 0;
        int maxIndex = this.getPositionValue().size() - 1;
        Iterator<Integer> iterator = this.getPositionValue().iterator();
        while (iterator.hasNext()) {
            Integer numberNode = (Integer) iterator.next();
            value += numberNode * Math.pow(this.base, maxIndex - (this.getPositionValue().indexOf(numberNode)));
        }
        return value;
    }
}
