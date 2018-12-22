import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class Main {
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JMenuBar m = new JMenuBar();
		Font font = new Font("Serif",Font.BOLD,24);
		f.setTitle("Checkers Game");
		JMenu exitMenu = new JMenu("Exit");
		JMenu newGame = new JMenu("New Game");
		JMenu help = new JMenu("Help");
		JMenu about = new JMenu("About");
		JMenu restart = new JMenu("Restart Game");
		m.setFont(font);
		m.add(newGame);
		m.add(restart);
		m.add(help);
		m.add(about);
		m.add(exitMenu);
		
		f.setJMenuBar(m);
		f.setSize(950, 950);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Board(9));
		f.setVisible(true);
	}

}
