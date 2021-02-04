package hagnmangame2;

import java.util.Scanner;

public class HagnmanGame2 {

    
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Hangman!");
		System.out.println("Please enter the phrase or word to be used for this game (player 2, do not look!):");
		String phrase = input.nextLine(); 
		phrase = phrase.trim(); 
		phrase = phrase.replaceAll(" ", "  ");
		phrase = phrase.toUpperCase();
		String phrase1 = phrase.replaceAll("[A-Z]", "_ ");
	
		 
		System.out.print("\n"); 
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("\n");
		System.out.println("Okay, let's play! Here is the board:");
		int attempts = 0;
		int incorrect = 0;
		String guess;
		char letter;
		boolean guessescontainsguess;
		String guesses = "";
		boolean phrasecontainsguess;
		while (incorrect < 5 && phrase1.contains("_")) {
			System.out.println(phrase1);
			System.out.print("\n");
			System.out.println("You have " + incorrect + " incorrect guesses so far.");
			System.out.print("\n");
			if (incorrect == 1) { 
				System.out.println("         ____________");
				System.out.println("        |      |     |");
				System.out.println("        |      O     |");
				System.out.println("        |            |");
				System.out.println("        |            |");
				System.out.println("        |            |");
				System.out.println("         ____________");
				System.out.print("\n");
			} else if (incorrect == 2) { 
				System.out.println("         ____________");
				System.out.println("        |      |     |");
				System.out.println("        |      O     |");
				System.out.println("        |      |     |");
				System.out.println("        |            |");
				System.out.println("        |            |");
				System.out.println("         ____________");
				System.out.print("\n");
			} else if (incorrect == 3) { 
				System.out.println("         ____________");
				System.out.println("        |      |     |");
				System.out.println("        |      O     |");
				System.out.println("        |     -|-    |");
				System.out.println("        |            |");
				System.out.println("        |            |");
				System.out.println("         ____________");
				System.out.print("\n");
			} else if (incorrect == 4) {
				System.out.println("         ____________");
				System.out.println("        |      |     |");
				System.out.println("        |      O     |");
				System.out.println("        |     -|-    |");
				System.out.println("        |      |     |");
				System.out.println("        |            |");
				System.out.println("         ____________");
				System.out.print("\n");
			}
			System.out.println("Guess a letter:");
			guess = input.nextLine(); 
			guess = guess.toUpperCase(); 
			letter = guess.charAt(0); 
			guessescontainsguess = (guesses.indexOf(letter)) != -1;
			guesses += letter; 
			letter = Character.toUpperCase(letter); 
			System.out.print("\n");
			if (guessescontainsguess == true) {
				System.out.println("You ALREADY guessed " + letter + ".");
				System.out.print("\n");
				if (incorrect > 0) { 
					incorrect--;
				} 
			} 
			phrasecontainsguess = (phrase.indexOf(letter)) != -1;
			if (phrasecontainsguess == true) { 
				System.out.println(letter + " is in the phrase.");
				System.out.print("\n");
				for (int position = 0; position < phrase.length(); position++) {
					if (phrase.charAt(position) == letter && phrase1.charAt(position) != letter) {
						
						phrase1 = phrase1.replaceAll("_ ", "_");
						String phrase2;
						phrase2 = phrase1.substring(0, position) + letter + phrase1.substring(position + 1);
						phrase2 = phrase2.replaceAll("_", "_ ");
						phrase1 = phrase2;
					} 
				} 
			} else { 
				System.out.print("\n");
				System.out.println(letter + " is in not the phrase."); 
				System.out.print("\n");
				incorrect++; 
			}
			attempts++; 
		} 
		if (incorrect == 5) { 
			System.out.println("         ____________");
			System.out.println("        |      |     |");
			System.out.println("        |      O     |");
			System.out.println("        |     -|-    |");
			System.out.println("        |      |     |");
			System.out.println("       	|     / \\    |");
			System.out.println("         ____________");
			System.out.print("\n");
			System.out.println("Sorry, youíve reached your maximum number of incorrect guesses. GAME OVER!");
		} else {
			System.out.println("The phrase is:"); 
			System.out.println(phrase1);
			System.out.println("CONGRATULATIONS, you solved it!");
		}
		input.close(); 
	}
}

    
    

