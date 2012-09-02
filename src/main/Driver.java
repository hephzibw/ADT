package main;

import java.io.*;

public class Driver {

    private File inputFile1;
    private File inputFile2;
    private int k;
    private FileWriter outputFileWriter;

    public Driver(String inputFileName1, String inputFileName2, String k, String outputFileName) throws IOException {
        this.inputFile1 = new File(inputFileName1);
        this.inputFile2 = new File(inputFileName2);
        this.k = Integer.parseInt(k);
        this.outputFileWriter = new FileWriter(outputFileName);
    }

    public static void main(String[] args) throws Exception {
        Driver driver = new Driver(args[0], args[1], args[2], args[3]);
        Base.initializeBase(driver.inputFile1);
        Number[] dynamicArray = driver.createAndPopulateDynamicNumberArray();

        int size = dynamicArray.length;
        if (driver.k > size) {
            driver.setK(driver.k/ 2);
        }
        Number output = Selector.quickSelect(dynamicArray, size, driver.k);
        driver.writeOutput(output);
    }

    private  void writeOutput(Number output) throws IOException {
        BufferedWriter out = new BufferedWriter(this.outputFileWriter);
        String s = Number.printNumber(output);
        out.write(s);
        out.close();
    }

    private int setK(int value) {
        this.k = value;
        return k;
    }

    private Number[] populateDynamicArray(Number[] dynamicArray) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.inputFile2));
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            dynamicArray[i] = Number.createNumber(line);
            i++;
        }
        reader.close();
        return dynamicArray;
    }

    private Number[] createAndPopulateDynamicNumberArray() throws IOException {
        Number[] dynamicArray = createDynamicArray(this.inputFile2);
        return populateDynamicArray(dynamicArray);
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

    public File getInputFile1() {
        return inputFile1;
    }

    public File getInputFile2() {
        return inputFile2;
    }

    public int getK() {
        return k;
    }

    public FileWriter getOutputFileWriter() {
        return outputFileWriter;
    }
}
