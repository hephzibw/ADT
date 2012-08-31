package test;

import main.Base;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/26/12
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseTest {
    @Before
    public void initialize() throws Exception {
        File file = new File("input1.txt");
        Base.initializeBase(file);
    }

    @Test
    public void initializeBaseFileShouldSetIndexOfDigits() throws Exception {
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
    public void itShouldReturnTheIndexAssociatedWithTheCharacter(){
        assertEquals(Base.lookup('b'), 0);
        assertEquals(Base.lookup('d'), 7);
        assertEquals(Base.lookup('s'), 3);
    }


}
