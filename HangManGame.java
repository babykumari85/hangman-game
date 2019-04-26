import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class HangManGame {
	public static void main(String args[]) {
		System.out.println("Player1");
		System.out.println("Enter the word you want guessed:");
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		int wordLength = word.length();
		int noOfChance = wordLength;
		int count = 0;

		System.out.println("Player2");
		System.out.println("You have " + noOfChance + " chances to guess the word.");
		System.out.println("With every wrong guess, you will lose 1 chance.");
		System.out.println("Chance remaining:: " + noOfChance);
		System.out.println("WORD ::");
		char[] matchedChars = new char[wordLength];
		String wrongGuess = "";

		for (int i = 0; i < wordLength; i++) {
			matchedChars[i] = '-';
			System.out.print("-");
		}

		System.out.println();

		boolean isDone = false;
		do {
			System.out.println();
			System.out.println("Enter the letter to guess:");
			String letter = scan.nextLine();

			if (letter.length() != 1) {
				System.out.println(letter + " is not valid guess!");
				continue;
			}

			try {
				int x = Integer.parseInt(letter);

				if (x >= 0 && x <= 9) {
					System.out.println(letter + " is not valid guess!");
					continue;
				}
			} catch (NumberFormatException e) {

			}

			char ch = letter.charAt(0);
			boolean charFound = false;

			for (int i = 0; i < wordLength; i++) {
				char c = word.charAt(i);
				if (ch == c) {
					matchedChars[i] = c;
					charFound = true;
					count++;

				}

			}

			if (charFound) {

				System.out.println("Chance reamining " + noOfChance);
				System.out.print("Word:: ");
				for (int i = 0; i < wordLength; i++) {
					System.out.print(matchedChars[i]);

				}
			} else {
				noOfChance--;
				wrongGuess += ch;
				System.out.println("Wrong guess!");
				System.out.println("Chance reamining " + noOfChance);
				System.out.println("Wrong Guesses :: " + wrongGuess);
			}

			if (count == wordLength) {
				System.out.println("");
				System.out.println("Congrats . You WON! ");
				System.out.println("You have correctly guess the word " + word);
				isDone = true;
			}

			if (noOfChance == 0) {
				System.out.println("Oops you have no chance remaining. You lose");
				isDone = true;
			}

		} while (isDone == false);

	}
}
