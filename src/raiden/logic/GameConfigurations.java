package raiden.logic;

public class GameConfigurations {

	private int NumberOfPlayers = 1;
	private Difficulty difficulty = Difficulty.EASY;
	
	public enum Difficulty {
		EASY, MEDIUM, HARD
	}

	public int getNumberOfPlayers() {
		return NumberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		NumberOfPlayers = numberOfPlayers;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty dif) {
		this.difficulty = dif;
	}
}
