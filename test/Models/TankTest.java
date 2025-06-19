package Models;

import static org.junit.Assert.*;
import org.junit.Test;

public class TankTest {

    // 1. Verifica que el ancho del tanque sea el esperado (35)
    @Test
    public void testAnchoTank() {
        assertEquals(35, Tank.width);
    }

    // 2. Verifica que el alto del tanque sea el esperado (35)
    @Test
    public void testAltoTank() {
        assertEquals(35, Tank.length);
    }

    // 3. El tanque creado no debe estar en la posición (0, 0)
    @Test
    public void testTankNoIniciaEnCeroCero() {
        Tank t = new Tank(100, 150, true);
        assertNotEquals(0, t.getX());
        assertNotEquals(0, t.getY());
    }

    // 4. La posición X del tanque debe estar dentro de los límites de pantalla (0 <= x <= 800 - width)
    @Test
    public void testTankPosXEnPantalla() {
        Tank t = new Tank(500, 100, true);
        assertTrue(t.getX() >= 0);
        assertTrue(t.getX() + Tank.width <= 800);
    }

    // 5. La posición Y del tanque debe estar dentro de los límites de pantalla (0 <= y <= 600 - height)
    @Test
    public void testTankPosYEnPantalla() {
        Tank t = new Tank(100, 550, true);
        assertTrue(t.getY() >= 0);
        assertTrue(t.getY() + Tank.length <= 600);
    }


}