
public class Hangman {
//	public static void main(String args[]) {
//		System.out.println("Welcome!");
//		String word = generateWord();
//		System.out.println(word);
//		System.out.println(toUnderscores(word));
//		String modifiedWord = toUnderscores(word);
//		System.out.println("Please guess a character: ");
//		char guess = TextIO.getlnChar();
//		if(isGuessCorrect(word, modifiedWord, guess)) {
//			modifiedWord = modifyWord(word, modifiedWord, guess);
//			System.out.println(modifiedWord);
//		}
//		else {
//			System.out.println("Incorrect Guess.");
//			System.out.println();
//		}
//	}
	private String word;
	private String modifiedWord;
	//private boolean gameOn;
//	private boolean isVowel;
//	private char guess;
	public Hangman() {
		word = generateWord();
		modifiedWord = toUnderscores(word);
		//gameOn = true;
		//System.out.println(word);
//		isVowel = false;
	}
	public boolean isComplete() {
		return (modifiedWord.equals(word));
	}
	/*public boolean getGameOn() {
		return gameOn;
	}
	public void setGameOn(boolean t) {
		gameOn = t;
	}*/
	public String getWord() {
		return word;
	}
	public String getModifiedWord() {
		return modifiedWord;
	}
//	public boolean getIsVowel() {
//		return isVowel;
//	}
	public String generateWord() {
		int randomNum = (int)(10*Math.random());
		//System.out.println(randomNum);
		switch(randomNum) {
			case 0:
				return "computer";
			case 1:
				return "switches";
			case 2:
				return "programming";
			case 3:
				return "eclipse";
			case 4:
				return "coding";
			case 5:
				return "inheritance";
			case 6:
				return "compile";
			case 7:
				return "methods";
			case 8:
				return "boolean";
			default:
				return "classes";
		}
	}
	public String toUnderscores(String word) {
		String withUnderscores = "";
		for(int i = 0; i<word.length(); i++) {
			withUnderscores += "_";
		}
		return withUnderscores;
	}
	public int guessChar(char Guess) {
		String newWord = modifiedWord;
		int count = 0;
		boolean correct = false;
		for(int i = 0; i<word.length(); i++) {
			if(word.charAt(i) == Guess && modifiedWord.charAt(i) == '_') {
				newWord = newWord.substring(0,i) + Guess + newWord.substring(i+1,newWord.length());
				count++;
				correct = true;
			}
		}
		if(correct) {
			//System.out.println("Correct Guess.");
		}
		else {
			//System.out.println("Incorrect Guess.");
		}
		/*if(newWord.equals(word)) {
			gameOn = false;
		}*/
		//System.out.println(modifiedWord + word);
		//if(modifiedWord == word) {System.out.println("true");} if (modifiedWord == word) {System.out.println("false");}
		modifiedWord = newWord;
		return count;
	}
	public boolean guessWord(String guess) {
		if(word.equals(guess)) {
			//gameOn = false;
			modifiedWord = word;
			return true;
		}
		return false;
	}
	public boolean gameFinished() {
		if(modifiedWord == word) {
			return true;
		}
		return false;
	}
//	public int countDifferences(String word1, String word2) {
//		//given word1 and word2 same length
//		int count = 0;
//		for(int i = 0; i<word1.length(); i++) {
//			if(word1.charAt(i) != word2.charAt(i)) {
//				count++;
//			}
//		}
//		return count;
//	}
/*	public boolean isGuessCorrect(String originalWord, String oldWord, char Guess) {
		if(modifyWord(originalWord, Guess).equals(oldWord)) {
			return false;
		}
		return true;
	}*/
//	public void setGuess() {
//
//	}
//	public char getGuess() {
//		return guess;
//	}
/*	public void playTurn(int bal) {
		System.out.println("Please guess a character (a,e,i,o,u will cost $250): ");
//		System.out.println(bal);
		char guess = TextIO.getlnChar();
		
		
		while((guess == 'a' || guess == 'e' || guess == 'i' || guess == 'o' || guess == 'u') && bal<250) {
			System.out.println("Not enouguh money for a vowel. Please guess a character: ");
			guess = TextIO.getlnChar();
		}
		
		
		
		
		
		if(isGuessCorrect(word, modifiedWord, guess)) {
			modifiedWord = modifyWord(word, guess);
			System.out.println("Correct Guess.");
		}
		else {
			System.out.println("Incorrect Guess.");
			gameOn = false;
		}
	}*/
	
/*	public void guessWord() {
		char response = 0;
		if(gameOn){
			while(response != 'y' && response != 'n') {
				System.out.println("Would you like to guess a word? (y/n)");
				response = TextIO.getlnChar();
			}
			if(response == 'y') {
				System.out.println("Guess a word:");
				String guess = TextIO.getlnString();
				if(guess.equals(word)) {
					modifiedWord = word;
					System.out.println("Correct Guess. ");
					System.out.println("$1000 has been added. ");
				}
				else {
					System.out.println("Incorrect Guess. ");
				}
				gameOn = false;
			}
		}
	}*/
}
