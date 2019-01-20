package BAITAP;
import junit.framework.Test;
import BAITAP.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.assertEquals;

import Viettel.DMSDEMO.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	Baitap a = new Baitap();
    	//assertEquals("Phương trình vô nghiệm af", a.giaiptb2(2,3,4));
    	//assertEquals(true, a.ktsonguyento(2));
    	//assertEquals(1060, a.tongsonguyento());
    	//assertEquals("So chan: 1 So le: 24", a.demsonguyentochanle());
    	assertEquals("So chan: 1 So le: 24", a.demsonguyentochanle1());
    }
}
