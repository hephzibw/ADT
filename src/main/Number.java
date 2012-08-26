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
    public List<String> positionValue;

    public void createNumber(String s) {
        String[] result = s.split(" ");
        base = Integer.parseInt(result[0]);
        positionValue = Arrays.asList(result[1].split("(?!^)"));
    }

    public int getBase() {
        return base;
    }

    public List<String> getPositionValue() {
        return positionValue;
    }

    public static void printNumber(Number number) {
        String str="(";
        Iterator iterator = number.getPositionValue().iterator();
        while (iterator.hasNext()) {
            str += iterator.next();
        }
        str += ")" + number.getBase();
        System.out.print(str);
    }
}
