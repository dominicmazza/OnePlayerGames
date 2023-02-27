import java.util.ArrayList;

public class Snowman implements OnePlayerGame{
	private String target;
	private int tries;
	private String word;
	private String guesses;
	
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
	
	public void setTries(int tries) {
		if (tries <= 0 || tries > 26) {
			this.tries = 7;
		}
		else {
			this.tries = tries;
		}
	}
	
	public void setWord(String word) {
		if (word == null || word.length() != target.length() || word.equals("")) {
			this.word = "";
			for (int i = 0; i < target.length(); ++i) {
				this.word += "-";
			}
		}
		else {
			this.word = word;
			}
		}
	
	public void setGuesses(String guesses) {
		if (guesses == null) {
			this.guesses = ""; 
		}
		else {
			this.guesses = guesses;
		}
	}
	
	
	
	public String getTarget() {
		return target;
	}
	
	public int getTries() {
		return tries;
	}
	
	public String getWord() {
		return word;
	}
	
	public String getGuesses() {
		return guesses;
	}
	
	
	Snowman(String target, int tries){
		setTarget(target);
		setTries(tries);
		setWord("");
		setGuesses("");
	}
	
	Snowman(String target){
		this(target, 7);
	}

	
	public boolean valid(String letter) {
		if ((letter != null) && letter.length() == 1 && !guesses.contains(letter)) {
			char character = letter.charAt(0);
			if (Character.isLowerCase(character)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public void makePlay(String lett) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		if (target.contains(lett)) {
			for (int i = 0; i < target.length(); ++i) {
				String s=Character.toString(target.charAt(i));
				if (s.equals(lett)){
					indexes.add(i);
				}
			}
			for (int ind : indexes) {
				word = word.substring(0, ind) + lett + word.substring(ind + 1);
		}
		}
		else {
			guesses += lett;
		}					
	}
	

	public boolean over() {
		if (!word.contains("-")) {
			System.out.println("You won!");
			return true;
		}
		if (guesses.length() >= tries) {
			System.out.println("You lost :(");
			System.out.println("The word was: " + target);
			return true;
		}
		return false;
	}

	
	public String gameState() {
		String state = "";
		state += ("Word: " + word + "\n");
		state += ("Incorrect letters: " + guesses + "\n");
		if (this.guesses != null) {
			int numguessleft = tries - guesses.length();
			state += ("Guesses left: " + numguessleft + "\n");
		}
		return state;
	}
	
}
