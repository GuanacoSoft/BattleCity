package Models;

import Models.Boost;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoostTest {

    private Boost boost;

    @Before
    public void setUp() {
        boost = new Boost();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetX_TooLarge_ThrowsException() {
        boost.setX(800); // width / 2 + x = 815 > 800
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetX_TooSmall_ThrowsException() {
        boost.setX(-Boost.width); // width / 2 + x = -15 < 0
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetY_TooLarge_ThrowsException() {
        boost.setY(600); // length / 2 + y = 615 > 600
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetY_TooSmall_ThrowsException() {
        boost.setY(-Boost.length); // length / 2 + y = -15 < 0
    }


    @Test
    public void testGetQttyAppear_InitialValue() {
        assertEquals(1000, boost.getQttyAppear());
    }

    @Test
    public void testUpdateQttyAppear_NegativeValueSetsToZero() {
        boost.updateQttyAppear(-10);
        assertEquals(0, boost.getQttyAppear());
    }

    @Test
    public void testUpdateQttyAppear_PositiveValue() {
        boost.updateQttyAppear(500);
        assertEquals(500, boost.getQttyAppear());
    }

    @Test
    public void testIsBoostAvailable_TrueWhenQttyPositive() {
        assertTrue(boost.isBoostAvailable());
    }

    @Test
    public void testIsBoostAvailable_FalseWhenQttyZero() {
        boost.updateQttyAppear(0);
        assertFalse(boost.isBoostAvailable());
    }
}
