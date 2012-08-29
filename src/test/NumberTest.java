package test;

import main.Base;
import main.Number;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/26/12
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumberTest {
    @Test
    public void itShouldCreateNumberTakingFirstOptionAsTheBaseAndOthersAsTheNumber() throws IOException {
        File file = new File("input1.txt");
        Base.initializeBase(file);
        Number number = Number.createNumber("8 ibo");
        List<Integer> list = Arrays.asList(1, 0, 4);

        assertEquals(number.getBase(), 8);
        assertEquals(number.getPositionValue(), list);
    }

    @Test
    public void itShouldPrintTheNumberOnTheOstream() throws IOException {
        File file = new File("input1.txt");
        Base.initializeBase(file);
        Number number = Number.createNumber("8 ibo");
        Number.printNumber(number);
//        Arrays outContent;
//        assertEquals("(abc)8", outContent.toString());
//
    }

    @Test
    public void itShouldConvertANumberToGivenBaseAndReturnIt() throws IOException {
        File file = new File("input1.txt");
        Base.initializeBase(file);
        Number number = Number.createNumber("8 ibo");
        Number number1 = Number.convert(number, 2);
        assertEquals(number1.getBase(), 2);
        assertEquals(number1.getPositionValue(), Arrays.asList(1, 0, 0, 0, 1, 0, 0));
    }

    @Test
    public void toDecimalValueShouldReturnDecimalValueOfNumber() {

        Number number = new Number(8, new LinkedList<Integer>(Arrays.asList(1, 3, 4, 5)));
        assertEquals(number.toDecimalValue(), 741);
    }
}
