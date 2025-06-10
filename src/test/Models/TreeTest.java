package test.Models;

import Models.Tree;
import org.testng.annotations.Test;

import java.awt.Image;
import java.lang.reflect.Field;

import static org.testng.Assert.assertEquals;


public class TreeTest {

    @Test
    void testTreeInitialization() throws Exception {
        Field imgsField = Tree.class.getDeclaredField("treeImags");
        imgsField.setAccessible(true);
        Image[] imgs = (Image[]) imgsField.get(null);
        assertEquals(7, imgs.length, "Debe existir una imagen de árbol cargada");
    }  
    
}
