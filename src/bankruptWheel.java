
public class bankruptWheel extends Wheel {
	public void changeBal(int correctGuesses) {
		resetBal();
	}
/*	public void playRound(Hangman board) {
		System.out.println("ROLLED: BANKRUPT!");
		System.out.println("Turn has been lost, and balance has been set to 0!");
		changeBal(0);
		board.setGameOn(false);
		System.out.println("Round ended. Balance: " + getBal());
	}*/
	@Override
	public String str() {
		return "BANKRUPT!";
	}
}
