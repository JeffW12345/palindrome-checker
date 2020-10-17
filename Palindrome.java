/*
 * A palindrome is a word or phrase whose letters are the same when read forwards as backwards. 
 * 
 * This program takes a user input and tells the user whether the word or phrase they've entered is a palindrome
 */

import java.util.Scanner;

public class Palindrome {

	private static String userInput;
	private static boolean validSelectionMade = false;

	/*
	 * This method checks if the user's inputted word or phrase is a palindrome. The
	 * non-letter characters have been removed from 'wordOrPhrase' prior it being
	 * passed to this method.
	 */

	private static boolean isPalindrome(String wordOrPhrase) {
		int length = wordOrPhrase.length();
		char[] wordOrPhraseAsArray = new char[length];
		wordOrPhrase.getChars(0, length, wordOrPhraseAsArray, 0);
		/*
		 * Starts with the start and end letters and checks if they are equivalent. Then
		 * checks if the letter to the right of the first letter is the same as the
		 * character to the left of the final character, and so on.
		 * 
		 * This ends when the two letters in the middle are compared against each other
		 * (in the case of there being an even number of letters) or when the two
		 * letters either side of the letter in the middle are compared (in the case of
		 * there being an odd number of letters)
		 */
		int count = 0;
		while (count < length / 2) {
			if (wordOrPhraseAsArray[count] != wordOrPhraseAsArray[length - count - 1]) {
				return false;
			}
			count++;
		}
		return true; // If 'false' hasn't been returned, it must be a palindrome.
	}

	/*
	 * Requests user input. Asks user to try again if they press 'return' without
	 * entering a value or if they enter a word or phrase containing less than two
	 * letters.
	 * 
	 */

	public static void getUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word or phrase to check: ");
		String wordOrPhrase = scanner.nextLine();
		if (wordOrPhrase.length() < 1) {
			System.out.println("You did not enter anything. Please try again.");
			getUserInput();
		}
		if (!containsMinTwoLetters(wordOrPhrase) && !validSelectionMade) {
			System.out.println("You need to enter a word or phrase with at least two letters.");
			System.out.println("Please try again.");
			getUserInput();
		}
		if (wordOrPhrase.length() >= 1 && containsMinTwoLetters(wordOrPhrase)) {
			userInput = wordOrPhrase;
			validSelectionMade = true;
		}
		scanner.close();
	}

	// Returns false if there are less than two A-Z and a-z characters, and true
	// otherwise.

	private static boolean containsMinTwoLetters(String wordOrPhraseRaw) {
		String lettersOnlyLowerCase = wordOrPhraseRaw.replaceAll("[^a-zA-Z]", ""); // No non-letter characters
		if (lettersOnlyLowerCase.length() < 2) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("PALINDROME CHECKER");
		System.out.println("------------------\n");
		getUserInput();
		// Word or phrase removed of non-letter characters and made lower case.
		String lettersOnlyLowerCase = userInput.replaceAll("[^a-zA-Z]", "").toLowerCase();
		if (isPalindrome(lettersOnlyLowerCase)) {
			System.out.println("\'" + userInput + "\' is a palindrome");
		} else {
			System.out.println("\'" + userInput + "\' is NOT a palindrome");
		}
	}
}
