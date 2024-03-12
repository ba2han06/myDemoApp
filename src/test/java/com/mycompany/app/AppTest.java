package com.mycompany.app;
import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    public void testFound() {
      int[] array1 = {4, 2, 3};
      int[] array2 = {1, 3, 5};
      assertTrue(new App().search(array1, array2, 0, 2));
    }

    public void testNotFound() {
      int[] array1 = {1, 2, 3};
      int[] array2 = {4, 5, 7};
      assertFalse(new App().search(array1, array2, 0, 2));
    }

    public void testNegativeArray() {
      int[] array1 = {-1, -2, -3, -4};
      int[] array2 = {-5, -6, -7, -8};
      assertFalse(new App().search(array1, array2, 1, 3));
    }

    public void testNull() {
      assertFalse(new App().search(null, null, 0, 3));
    }

    public void outRangeArray() {
      int[] array1 = {1, 2, 3};
      int[] array2 = {4, 5, 6};
      assertFalse(new App().search(array1, array2, 0, 3));
    }
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
        assertTrue( true );
    }
}
