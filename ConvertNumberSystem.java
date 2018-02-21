/**
 * This class provides method to convert a number from one number system to
 * another.
 * 
 * @author Hackerry
 *
 */
public class ConvertNumberSystem {
    /**
     * Used to convert one system to another
     * 
     * @param args
     *            args[0] - number to be converted 
     *            args[1] - number system this number is in 
     *            args[2] - number system to convert
     */
    public static void main(String[] args) {
        if (args.length < 3)
            printUsage(null);

        String number = args[0].trim();

        int from = -1, dest = -1;
        try {
            from = Integer.parseInt(args[1]);
            dest = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            printUsage("Number system should be digit");
        }

        if (from < 2 || dest < 2)
            printUsage("Number system should be no less than 2");

        int base10 = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (!Character.isDigit(c) && !Character.isAlphabetic(c))
                printUsage("Illegal digit");
            if (Character.isDigit(c)) {
                if (c - '0' >= from)
                    printUsage("Illegal digit in number system base-" + from);
                else {
                    base10 += (c - '0') * Math.pow(from, number.length() - i - 1);
                }
            } else {
                if (Character.toUpperCase(c) - 'A' + 10 >= from)
                    printUsage("Illegal digit in number system base-" + from);
                else {
                    base10 += (Character.toUpperCase(c) - 'A' + 10) * Math.pow(from, number.length() - i - 1);
                }
            }
        }
        // System.out.println(base10);

        String output = "";
        while (base10 != 0) {
            int remainder = base10 % dest;
            output = remainder + output;
            base10 /= dest;
        }
        System.out.println("Output: " + (output.equals("") ? 0 : output));
    }

    private static void printUsage(String message) {
        if (message != null)
            System.err.println(message + "\n************************");
        System.err.println("Usage:");
        System.err.println("args: [number] [from number system] [dest number system]");
        System.err.println("[number]: in digit and alphabetic character");
        System.err.println("[number system]: base of this system, no less than 2");
        System.err.println("Currently not support negative number");
        System.exit(0);
    }
}
