import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;


public class Play {

	public static void main(String[] args) {
		String box = chooseRandomWord();;
		String word = box.toLowerCase();

		Scanner input = new Scanner(System.in);
		System.out.print("Which game would you like to play?\nSnowman or Elordle?\n");  
		String choice= input.nextLine();  
		
		
		if (choice.equals("Snowman")) {
			OnePlayerGame myGame = new Snowman(word);
			playGame(myGame, input);
		}
		if (choice.equals("Elordle")) {
			OnePlayerGame myGame = new Elordle(word);
			playGame(myGame, input);
		}
		else if (!choice.equals("Elordle") && (!choice.equals("Snowman"))) {
			System.out.println("Not a valid game.");
		}
		}


	public static void playGame(OnePlayerGame myGame, Scanner scnr) {
		System.out.println(myGame.gameState());
		while (!myGame.over()){
			Scanner sc= new Scanner(System.in); 
			System.out.print("Make a guess: ");  
			String str= sc.nextLine();  
			if (myGame.valid(str) == true) {
				myGame.makePlay(str);
			}
			else {
				System.out.println("Invalid guess!!\n");
			}
			System.out.println(myGame.gameState());
		}
	}
		
	// Code below here provided for selecting a random word.
	// You should ONLY edit the filename variable in chooseRandomWord below here!
	// ---------------------------------------------------------------------------------------
	public static String chooseRandomWord() {
		String filename = "dictionary5chars.txt";
		Scanner file = getFileScanner(filename);
		int countLines = 0;
		while (file.hasNextLine()) {
			file.nextLine();
			countLines++; 
		}
		int randLine = (int)(Math.random() * countLines);

		file = getFileScanner(filename);
		int curLine = 0;
		while (file.hasNextLine()) {
			String word = file.nextLine();
			word = "frond";
			if(curLine == randLine) {
				return word;
			}
			curLine++; 
		}

		return "";
	}

	public static Scanner getFileScanner(String fileName) {
		try {
			FileInputStream textFileStream = new FileInputStream(fileName);
			Scanner inputFile = new Scanner(textFileStream);
			return inputFile;
		}
		catch (IOException ex) {
			System.out.println("Warning: could not open " + fileName);
			return null;
		}
	}
}
