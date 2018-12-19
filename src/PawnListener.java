import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
 
public class PawnListener implements MouseListener {
   
    private Board board;
    private Pawn pawn;
   
    public PawnListener(Pawn pawn, Board board){
        this.board=board;
        this.pawn=pawn;
    }
 
    public void mouseClicked(MouseEvent arg0) {
       
    }
 
    public void mouseEntered(MouseEvent arg0) {
   
    }
 
    public void mouseExited(MouseEvent arg0) {
       
    }
 
    public void mousePressed(MouseEvent arg0) {
        board.showPossibilities(pawn);
    }
 
    public void mouseReleased(MouseEvent arg0) {
       
    }
 
}