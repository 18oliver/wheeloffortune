import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class gameFrame extends JFrame implements KeyListener, ActionListener {
	private JTextField textField;
	private int option = 0;
	private int playerNum = 1;
	private JLabel rolled;
	private JPanel t;
	private JPanel top;
	private JPanel r;
	private JPanel next;
	private Model m = new Model();
	private View view = new View(m);
	private JLabel turnOver;
	private JLabel modifiedWord;
	private JLabel accuracy;
	private JLabel instruction;
	private JLabel balance = new JLabel("Player " + playerNum +  "'s balance: $" + m.getBal());
	private int[] balances = new int[3];
	public gameFrame() {
		super("Wheel of Fortune!");
		JPanel instructionsPanel = new JPanel();
		instructionsPanel.setLayout(new GridLayout(14,1));
		JLabel[] instructions = new JLabel[13];
		instructions[0] = new JLabel("Welcome to Wheel of Fortune!");
		instructions[1] = new JLabel("This is a 3 person game, where the objective is to guess a certain word correctly, similar to Hangman.");
		instructions[2] = new JLabel("The theme of the word is: Computer Science");
		instructions[3] = new JLabel("Each play, you will roll the wheel, guess a character, and have a chance to guess the word.");
		instructions[4] = new JLabel("However, if you guess either the word or the character incorrectly, your turn will end.");
		instructions[5] = new JLabel("Each player will continue playing until they guess incorrectly, complete the word, or roll BANKRUPT or LOSE A TURN.");
		instructions[6] = new JLabel("If you roll a certain amount AND guess a correct character, you will be paid that amount for each occurrence of the character.");
		instructions[7] = new JLabel("If you roll bankrupt, your turn will end and your balance will be set to 0.");
		instructions[8] = new JLabel("If you roll lose a turn, your turn will end but your balance will be kept.");
		instructions[9] = new JLabel("Note: if you want to guess a vowel (a,e,i,o,u), that will cost you $250.");
		instructions[10] = new JLabel("You will get $1000 for successfully completing the word.");
		instructions[11] = new JLabel("If nobody successfully completes the word by the time all 3 players have went, nobody gets the $1000.");
		instructions[12] = new JLabel("Good Luck!");
		JButton startGame = new JButton("Start Game");
		//Listener Listener = new Listener(this);
		startGame.addActionListener(this);
		for(int i = 0; i<instructions.length; i++) {
			instructionsPanel.add(instructions[i]);
		}
		instructionsPanel.add(startGame);
		
		//JFrame window = new JFrame("Wheel of Fortune");
		//view = new View();
		//Listener listener = new Listener(view);
		view.setLayout(new GridLayout(5,1));
		
		//JLabel label = new JLabel("Wheel Of Fortune!");
		top = new JPanel();
		//top.setLayout(new BorderLayout(1,1));
		//top.add(label);
		top.add(balance);
		
		textField = new JTextField("", 10);
		t = new JPanel();
		instruction = new JLabel("Enter your guess (one character):");
		textField.addKeyListener(this);
		t.add(instruction, BorderLayout.NORTH);
		t.add(textField, BorderLayout.CENTER);
		
		
		JButton roll = new JButton("Roll Wheel!");
		r = new JPanel();
		roll.addActionListener(this);
		r.add(roll);
		
		modifiedWord = new JLabel("The word you need to guess is: " + m.displayModifiedWord());
		
		next = new JPanel();
		JButton nextPlayer = new JButton("Continue");
		nextPlayer.addActionListener(this);
		next.add(nextPlayer);
		
		view.add(top, BorderLayout.NORTH);
		
		
		view.add(modifiedWord);
		view.add(r);
		
		this.setContentPane(instructionsPanel);
/*		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(120, 70);
		window.setSize(350, 250);
		window.setVisible(true);*/
	}
	public void updateBal() {
		view.remove(top);
		top.remove(balance);
		balance = new JLabel("Player " + playerNum +  "'s balance: $" + m.getBal());
		top.add(balance);
		view.add(top, BorderLayout.NORTH);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        	String guess = textField.getText().toLowerCase();
        	if(option == 0) {
        		if(guess.length() != 1) {
            		textField.setText("Please enter one character.");
            	}
            	else {
            		char c = guess.charAt(0);
            		if(isVowel(c) && m.getBal() <250) {
        				textField.setText("Not enough money for a vowel");
        			}
        			else {
                		textField.setText("");
            			if(isVowel(c)) {
        					m.buyVowel();
        				}
        				boolean cont = m.playTurn(c);
                		if(cont) {
            				updateBal();
                			view.remove(modifiedWord);
                    		if(m.hasFinishedWord()) {
                    			view.remove(t);
                    			view.remove(instruction);
                    			updateBal();
                    			accuracy = new JLabel("Correct Guess. You win!");
                    			view.add(next);
                    			balances[playerNum-1] = m.getBal();
                    			m.resetBal();
                    			playerNum = 4;
                    		}
                    		else {
                    			modifiedWord = new JLabel("The word you need to guess is: " + m.displayModifiedWord());
                        		view.add(modifiedWord);
                    			view.remove(t);
                        		t.remove(textField);
                        		t.remove(instruction);
                        		instruction = new JLabel("Would you like to guess the word (y/n) ?");
                        		textField.setText("");
                        		t.add(instruction);
                        		t.add(textField);
                        		view.add(t);
                        		//view.add(r, BorderLayout.EAST);
                        		accuracy = new JLabel("Correct Guess.");
                        		option++;
                    		}
                		}
                		else {
                			view.remove(modifiedWord);
                			view.remove(t);
                			accuracy = new JLabel("Incorrect Guess. Player " + playerNum + "'s turn over.");
                			updateBal();
                			view.add(next, BorderLayout.SOUTH);
                		}
                		try {
                			view.remove(rolled);
                		}
                		catch(Exception e1) {
                		}
                		view.add(accuracy);
                		this.setVisible(true);
        				this.setContentPane(view);
        			}
            	}
        	}
        	else if(option == 1) {
        		char c = guess.charAt(0);
        		if(guess.length() != 1 || !(c == 'n' || c == 'N' || c == 'y' || c == 'Y')) {
        			try {
        				view.remove(accuracy);
        			}
        			catch(Exception e1) {
        				
        			}
        			view.remove(t);
        			t.remove(textField);
        			textField.setText("Please enter y/n");
        			t.add(textField);
        			view.add(t);
        			this.setVisible(true);
    				this.setContentPane(view);
        		}
        		else {
        			try {
        				view.remove(accuracy);
        			}
        			catch(Exception e1) {
        				
        			}
        			if(c == 'Y' || c == 'y') {
        				view.remove(t);
                		t.remove(textField);
                		t.remove(instruction);
                		instruction = new JLabel("Please enter your guess for the word: ");
                		textField.setText("");
                		t.add(instruction, BorderLayout.NORTH);
                		t.add(textField, BorderLayout.CENTER);
                		view.add(t, BorderLayout.SOUTH);
        				option++;
        				this.setVisible(true);
        				this.setContentPane(view);
        			}
        			else {
        				option = 0;
            			view.remove(t);
            			t.remove(textField);
            			t.remove(instruction);
            			instruction = new JLabel("Enter your guess (one character):");
            			textField.setText("");
            			t.add(instruction, BorderLayout.NORTH);
            			t.add(textField, BorderLayout.CENTER);
            			view.add(r);
                		this.setVisible(true);
        				this.setContentPane(view);
        			}
        		}
        	}
        	else if(option == 2) {
        		boolean bool = m.playTurn(guess);
        		if(bool) {
        			view.remove(modifiedWord);
        			accuracy = new JLabel("Correct Guess. You win!");
        			updateBal();
        			balances[playerNum-1] = m.getBal();
        			m.resetBal();
        			playerNum = 4;
        			view.remove(r);
        		}
        		else {
        			accuracy = new JLabel("Incorrect Guess. Player " + playerNum + "'s turn over.");
        			t.remove(instruction);
        			t.remove(textField);
        			textField.setText("");
        			instruction = new JLabel("Enter your guess (one character):");
        			t.add(instruction, BorderLayout.NORTH);
        			t.add(textField, BorderLayout.CENTER);
        		}
        		option = 0;
        		view.remove(t);
        		view.add(next, BorderLayout.SOUTH);
        		view.add(accuracy);
        		this.setVisible(true);
				this.setContentPane(view);
        	}
        }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void startGame() {
		this.setContentPane(view);
		this.setVisible(true);
	}
	public boolean isVowel(char c) {
		return(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String op = e.getActionCommand();
		if(op.equals("Start Game")) {
			//System.out.println("c");
			//view.repaint();
			startGame();
			//view.repaint();
		}
		if(op.equals("Roll Wheel!")) {
			//view.setRolling(true);
			try {
				view.remove(accuracy);
				
			}catch(Exception e1){
				//System.out.println("a");
			}
			try {
				view.remove(modifiedWord);
				
			}catch(Exception e1){
				//System.out.println("a");
			}
			try {
				view.remove(rolled);
				
			}catch(Exception e1){
				//System.out.println("a");
			}
			int i = 0;
			while(i<=16) {
				//view.setRolling(true);
				view.roll();
				//view.repaint();
				view.paintComponent(view.getGraphics());
				this.setVisible(true);
				this.setContentPane(view);
				try {
		       		if(i < 11) {
		       			Thread.sleep(175);
		       		}
		       		else if(i<14){
		       			Thread.sleep(325);
		       		}
		       		else if(i<16){
		       			Thread.sleep(750);
		       		}
		       		else {
		       			Thread.sleep(1500);
		       		}
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				i++;
			}
			if(m.getWheel() instanceof normalWheel) {
				rolled = new JLabel("You rolled: " + m.getWheel().str());
				view.add(rolled);
				view.add(modifiedWord);
				view.add(t, BorderLayout.SOUTH);
				view.remove(r);
				this.setVisible(true);
				this.setContentPane(view);
			}
			else {
				rolled = new JLabel("You rolled: " + m.getWheel().str());
				m.playTurn('0');
				updateBal();
				view.add(rolled);
				turnOver = new JLabel("Player " + playerNum + "'s turn over.");
				view.add(turnOver);
				view.remove(r);
				view.add(next, BorderLayout.SOUTH);
				this.setVisible(true);
				this.setContentPane(view);
			}
		}
		if(op.equals("Continue")) {
			view.remove(next);
			try {
				view.remove(accuracy);
			}
			catch(Exception e1) {
				
			}
			try {
				balances[playerNum-1] = m.getBal();
				m.resetBal();
			}
			catch(Exception e1) {
				
			}
			try {
				view.remove(turnOver);
			}
			catch(Exception e1) {
				
			}
			try {
				view.remove(rolled);
			}
			catch(Exception e1) {
				
			}
			if(playerNum <3) {
				playerNum++;
				updateBal();
				view.add(modifiedWord);
				view.add(r);
				this.setVisible(true);
				this.setContentPane(view);
			}
			else {
				view.removeAll();
				view.setLayout(new GridLayout(3,1));
				JPanel wordPanel = new JPanel();
				JLabel word = new JLabel("The word was: " + m.getWord());
				wordPanel.add(word);
				JPanel last = new JPanel(new GridLayout(1,4));
				last.add(new JLabel("FINAL BALANCES:"));
				for(int i = 1; i<4; i++) {
					last.add(new JLabel("Player " + i + ": $" + balances[i-1]));
				}
				view.add(wordPanel);
				view.add(last);
				this.setVisible(true);
				this.setContentPane(view);
			}
		}
	}
}