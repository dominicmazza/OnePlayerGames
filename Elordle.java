import java.util.ArrayList;

public class Elordle implements OnePlayerGame {
	private String target;
	private int tries;
	private String word;
	private ArrayList<Integer> guesses;
	
	public void setTarget(String target) {
		if (target == null) {
			this.target = "";
		}
		else if (target.contains(" ")) {
			String[] words = target.split(" ");
			this.target = words[0];
		}
		else {	
			this.target = target; 
		}
	}
	
	public void setTries() {
		tries = 6;
	}
	
	public void setWord(String word) {
		if (word == null || word.length() != 5 || word.equals("")) {
			this.word = "";
			for (int i = 0; i < 5; ++i) {
				this.word += "-";
			}
		}
		else {
			this.word = word;
			}
		}
	
	public void setGuesses() {
		guesses = new ArrayList<Integer>();
	}
	

	Elordle(String target){
		setTarget(target);
		setTries();
		setWord("");
		setGuesses();
	}
	

	
	@Override
	public void makePlay(String word_guessed) {
		if (!word_guessed.equals(target)) {
			guesses.add(1);
		}
		for (int i = 0; i < target.length(); ++i) {
			if (Character.isLowerCase(word.charAt(i))) {
				word = word.substring(0, i) + "-" + word.substring(i + 1);
			}
			String guessed_letter = Character.toString(Character.toLowerCase(word_guessed.charAt(i)));
			char guessed_letter1 = word_guessed.charAt(i);
			String target_letter = Character.toString(Character.toLowerCase(target.charAt(i)));
			char target_letter1 = target.charAt(i);
			if (guessed_letter.equals(target_letter)){
				word = word.substring(0, i) + Character.toUpperCase(target_letter1) + word.substring(i + 1);
			}
			else if (target.contains(guessed_letter)) {
				word = word.substring(0, i) + Character.toLowerCase(guessed_letter1) + word.substring(i + 1);
			}
			else if (!target.contains(guessed_letter) && !guessed_letter.equals(target_letter)){
				word = word.substring(0, i) + "-" + word.substring(i + 1);
			}
		}
	}


	@Override
	public boolean valid(String word_guessed) {
		if (word_guessed.length() == 5) {
			return true;
		}
		else {
			System.out.println("Not 5 letter word");
			return false;
		}
	}

	@Override
	public boolean over() {
		boolean lower = false;
		for (int i = 0; i < word.length(); ++i) {
			char chr = word.charAt(i);
			if (Character.isLowerCase(chr)) {
				lower = true;
				break;
			}
			else {
				lower = false;
			}
			
		}
		if (word.equals(target) || !word.contains("-") && (!lower)) {
			System.out.println("You won!");
			return true;
		}
		if (guesses.size() >= tries) {
			System.out.println("You lost :(");
			System.out.print("The word was: " + target);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String gameState() {
		String state = "";
		state += ("Word: " + word + "\n");
		int numguessleft = tries - guesses.size();
		state += ("Guesses left: " + numguessleft + "\n");
		return state;
	}
	
	

}
