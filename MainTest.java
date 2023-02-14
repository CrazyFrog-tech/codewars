import static org.testng.AssertJUnit.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    public void testTooSmall() {
        assertEquals(0, Main.isInteresting(3, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostAwesome() {
        assertEquals(1, Main.isInteresting(1336, new int[]{1337, 256}));
    }

    @Test
    public void testAwesome() {
        assertEquals(2, Main.isInteresting(1337, new int[]{1337, 256}));
    }

    @Test
    public void testFarNotInteresting() {
        assertEquals(0, Main.isInteresting(11208, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostInteresting() {
        assertEquals(1, Main.isInteresting(11209, new int[]{1337, 256}));
    }

    @Test
    public void testInteresting() {
        assertEquals(2, Main.isInteresting(11211, new int[]{1337, 256}));
    }
}