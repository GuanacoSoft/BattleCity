package Models;

import static org.junit.Assert.*;
import org.junit.Test;

public class TreeTest {

    @Test
    public void testTreeDentroDePantalla() {
        int pantallaAncho = 800;
        int pantallaAlto = 600;

        // Crear un árbol cerca del borde inferior derecho
        Tree tree = new Tree(770, 570, null); // x=770, y=570

        int x = tree.getPosX();
        int y = tree.getPosY();

        assertTrue("El árbol excede el ancho de la pantalla", x + Tree.width <= pantallaAncho);
        assertTrue("El árbol excede el alto de la pantalla", y + Tree.length <= pantallaAlto);
    }

    @Test
    public void testTreeFueraDePantalla() {
        Tree tree = new Tree(780, 580, null); // x=780, y=580

        int x = tree.getPosX();
        int y = tree.getPosY();

        assertFalse("El árbol debería exceder el ancho", x + Tree.width <= 800);
        assertFalse("El árbol debería exceder el alto", y + Tree.length <= 600);
    }
}