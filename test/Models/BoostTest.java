package Models;

import Models.Boost;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoostTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSetX_TooLarge_ThrowsException() {
        Boost boost = new Boost();
        boost.setX(800); // width / 2 + x = 815 > 800
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetX_TooSmall_ThrowsException() {
        Boost boost = new Boost();
        boost.setX(-Boost.width); // width / 2 + x = -15 < 0
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetY_TooLarge_ThrowsException() {
        Boost boost = new Boost();
        boost.setY(600); // length / 2 + y = 615 > 600
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetY_TooSmall_ThrowsException() {
        Boost boost = new Boost();
        boost.setY(-Boost.length); // length / 2 + y = -15 < 0
    }

    @Test
    public void testNewRandomPosition_ValidRange() {
        Boost boost = new Boost();
        for (int i = 0; i < 100; i++) {
            boost.newRandomPosition();
            int x = boost.getX();
            int y = boost.getY();
            assertTrue(x + Boost.width / 2 <= 800);
            assertTrue(x + Boost.width / 2 >= 0);
            assertTrue(y + Boost.length / 2 <= 600);
            assertTrue(y + Boost.length / 2 >= 0);
        }
    }

    @Test
    public void testGetQttyAppear_InitialValue() {
        Boost boost = new Boost();
        assertEquals(1000, boost.getQttyAppear());
    }

    @Test
    public void testUpdateQttyAppear_NegativeValueSetsToZero() {
        Boost boost = new Boost();
        boost.updateQttyAppear(-10);
        assertEquals(0, boost.getQttyAppear());
    }

    @Test
    public void testUpdateQttyAppear_PositiveValue() {
        Boost boost = new Boost();
        boost.updateQttyAppear(500);
        assertEquals(500, boost.getQttyAppear());
    }

    @Test
    public void testIsBoostAvailable_TrueWhenQttyPositive() {
        Boost boost = new Boost();
        assertTrue(boost.isBoostAvailable());
    }

    @Test
    public void testIsBoostAvailable_FalseWhenQttyZero() {
        Boost boost = new Boost();
        boost.updateQttyAppear(0);
        assertFalse(boost.isBoostAvailable());
    }
}