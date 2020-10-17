import java.util.Scanner;

public class Palindrome {

	private static boolean isPalindrome(String wordOrPhrase) {
		int length = wordOrPhrase.length();
		char[] destArray = new char[length];
		wordOrPhrase.getChars(0, length, destArray, 0); // Copies string to array 'destArray'
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
			if (destArray[count] != destArray[length - count - 1]) {
				return false;
			}
			count++;
		}
		return true; // If 'false' hasn't been returned, it must be a palindrome.
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("PALINDROME CHECKER");
		System.out.println("------------------\n");
		System.out.println("Enter a word or phrase to check: ");
		String wordOrPhraseRaw = userInput.nextLine();
		// Word or phrase removed of non-letter characters and made lower case.
		String lettersOnlyLowerCase = wordOrPhraseRaw.replaceAll("[^a-zA-Z]", "").toLowerCase();
		if (isPalindrome(lettersOnlyLowerCase)) {
			System.out.println("\'" + wordOrPhraseRaw + "\' is a palindrome");
		} else {
			System.out.println("\'" + wordOrPhraseRaw + "\' is NOT a palindrome");
		}
		userInput.close();
	}
}
