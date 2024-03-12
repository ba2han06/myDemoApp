package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

     public static boolean search(int[] arr1, int [] arr2, int start, int end) { //between specified indexes, the method returns if the sum of arrays is equal
     if (arr1 == null || arr2 == null || start < 0 || end < start || end >= arr1.length || end >= arr2.length) {
            return false;
     }
     int sum1 = 0;
     int sum2 = 0;
     for(int i = 0; i <= end; i++) {
        sum1 += arr1[i];
	sum2 += arr2[i];
     }
     if (sum1 == sum2)
	return true;
     return false;        
     }
}
