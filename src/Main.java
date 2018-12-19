import javax.swing.JFrame;
import javax.swing.UIManager;


public class Main {

	
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Board(9));
		f.setVisible(true);

	}

}
