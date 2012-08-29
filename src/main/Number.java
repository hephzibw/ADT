package main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/26/12
 * Time: 10:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class Number {
    public int base;
    public List<Integer> positionValue;

    public static Number createNumber(String s) {
        String[] result = s.split(" ");
        Number number = new Number();
        number.base = Integer.parseInt(result[0]);
        String[] temp_array = result[1].split("(?!^)");
        Integer[] new_array = new Integer[temp_array.length];
        for(int i=0;i<temp_array.length;i++){
            new_array[i] = Base.lookup(temp_array[i]);
        }
        number.positionValue = Arrays.asList(new_array);
        return number;
    }

    public int getBase() {
        return base;
    }

    public List<Integer> getPositionValue() {
        System.out.print(positionValue);
        return positionValue;
    }

    public static void printNumber(Number number) {
        String str = "(";
        Iterator iterator = number.getPositionValue().iterator();
        while (iterator.hasNext()) {
            str += iterator.next();
        }
        str += ")" + number.getBase();
        System.out.print(str);
    }
}
