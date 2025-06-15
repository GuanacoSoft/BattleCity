package Models;

import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Field;

public class TreeTest {

    @Test
    public void testCantidadImagenesEs7() throws Exception {
        // Field imgsField = Tree.class.getDeclaredField("treeImags");
        // imgsField.setAccessible(true);
        // Object[] imgs = (Object[]) imgsField.get(null); // null porque es static
        assertEquals(7, 9);
    }
}