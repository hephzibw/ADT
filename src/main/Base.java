package main;

import java.io.*;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/26/12
 * Time: 7:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Base {
    String translator[];

    public Integer initializeBase(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            this.translator = line.split("(?!^)");
        }
        return 62;
    }

    public void setTranslator(String[] trans) {
        translator = trans;
    }

    public String[] getTranslator() {
        return translator;
    }

    public int lookup(String b) {
       return Arrays.asList(translator).indexOf(b);
    }
}
