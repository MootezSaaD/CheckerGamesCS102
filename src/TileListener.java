import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
 
public class TileListener implements MouseListener{
   
    private Tile tile1;
    private Board board;
 
   
    public TileListener(Tile tile1, Board board) {
        super();
        this.tile1 = tile1;
        this.board = board;
    }
 
 
    public void mouseClicked(MouseEvent arg0) {
   
    }
 
 
    public void mouseEntered(MouseEvent arg0) {
       
    }
 
 
    public void mouseExited(MouseEvent arg0) {
       
    }
 
 
    public void mousePressed(MouseEvent arg0) {
        if(tile1.isSelected()){
            board.move(tile1);
        }
    }
 
 
    public void mouseReleased(MouseEvent arg0) {
       
    }
   
   
 
}