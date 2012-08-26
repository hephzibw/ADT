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
        Base base = new Base();
        int maxBase = base.initializeBase(file);
        assertEquals(base.getTranslator(), trans);
        assertEquals(maxBase, 62);
    }

    @Test
    public void getTranslator() {
        Base base = new Base();
        String trans[] = {"0", "b", "g", "d"};
        base.setTranslator(trans);
        assertEquals(trans, base.getTranslator());

    }

    @Test
    public void itShouldReturnTheIndexAssociatedWithTheCharacter() throws IOException {
        String trans[] = {"b", "i", "g", "s", "o", "u", "n", "d"};
        File file = new File("input1.txt");
        Base base = new Base();
        base.initializeBase(file);
        assertEquals(base.lookup("b"), 0);
        assertEquals(base.lookup("d"), 7);
        assertEquals(base.lookup("s"),3);


    }


}
