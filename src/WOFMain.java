import javax.swing.JFrame;

public class WOFMain {
	public static void main(String[] args) {
		gameFrame window = new gameFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(725, 400);
		window.setLocation(200, 75);
		window.setVisible(true);
		window.requestFocusInWindow();
	}
}
