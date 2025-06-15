package test.Models;

import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.reflect.Field;
import Models.Tree;

public class TreeTest {

    @Test
    public void testCantidadImagenesEs7() throws Exception {
        Field imgsField = Tree.class.getDeclaredField("imgs");
        imgsField.setAccessible(true);
        Object[] imgs = (Object[]) imgsField.get(null); // null porque es static
        assertEquals(7, imgs.length);
    }
}