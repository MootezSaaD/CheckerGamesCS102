import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;public class Board {
	
	
		public void gui() throws Exception {
			JButton button;
			JFrame frame = new JFrame();
			JPanel panel = new JPanel();
			Color white = Color.WHITE;
			Color black = Color.BLACK;
			Color temp =black;
			ArrayList<String> al = new ArrayList<>();
			
			
			
			//panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			
			
			Image blockboyj = ImageIO.read(getClass().getResource("black.png"));
			Image red = ImageIO.read(getClass().getResource("red.png"));
			
			for(int i=0;i<8;i++) {
				if (i%2==0) temp = black;
				else temp = white;
				for (int j=0;j<8;j++) {
					button = new JButton();
					if (temp==black) {
						button.setBackground(temp);
						
						temp = white;
					}
					else {
						button.setBackground(temp);
						temp = black;
					}
					button.setMargin(new Insets(0,0,0,0));
					button.setBorder(null);
					if(i < 2) button.setIcon(new ImageIcon(blockboyj));
					else if (i>=6) button.setIcon(new ImageIcon(red));
					button.setName("B"+Integer.toString((i))+Integer.toString((j)));
					panel.add(button);
					
					al.add(button.getName());
					
				}
			}
			
			for(int i=0;i<al.size();i++) {
				System.out.println(al.get(i));
			}
			
			frame.add(panel);
			frame.setTitle("Checkers Board");
			frame.setSize(800, 800);
			panel.setLayout(new GridLayout(8,8));
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
}