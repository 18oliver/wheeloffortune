
public class loseTurnWheel extends Wheel {
/*	public void playRound(Hangman board) {
		System.out.println("ROLLED: LOSE TURN!");
		System.out.println("Turn has been lost!");
//		changeBal(board);
		board.setGameOn(false);
		System.out.println("Round ended. Balance: " + getBal());
	}*/
	public void changeBal(int correctGuesses) {
		
	}
	@Override
	public String str() {
		return "LOSE TURN!";
	}
}
