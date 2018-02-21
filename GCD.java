/**
 * This class is used to compute the GCD(greatest common divisor) of two
 * positive numbers
 * 
 * @author Hackerry
 *
 */
public class GCD {
    /**
     * Use Euclidean algorithm to find GCD
     * 
     * @param a
     *            one number
     * @param b
     *            another number
     * @return greatest common divisor
     */
    public static int gcd(int a, int b) {
        if (a <= 0 || b <= 0) {
            System.out.println("Should be positive integers");
            return 0;
        }

        if (a % b == 0)
            return b;

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Should include 2 positive integers in argument");
            return;
        }
        System.out.println(gcd(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
    }
}
