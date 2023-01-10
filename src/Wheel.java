
public abstract class Wheel {
	static protected int bal = 0;
//	private int Wheel;
	public Wheel() {
		//bal = 0;
//		Wheel = -1;
	}
	public int getBal() {
		return bal;
	}
	public void resetBal() {
		bal = 0;
	}
//	public void setBal(int num) {
//		bal = num;
//	}
	public void increaseBal(int amount) {
		bal += amount;
	}
	
	//public abstract String getStr();
	
//	public abstract void playRound(Hangman board);
	public abstract void changeBal(int correctGuesses);
	public abstract String str();
//	public abstract String getRollValue();
}
