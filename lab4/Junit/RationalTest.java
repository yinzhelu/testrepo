import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
	assertEquals(new Rational(1, -3), new Rational(-2, 6));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testRoot() {
        Rational s = new Rational( -1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }

    public void testDivide() {
        assertEquals(new Rational(2, 3).divides(new Rational(1, 3)), new Rational(2, 1));
        assertEquals(new Rational(0, 3).divides(new Rational(2, 3)), 0);
	assertEquals(new Rational(2, 3).divides(new Rational(1, 3)), 2);
    }
    
    public void testMultiply() {
	assertEquals(new Rational(5, 7).times(new Rational(1, -3)), new Rational(-5,21));
    }

    public void testMinus() {
	assertEquals(new Rational(2,3).minus(new Rational(-1, -3)), new Rational(1, 3));
    }

    public void testPlus() {
	assertEquals(new Rational(2,2).plus(new Rational(4, 9)), new Rational(13, 9));
    }

    public void testAbs() {
        assertEquals(new Rational(0, 2).abs(), 0);
	assertEquals(new Rational(0,-3).abs(), 0);
    }

    public void testToString(){
	assertEquals(new Rational(0, 2).toString(), "0/2");
        assertEquals(new Rational(-2, 1).toString(), "-2");
        assertEquals(new Rational(-2, -5).toString(), "-2/-5");
    }

    public void testLessThan(){
	assertTrue(new Rational(0, 3).isLessThan(new Rational(-3, -5)));
    }

    public void illegalSquareRoot() {
        Rational s = new Rational( -1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }

    public void testMain() {
        String[] parameter = new String[1];
        parameter[0] = "ok";
	Rational x = new Rational(1, 4);
        x.main(parameter);
        x.setTolerance(new Rational(2,3));
    }

    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}

