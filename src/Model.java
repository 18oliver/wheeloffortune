
public class Model {
	private Hangman h = new Hangman();
	private Wheel w = new normalWheel();
	public Model() {

	}
	public void resetBal() {
		w.resetBal();
	}
	public int getBal() {
		return w.getBal();
	}
	public void buyVowel() {
		w.increaseBal(-250);
	}
	public String displayModifiedWord() {
		String str = h.getModifiedWord();
		int length = str.length();
		for(int i = 1; i<length*2; i += 2) {
			str = str.substring(0,i) + " " + str.substring(i,str.length());
		}
		//System.out.println(str);
		return str;
	}
	public String getWord() {
		return h.getWord();
	}
	public Wheel getWheel() {
		return w;
	}
	public void rollWheel() {
		int rand2 = (int) (Math.random()*24);
       	switch(rand2){
       		case 21:
       			w = new loseTurnWheel();
       			break;
       		case 22,23: 
       			w = new bankruptWheel();
       			break;
       		default:
       			w = new normalWheel();
       			break;
       	}
	}
	public boolean playTurn(char c) {
		int correct = h.guessChar(c);
		w.changeBal(correct);
		if(correct == 0) {
			return false;
		}
		return true;
	}
	public boolean playTurn(String str) {
		boolean r = h.guessWord(str);
		if(r) {
			w.increaseBal(1000);
		}
		return r;
	}
	public boolean hasFinishedWord() {
		if(h.isComplete()) {
			w.increaseBal(1000);
			return true;
		}
		return false;
	}
}
