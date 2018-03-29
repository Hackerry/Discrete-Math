public class Pascal {
	public static void printPascal(int limit) {
		if(limit <= 0) throw new IllegalArgumentException();
		if(limit >= 1) System.out.println(1);
		if(limit >= 2) System.out.println("1 1");

		if(limit <= 2) return;

		int[] prevLine = new int[]{1,1};
		int[] currLine;
		
		for(int i = 2; i < limit; i++) {
			currLine = new int[i+1];
			currLine[0] = 1; currLine[i] = 1;
			System.out.print("1 ");
			for(int j = 1; j < i; j++) {
				currLine[j] = prevLine[j-1] + prevLine[j];
				System.out.print(currLine[j] + " ");
			}
			System.out.println(1);
			prevLine = currLine;
		}
	}

	public static void printPascalMod(int limit, int mod, boolean show) {
		if(mod == 0) throw new IllegalArgumentException("Modulo cannot be 0");

		if(limit <= 0) throw new IllegalArgumentException();
		if(limit >= 1) System.out.println(show? ".": "1");
		if(limit >= 2) System.out.println(show? ". .": "1 1");

		if(limit <= 2) return;

		int[] prevLine = new int[]{1,1};
		int[] currLine;
		
		for(int i = 2; i < limit; i++) {
			currLine = new int[i+1];
			currLine[0] = 1; currLine[i] = 1;
			System.out.print((show? ".": "1") + " ");
			for(int j = 1; j < i; j++) {
				currLine[j] = (prevLine[j-1] + prevLine[j]) % mod;
				if(currLine[j] == 1) System.out.print((show? ".": "1") + " ");
				else System.out.print((show? "*": "0") + " ");
			}
			System.out.println(show? ".":"1");
			prevLine = currLine;
		}
	}

	public static void main(String[] args) {
		if(args.length < 1) throw new IllegalArgumentException("Please enter limit");
		else if(args.length == 1) printPascal(Integer.parseInt(args[0]));
		else if(args.length == 2) printPascalMod(Integer.parseInt(args[0]), Integer.parseInt(args[1]), false);
		else if(args.length == 3) printPascalMod(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Character.toLowerCase(args[2].charAt(0)) == 't');
	}
}