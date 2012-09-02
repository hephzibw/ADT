package test;

import main.Driver;
import main.Selector;
import org.junit.Test;
import main.Number;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

import static junit.framework.Assert.assertEquals;

public class DriverTest {
    @Test
    public void testingTheConstructor() throws IOException {
        String inputFileName1="input1.txt";
        String inputFileName2="input2.txt";
        String k="5";
        String outputFileName="insaneInput.txt";
        Driver driver=new Driver(inputFileName1,inputFileName2,k,outputFileName);
        assertEquals(driver.getInputFile1(),new File("input1.txt"));
        assertEquals(driver.getInputFile2(),new File("input2.txt"));
        assertEquals(driver.getK(),5);
//        assertEquals(driver.getOutputFileWriter(),new FileWriter("insaneInput.txt"));
    }

}
