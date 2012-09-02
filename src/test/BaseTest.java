package test;

import main.Base;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BaseTest {
    @Test
    public void initializeBaseFileShouldSetIndexOfDigits() throws Exception {
        File file = new File("input1.txt");
        Base.initializeBase(file);
        HashMap<Integer, Character> Map = new HashMap<Integer, Character>();
        Map.put(0, 'b');
        Map.put(1, 'i');
        Map.put(2, 'g');
        Map.put(3, 's');
        Map.put(4, 'o');
        Map.put(5, 'u');
        Map.put(6, 'n');
        Map.put(7, 'd');
        assertEquals(Base.translator, Map);
    }

    @Test
    public void shouldRaiseAnExceptionOnlyAplhaNumericCharactersSupported() throws Exception {
        File file = new File("insaneInput.txt");
        try {
            assertEquals(Base.initializeBase(file),new Exception("aaaaa"));
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Only Alphanumeric Characters allowed in first File.");
        }
    }

    @Test
    public void itShouldReturnTheIndexAssociatedWithTheCharacter() throws Exception {
        File file = new File("input1.txt");
        Base.initializeBase(file);
        assertEquals(Base.lookup('b'), 0);
        assertEquals(Base.lookup('d'), 7);
        assertEquals(Base.lookup('s'), 3);
    }


}
