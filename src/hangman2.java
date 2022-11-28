import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class hangman2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" ___Let's Play Hangman___");
		
		File WordGenerator = new File("C:\\Users\\MINHAJ MUNNA\\eclipse-workspace\\First Project\\Lab 1\\Hangman\\src\\dictonary\\dictonary");

		Scanner Random_Word = new Scanner(WordGenerator);
		Scanner input = new Scanner(System.in);

		ArrayList<String> words = new ArrayList<>();

		while ( Random_Word.hasNextLine()) {
			words.add( Random_Word.nextLine());

		}

		String Secret_Word = words.get((int) (Math.random() * words.size()));
		char[] textArray = Secret_Word.toCharArray();
		System.out.println( "\n"+" The word has " + Secret_Word.length() + " letters.");
		System.out.println(" And you have 7 lives");
		System.out.println("    Guess a letter :");

		// System.out.println(Secret_Word);
		char[] guessed_letter = new char[textArray.length];
		
		for (int i = 0; i < textArray.length; i++) {
			guessed_letter[i] = '?';

		}
		boolean finished = false;
		int lives = 7;
		while (finished == false) {
			System.out.println("________________________________________________________");
			String letter = input.next();
			// check for valid input
			while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
				System.out.println("Error Input - Try again");
				letter = input.next();
			}
			// check if the letter is in the word
			boolean found = false;
			for (int i = 0; i < textArray.length; i++) {
				if (letter.charAt(0) == textArray[i]) {
					guessed_letter[i] = textArray[i];
					found = true;
				}

			}
			if (!found) {
				lives--;

				System.out.println("You've gueesed a Wrong Letter");

			}
			boolean done = true;
			for (int i = 0; i < guessed_letter.length; i++) {
				if (guessed_letter[i] == '?') {
					System.out.print(" _ ");
					done = false;
				} else {
					System.out.print(" " + guessed_letter[i]);
				}
			}
			System.out.println("\n" + "Lives remaining : " + lives);
			drawHangman(lives);
			// check if the game ends
			if (done) {
				System.out.println("\n" + " CONGRATULATIONS you guessed it CORRECT !");
				finished = true;
				int Score = 0;
				System.out.println("\n"+ "      YOUR SCORE IS: "+ Secret_Word.length()* lives);
			}
			if (lives <= 0) {
				System.out.println("\n" +"OOPS! You Lose the game. Better luck next time ");
				System.out.println("\n" +"The Secret word was:  " + (Secret_Word) );
				finished = true;
				
				}
			
			}
		
 }

       public static void drawHangman(int l) {
    	   
		if (l == 6)
            System.out.println("\t________\n\t|   |\n\t|\n\t|\n\t|\n\t|\n\t|\n\t|\n=================");
        else if (l == 5)
            System.out.println("\t________\n\t|   |\n\t|   O\n\t|\n\t|\n\t|\n\t|\n\t|\n=================");
        else if (l == 4)
            System.out.println("\t________\n\t|   |\n\t|   O\n\t|  \\\n\t|\n\t|\n\t|\n\t|\n=================");
        else if (l == 3)
            System.out.println("\t________\n\t|   |\n\t|   O\n\t|  \\ /\n\t|\n\t|\n\t|\n\t|\n=================");
        else if (l == 2)
            System.out.println("\t________\n\t|   |\n\t|   O\n\t|  \\|/\n\t|   |\n\t|\n\t|\n\t|\n=================");
        else if (l == 1)
            System.out.println("\t________\n\t|   |\n\t|   O\n\t|  \\|/\n\t|   |\n\t|  /\n\t|\n\t|\n=================");
        else if (l == 0)
            System.out.println("\t________\n\t|   |\n\t|   O\n\t|  \\|/\n\t|   |\n\t|  / \\\n\t|\n\t|\n=================");
	
		
		}

  }


	


