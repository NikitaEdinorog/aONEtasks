/**
 * Class solves (1/n!)*(1!+2!+...+n!)
 *
 * @uathor  Nikita Bondar
 */

package Task2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class FunctionCalculator {

    public FunctionCalculator() {};

    /**
     * Calculates (1/n!)*(1!+2!+...+n!) -> (1! + 2! + ... + !n)/(n!)
     *
     * @param number - calculated number
     * @return
     */
    public BigDecimal calculateFunction(long number) {

        if (number <= 1) return BigDecimal.valueOf(-1);

        BigDecimal numberFactorial = new BigDecimal(calculateFactorial(number));
        BigDecimal sumOfFactorials = new BigDecimal(calculateSumOfFactorials(number));

        return sumOfFactorials.divide(numberFactorial, 6, RoundingMode.HALF_UP);
    }


    /**
     * Calculates 1! + 2! + ... + n!
     *
     * @param number - calculated number
     * @return - n!
     */
    public BigInteger calculateSumOfFactorials(long number) {

        if (number < 0) return BigInteger.valueOf(-1);
        if (number == 1 || number == 0) return BigInteger.valueOf(1);

        return calculateFactorial(number).add(calculateSumOfFactorials(number - 1));


    }

    /**
     * Calculates n!
     *
     * @param number - calculated number
     * @return - n!
     */
    public static BigInteger calculateFactorial(long number) {
        if (number < 0) return BigInteger.valueOf(-1);
        if (number == 1 || number == 0) return BigInteger.valueOf(1);

        return BigInteger.valueOf(number).multiply(calculateFactorial(number - 1));
    }
}
