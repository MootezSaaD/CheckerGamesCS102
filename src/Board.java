import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Board extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int size=9;

	private Tile activeTile;

	private boolean blackTurn;

	public Board(int size){
		blackTurn=false;
		setLayout(new GridLayout(size, size));
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if((j%2==0 && i%2==0) || (j%2!=0 && i%2!=0)){
					addTile(OurColor.BLACK);
				}
				else{
					addTile(OurColor.WHITE);
				}
			}
		}
		init();
	}

	private void addTile(OurColor color){
		Tile tile1 = new Tile(color);
		tile1.addMouseListener(new TileListener(tile1, this));
		add(tile1);
	}

	private Pawn createPawn(OurColor color, boolean goUp){
		Pawn pawn = new Pawn(color, goUp);
		pawn.addMouseListener(new PawnListener(pawn, this));
		return pawn;
	}

	private void init(){
		for(int j=0; j<size*3; j+=2){
			getTile(j).add(createPawn(OurColor.BLACK, false));
			getTile(size*size-j-1).add(createPawn(OurColor.WHITE, true));
		}
	}

	public Tile getTile(int i, int j){
		return (Tile) getComponent(j+i*size);
	}

	public Tile getTile(int i){
		return (Tile) getComponent(i);
	}

	
	public void showPossibilities(Pawn p){
		if((p.getColor().equals(OurColor.BLACK) && blackTurn) || (p.getColor().equals(OurColor.WHITE) && !blackTurn)){
			int i=0;
			int j=0;
			for(int k=0; k<size*size; k++){
				getTile(k).setSelected(false);
				if(getTile(k).getComponentCount()!=0 && getTile(k).getComponent(0).equals(p)){
					activeTile=getTile(k);
					i=k/size;
					j=k%size;

				}
			}
			selectedTile(i, j, p.getColor());
		}
	}

	public void selectedTile(int i, int j, OurColor color){
		Pawn pion = (Pawn)(getTile(i, j).getComponent(0));
		if(pion.isUp()){
			if(i-1>=0 && j-1>=0 && getTile(i-1, j-1).getComponentCount()==0){
				getTile(i-1, j-1).setSelected(true);
			}
			else if(i-2>=0 && j-2>=0 && getTile(i-2, j-2).getComponentCount()==0 && !((Pawn)(getTile(i-1, j-1).getComponent(0))).getColor().equals(color)){
				getTile(i-2, j-2).setSelected(true);
			}
			if(i-1>=0 && j+1<size && getTile(i-1, j+1).getComponentCount()==0){
				getTile(i-1, j+1).setSelected(true);
			}
			else if(i-2>=0 && j+2<size && getTile(i-2, j+2).getComponentCount()==0 && !((Pawn)(getTile(i-1, j+1).getComponent(0))).getColor().equals(color)){
				getTile(i-2, j+2).setSelected(true);
			}
		}
		else{
			if(i+1<size && j+1<size && getTile(i+1, j+1).getComponentCount()==0){
				getTile(i+1, j+1).setSelected(true);
			}
			else if(i+2<size && j+2<size && getTile(i+2, j+2).getComponentCount()==0 && !((Pawn)(getTile(i+1, j+1).getComponent(0))).getColor().equals(color)){
				getTile(i+2, j+2).setSelected(true);
			}
			if(i+1<size && j-1>=0 && getTile(i+1, j-1).getComponentCount()==0){
				getTile(i+1, j-1).setSelected(true);
			}
			else if(i+2<size && j-2>=0 && getTile(i+2, j-2).getComponentCount()==0 && !((Pawn)(getTile(i+1, j-1).getComponent(0))).getColor().equals(color)){
				getTile(i+2, j-2).setSelected(true);
			}
			
		}
	}

	public void move(Tile tile1){
		tile1.add(activeTile.getComponent(0));
		for(int k=0; k<size*size; k++){
			getTile(k).setSelected(false);
		}
		if(Math.abs(getLine(tile1)-getLine(activeTile))==2){
			int i = (getLine(tile1)+getLine(activeTile))/2;
			int j = (getColonne(tile1)+getColonne(activeTile))/2;
			getTile(i, j).removeAll();
			getTile(i, j).validate();
			getTile(i, j).repaint();
		}
		blackTurn=!blackTurn;
		activeTile.removeAll();
		activeTile.repaint();
		activeTile=null;
		tile1.repaint();
		if(getLine(tile1)==0){
			Pawn p=(Pawn)(tile1.getComponent(0));
			p.setUp(false);
		}
		if(getLine(tile1)==size-1){
			Pawn p=(Pawn)(tile1.getComponent(0));
			p.setUp(true);
		}
	}

	private int getLine(Tile tile1){
		int res=0;
		for(int i=0; i<size*size; i+=2){
			if(getTile(i).equals(tile1)){
				res=i/size;
			}
		}
		return res;
	}

	private int getColonne(Tile tile1){
		int res=0;
		for(int i=0; i<size*size; i+=2){
			if(getTile(i).equals(tile1)){
				res=i%size;
			}
		}
		return res;
	}
	
	


}


