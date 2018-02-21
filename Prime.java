import java.util.ArrayList;

/**
 * This class provides some operations on primes
 * 
 * @author Hackerry
 *
 */
public class Prime {
    /**
     * Use Sieve of Eratosthenes algorithm to generate all primes within the range
     * 
     * @param number
     *            specified range
     * @return an ArrayList containing all primes within this range
     */
    public static ArrayList<Integer> primes(int number) {
        ArrayList<Integer> list = new ArrayList<>();

        if (number <= 1)
            return list;

        boolean[] primes = new boolean[number + 1];

        int start = 2;
        list.add(start);
        while (start <= number) {
            int i = start;
            while (i <= number) {
                primes[i] = true;
                i += start;
            }

            while (++start <= number && primes[start])
                ;
            if (start <= number)
                list.add(start);
        }

        return list;
    }

    /**
     * Test whether a number is prime
     * 
     * @param number
     *            test number
     * @param show
     *            whether to show detail of the information
     * @return whether this number is a prime
     */
    public static boolean testPrime(int number, boolean show) {
        if (number <= 0) {
            if (show)
                System.out.println(number + " is not a prime as it's non-positive");
            return false;
        } else if (number == 1) {
            if (show)
                System.out.println(number + " is neither a prime nor a composite");
            return false;
        }

        int max = (int) Math.sqrt(number);

        int start = 2;
        while (start <= max) {
            if (number % start == 0) {
                if (show)
                    System.out.println(number + " is not a prime: " + start + " x " + number / start + " = " + number);
                return false;
            }

            start++;
        }

        if (show)
            System.out.println(number + " is a prime");
        return true;
    }

    public static void main(String[] args) {
        testPrime(0, true);
    }
}
