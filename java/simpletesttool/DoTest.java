
public class DoTest {
    public static void fail(String message) {throw new RuntimeException(message);}
    public static void assertTrue (boolean b) {if (!b) fail("assertTrue fails");}
    public static void assertNever(boolean b) {if ( b) fail("assertNever fails");}
    public static void assertEquals(boolean expected, boolean actual) {
        assertEqualsBoolean(expected, actual);
    }
    private static void assertEqualsBoolean(boolean expected, boolean actual) {
        if (expected == actual) return;
        fail("expected:" + expected + ", actual:" + actual);
    }
    public static void assertEquals(long expected, long actual) {
        assertEqualsLong(expected, actual);
    }
    private static void assertEqualsLong(long expected, long actual) {
        if (expected == actual) return;
        fail("expected:" + expected + ", actual:" + actual);
    }
    public static void assertEquals(double expected, double actual) {
        assertEqualsDouble(expected, actual);
    }
    private static void assertEqualsDouble(double expected, double actual) {
        if (expected == actual) return;
        fail("expected:" + expected + ", actual:" + actual);
    }
    public static void assertEquals(Object expected, Object actual) {
        if (expected == actual) return;
        if (expected != null && expected.equals(actual)) return;
        fail("\nexpected:" + expected + "\n  actual:" + actual);
    }

    public static void main(String[] args) throws Exception {
        assertTrue(true);
        assertNever(false);
        assertTrue(false == false);
        assertTrue(false != true);
        assertTrue(false ^ true);
        assertNever(true ^ true);
        assertEquals(false, false);
        assertEquals(0, 0);
        assertEquals(0x30, '0');
        assertEquals(0x4e2d, '\u4e2d');
        assertEquals(0x4e2d, 'жа');
        assertEquals(0, 0.0);
        assertEquals(0.0F, 0.0);
        assertEquals(null, null);
        assertEquals("01", "0" + "1");
        assertNever(new Object().equals(new Object()));
        assertNever(new int[]{1}.equals(new int[]{1}));
    }
}
