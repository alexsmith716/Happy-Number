import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

// https://github.com/alexsmith716/Happy-Numbers
// given a positive whole number, determine whether that number is happy or unhappy
// a happy number is a number that eventually reaches 1 when replaced by the sum of the square of each digit
// to check whether a number is happy, compute the square of each digit of the number until it results in 1
// a happy number will have a 1 in its sequence. a unhappy number will have a 4 in its sequence
// all positive whole numbers are either happy or unhappy
// happy numbers: 1, 7, 10, 13, 19, 23, 28, 31, 32, 100, 320...

public class HappyNumber {

	public static boolean testIfHappyNumber(int number) {
		Set<Integer> resSquared = new HashSet<Integer>();
		// add result of the square of each digit (all unique and a `1` item will indicate "Happy")
		while (resSquared.add(number)){
			int value = 0;
			int remainder = 0;
			// for as a long as each number is a positive whole number
			while (number > 0){
				// calculate the square of each digit present in `number`
				remainder = number % 10;
				// add calculated square to var `value`
				value = value + (remainder*remainder);
				number = number / 10;
			}
			number = value;
		}
		return number == 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number;
		while(true) {
			try {
				System.out.print("Enter Positive Whole Number To Test If Happy: ");
				number = scanner.nextInt();
				if(number < 0) {
					throw new java.util.InputMismatchException();
				}
				if(testIfHappyNumber(number)) {
					System.out.println("IS " + number + " Happy?: " + " >> YES");
				} else {
					System.out.println("IS " + number + " Happy?: " + " >> NO");
				}
			} catch(java.util.InputMismatchException e) {
				System.out.println("Invalid input! That was not a Positive Whole Number.");
				scanner.nextLine();
			}
		}
	}
}
