import java.util.Scanner;
import java.util.regex.Pattern;
/**
* [cerner_2tothe5th_2022]
* cerner_2^5_2022
*
* Day 2 : simple recursive power function, that will print the result of the given base and exponent.
*
*/
public class FindPower {

    // Calculate the power of the number given.
    public static int findPower(final int base, int exponent, int sum) {
        if (exponent == 1) {
            return sum;
        }
        else {
            sum = sum * base;
            return findPower(base, exponent-1, sum);
        }
    }

    // Convert String to int.
    public static int parseInt(String toConvert) {
        return Integer.parseInt(toConvert);
    }

    // Driver method
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        int base = 2;
        int exponent = 5;
        int result = findPower(base, exponent, base);
        System.out.printf("\nIn honor of Programming day, here is the answer to 2^5: %s", result);

        // Take user input after simple example.
        System.out.print("\n\nYou can input your own example if you'd like.\nPlease enter your own problem(Ex. 5^7): ");
        final String[] userInput = scanner.nextLine().split(Pattern.quote("^"));

        System.out.printf("\n\nThe answer to your input problem is: %s", findPower(parseInt(userInput[0]), parseInt(userInput[1]), parseInt(userInput[0])));
        scanner.close();
    }
}