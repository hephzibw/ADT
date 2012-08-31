package main;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/29/12
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */

public class Driver {

    public static void main(String[] args) throws Exception {
        File file1 = new File(args[0]);
        Base.initializeBase(file1);
        File file2 = new File(args[1]);
        Number[] dynamicArray = createAndPopulateDynamicNumberArray(file2);

        int size = dynamicArray.length;
        int k = Integer.parseInt(args[2]);
        if (k > size) {
            k = k / 2;
        }
        Number required = Selector.quickSelect(dynamicArray, size, k);
        FileWriter fstream = new FileWriter(args[3]);
        BufferedWriter out = new BufferedWriter(fstream);
        String s = Number.printNumber(required);
        System.out.println(s);
        out.write(s);
        out.close();
    }

    private static Number[] populateDynamicArray(File file2, Number[] dynamicArray) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file2));
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            dynamicArray[i] = Number.createNumber(line);
            i++;
        }
        reader.close();
        return dynamicArray;
    }

    private static Number[] createAndPopulateDynamicNumberArray(File file) throws IOException {
        Number[] dynamicArray = createDynamicArray(file);
        return populateDynamicArray(file, dynamicArray);
    }

    private static Number[] createDynamicArray(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        Integer lineCount = 0;
        while ((line = reader.readLine()) != null) {
            lineCount++;
        }
        reader.close();
        Number[] numbers = new Number[lineCount];
        return numbers;
    }

}
