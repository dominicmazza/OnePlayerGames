
public interface OnePlayerGame {
	void makePlay(String lett);
	boolean valid(String input2);
	boolean over();
	String gameState();
}