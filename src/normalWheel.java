
public class normalWheel extends Wheel {
	private int rollValue;
	public normalWheel() {
		super();
		int randNum = (int)(7*Math.random());
		switch(randNum) {
			case 0:
				rollValue = 500;
				break;
				//return 500;
			case 1:
				rollValue = 550;
				break;
				//return 550;
			case 2:
				rollValue = 600;
				break;
				//return 600;
			case 3:
				rollValue = 650;
				break;
				//return 650;
			case 4:
				rollValue = 700;
				break;
				//return 700;
			case 5:
				rollValue = 800;
				break;
				//return 800;
			default:
				rollValue = 900;
				break;
				//return 900;
		}
		
		//rollValue = 0;
	}
	public void changeBal(int correctGuesses) {
		increaseBal(correctGuesses*rollValue);
		//System.out.println("$" + correctGuesses*rollValue + " has been added. ");
	}
//	public void setRollValue() {
//		rollValue = genRollValue();
//	}
//	public String getRollValue() {
//		genRollValue();
//		return("" + rollValue);
//	}
/*	public void playRound(Hangman board) {
//		while(board.getGameOn()) {
			System.out.println("ROLLED: " + genRollValue());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			String temp = board.getModifiedWord();
//			System.out.println(getBal());
			System.out.println(board.getModifiedWord());
			System.out.println("Please guess a character (a,e,i,o,u will cost $250): ");
//			System.out.println(bal);
			char guess = TextIO.getlnChar();
			while((isVowel(guess)) && bal<250) {
				System.out.println("Not enough money for a vowel. Please guess a character: ");
				guess = TextIO.getlnChar();
			}
			if(isVowel(guess)) {
				increaseBal(-250);
			}
			int correctGuesses = board.guessChar(guess);
			if(correctGuesses != 0){
				changeBal(correctGuesses);
				char ans = 0;
				System.out.println("Would you like to guess a word? (y/n)");
				while(!(ans == 'n' || ans == 'N' || ans == 'y' || ans == 'Y')) {
					ans = TextIO.getlnChar();
				}
				if(ans == 'y' || ans == 'Y') {
					System.out.println("Please guess a word: ");
					String wordGuess = TextIO.getlnString();
					boolean correct = board.guessWord(wordGuess);
					if(correct) {
						increaseBal(1000);
						System.out.println("Correct! $1000 has been added.");
					}
					else {
						System.out.println("Incorrect guess.");
					}
					board.setGameOn(false);
				}
			}
			board.playTurn(getBal());
			if(board.getIsVowel()) {
				increaseBal(-250);
			}
			if(board.getGameOn()) {
				changeBal(board);
				System.out.println(board.getModifiedWord());
//				System.out.println("Balance: " + getBal());
			}
			board.guessWord();
			if(board.getModifiedWord().equals(board.getWord())) {
				increaseBal(1000);
				board.setGameOn(false);
			}
//			System.out.println(getBal());
//		}
		System.out.println("Round ended. Balance: " + getBal());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
/*	public int genRollValue() {
		return rollValue;
	}
	public boolean isVowel(char guess) {
		if((guess == 'a' || guess == 'e' || guess == 'i' || guess == 'o' || guess == 'u')) {
			return true;
		}
		return false;
	}*/
	public String str() {
		return "$" + Integer.toString(rollValue);
	}
}
