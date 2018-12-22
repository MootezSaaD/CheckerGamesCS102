import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
 
import javax.swing.JPanel;
 
 
public class Tile extends JPanel {
   
   
    private OurColor color;
    private boolean selected;
 
    public Tile(OurColor color){
        setLayout(new GridLayout(1,0));
        this.color=color;
        initColor();
    }
 
    public OurColor getColor() {
        return color;
    }
 
    public boolean isSelected() {
        return selected;
    }
 
    public void setSelected(boolean selected) {
        this.selected = selected;
        if(selected){
            setBackground(Color.BLUE);
        //    setForeground(Color.LIGHT_GRAY);
        }
        else {
            initColor();
        }
    }
   
    private void initColor(){
        switch(color){
        case WHITE :
            setBackground(Color.WHITE);
            break;
        case BLACK :
            setBackground(Color.BLACK);
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
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}