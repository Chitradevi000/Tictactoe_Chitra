package Projects.Tictactoe.models;

import java.util.PrimitiveIterator;

public class Cell {

    private int row;
    private int col;
    private Cellstate cellstate;
    private Player player;


    //contrsuctor - creating a cell without player
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellstate = Cellstate.EMPTY; //without player, the cell is empty
    }

    //constructor - creating cell with player
    public Cell(int row, int col,Player player) {
        this.row = row;
        this.col = col;
        this.player=player;
        this.cellstate = Cellstate.FILL;

    }

    //you have to display the cell

    public void display()
    {
        if(player==null)
        {
            System.out.print("| |");
        }
        else if(cellstate.equals(Cellstate.BLOCKED))
        {
            System.out.print("||||");
        }
        else
        {
            System.out.print("|"+player.getSymbol().getSymbolchar()+"|");
        }
    }



    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Cellstate getCellstate() {
        return cellstate;
    }

    public void setCellstate(Cellstate cellstate) {
        this.cellstate = cellstate;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
