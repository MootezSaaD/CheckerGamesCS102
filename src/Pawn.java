import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;

import javax.swing.JPanel;
 
public class Pawn extends JPanel {
 
    private OurColor color;
    private boolean goUp;
 
    public Pawn(OurColor color, boolean goUp) {
        this.goUp=goUp;
        this.color = color;
        setOpaque(false);
        switch (color) {
        case WHITE :
            setBackground(Color.WHITE);
            break;
        case BLACK :
            setBackground(Color.RED);
            break;
        }
        
    }
   
    @Override
    public void paintComponent(Graphics g){
        Paint paint;
        Graphics2D g2d;
        if (g instanceof Graphics2D) {
            g2d = (Graphics2D) g;
        }
        else {
            System.out.println("Error");
            return;
        }
        paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
        g2d.setPaint(paint);
        g.fillOval(5, 5, getWidth()-10, getHeight()-10);
        
 
    }
 
    public OurColor getColor() {
        return this.color;
    }
 
    public boolean isUp() {
        return this.goUp;
    }
 
    public void setUp(boolean goUp) {
        this.goUp = goUp;
    }
 
}