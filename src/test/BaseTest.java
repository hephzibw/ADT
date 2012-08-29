package test;

import main.Base;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: hephzibah
 * Date: 8/26/12
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseTest {
    @Test
    public void initializeBaseFileShouldSetIndexOfDigits() throws IOException {
        String trans[] = {"b", "i", "g", "s", "o", "u", "n", "d"};
        File file = new File("input1.txt");
        int maxBase = Base.initializeBase(file);
        assertEquals(Base.translator, trans);
        assertEquals(maxBase, 62);
    }

    @Test
    public void itShouldReturnTheIndexAssociatedWithTheCharacter() throws IOException {
        File file = new File("input1.txt");
        Base.initializeBase(file);
        assertEquals(Base.lookup("b"), 0);
        assertEquals(Base.lookup("d"), 7);
        assertEquals(Base.lookup("s"),3);
    }


}
