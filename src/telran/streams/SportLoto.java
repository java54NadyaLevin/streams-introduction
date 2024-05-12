package telran.streams;

import java.util.Arrays;
import java.util.Random;

record Settings(int from, int to, int amount) {
};

public class SportLoto {

	public static void main(String[] args) {
		try {
			Settings set = getSettings(args);
			generateArray(set);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void generateArray(Settings set) {
		int[] ar = new Random().ints(set.amount(), set.from(), set.to() + 1).toArray();
		Arrays.stream(ar).forEach(n -> System.out.print(n + " "));

	}

	private static Settings getSettings(String[] args) throws Exception {
		if (args.length < 3) {
			throw new Exception("All fields are mandatory");
		}

		int from = getValue(args[0]);
		int to = getValue(args[1]);
		int amount = getValue(args[2]);
		return new Settings(from, to, amount);
	}

	private static int getValue(String string) throws Exception {
		try {
			int res = Integer.parseInt(string);
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("All values must be integers");
		}

	}

}
