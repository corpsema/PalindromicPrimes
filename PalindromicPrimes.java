/**
 * A palindromic number is a number that is the same when written forwards or backwards. This program creates
 * palindromic prime numbers to display the first 100 palindromic prime number, 10 per line.
 *
 * @author Mohammad Abdulhussain
 * 
 */

import java.lang.Integer;
import java.lang.Math;


public class PalindromicPrimes
{
    /**
     * This is a method to create a while loop to check if the current number is a valid palindromic prime number, to
     * loop 100 times, and increment the total to output the total number of totalNumbersPrinted
     * @param args
     */
    public static void main(String[] args)
    {
        // total number of numbers that have been printed
        int totalNumbersPrinted = 0;
        // start checking numbers at 0
        int currentNumber = 0;

        // print the first 100 numbers
        while (totalNumbersPrinted < 100)
        {
            // test that current number is valid
            if (isPrime(currentNumber) && isPalindromic(currentNumber))
            {
                // print the valid number
                System.out.print(currentNumber);

                // increment the total
                totalNumbersPrinted++;

                // print newline or space,
                // depending on the total number of numbers printed
                System.out.print(totalNumbersPrinted % 10 == 0 ? "\n" : " ");
            }

            // go to next number
            currentNumber++;
        }
    }

    /**
     * This method determines if the number is a prime number
     * @param value
     * @return
     */
    private static boolean isPrime(int value)
    {
        // special case, primes must be >= 2
        if (value < 2)
        {
            return false;
        }

        // loops through all possible divisors
        for (int i = 2; i <= value / 2; i++)
        {
            // check if value can be divided without remainder
            if (value % i == 0)
            {
                // if the value is not prime, return false
                return false;
            }
        }

        // if the value is prime, return true
        return true;
    }

    /**
     * This method determines whether the number is a palindromic number which is, whether they are written forward
     * or background, are the same number. It converts the input to a String, and calculates the length of the number,
     * it then compares all the letters, starting from the beginning to the end, and returns false when it is not
     * palidrome and returns true when it is
     *
     * @param value
     * @return
     */
    private static boolean isPalindromic(int value)
    {
        // converts to String
        String valueAsString = Integer.toString(value);

        // length of number
        int valueLength = valueAsString.length();

        // all single digit values are palindromic
        if (valueLength <= 1)
        {
            return true;
        }

        // compare all the letters starting at the beginning and end, moving to the middle
        for (int i = 0; i < Math.floor(valueLength / 2); i++)
        {
            if (valueAsString.charAt(i) != valueAsString.charAt(valueLength - i - 1))
            {
                // letter at symmetrical point did not match, therefore they are not palindrome
                return false;
            }
        }
        // if the value is palindromic, returns true
        return true;
    }
}
