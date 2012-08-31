package main;

import java.io.*;
import java.util.*;

public class Base {
    public static HashMap<Integer, Character> translator = new HashMap<Integer, Character>();


    public static Integer initializeBase(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            for (int i = 0; i < line.length(); i++) {
                if (!translator.containsValue(line.charAt(i))) {
                    translator.put(i, line.charAt(i));
                }
            }
        }
        reader.close();
        return 62;
    }

    public static int lookup(char b) {
        Set set = translator.keySet();
        Iterator iterator = set.iterator();
        Integer index = null;
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            if (translator.get(key).equals(b)) {
                index = key;
            }
        }
        return index;
    }
}
