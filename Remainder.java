/**
 * This class compute remainder of a number
 * @author Hackerry
 *
 */
public class Remainder {
    /**
     * Compute the remainder within the common range
     * @param a dividend
     * @param b divisor
     * @return remainder in common range
     */
	public static int remainder(int a, int b) {
	    if(b == 0) throw new IllegalArgumentException("Divisor should not be 0");
	    
		int mul = a/b;
		int rem = a-b*mul;

		if(rem < 0) {
			rem += Math.abs(b);
		}

		return rem;
	}

	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Should include 2 integers as arguments.");
			return;
		}

		System.out.println(remainder(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}
}