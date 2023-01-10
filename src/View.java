import java.awt.*;
import javax.swing.*;

public class View extends JPanel{
	private boolean rolling = false;
	private Color c = Color.GREEN;
	//private int i = 0;
	//private Hangman h = new Hangman();
	//private String str = "$500";
	private Model m;
	public void setRolling(boolean b) {
		rolling = b;
	}
	public boolean isRolling(){
		return rolling;
	}
	public View(Model model) {
		m = model;
	}
	public void roll() {
		int rand = (int) (Math.random()*7);
       	switch(rand) {
       	case 0:
       		c = Color.orange;
       		break;
        case 1:
    		c = Color.red;
    		break;
	    case 2:
	    	c  = Color.green;
			break;
		case 3:
			c = Color.pink;
			break;
		case 4:
			c = Color.cyan;
			break;
		case 5:
			c = Color.magenta;
			break;
		case 6:
			c = Color.yellow;
			break;
		}
       	m.rollWheel();
       	//paintComponent(this.getGraphics());
       	//repaint();
       	
/*	       	int rand2 = (int) (Math.random()*24);
       	switch(rand2){
       		case 0,1,2: 
       			str = "$500";
       			break;
       		case 3,4,5:
       			str = "$550";
       			break;
       		case 6,7,8: 
       			str = "$600";
       			break;
       		case 9,10,11:
       			str = "$650";
       			break;
       		case 12,13,14: 
       			str = "$700";
       			break;
       		case 15,16,17:
       			str = "$800";
       			break;
       		case 18,19,20: 
       			str = "$900";
       			break;
       		case 21:
       			w = new loseTurnWheel();
       			break;
       		case 22,23: 
       			w = new bankruptWheel();
       			break;
       		default:
       			w = new normalWheel();
       			break;
       	}*/
       	//i++;
       	
       	//if(i>=16) {
       	//	rolling = false;
       	//	i = 0;
       	//}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//this.setBackground(Color.WHITE);
		
        //g.fillOval(115, 50, 100, 100);
		
		/*if(rolling) {
			roll();
		}*/
		/*try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		g.setColor(c);
        g.fillRect(283, 45, 150, 25);
        g.setColor(Color.black);
        g.setFont(new Font("Times New Roman", 100, 24));
        g.drawString(m.getWheel().str(), 293, 64);
    }
}
