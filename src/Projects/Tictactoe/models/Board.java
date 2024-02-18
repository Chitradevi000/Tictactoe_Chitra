package Projects.Tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size; //dimension
    private List<List<Cell>> boardofcells;

    public Board(int size) {
        this.size = size;
        this.boardofcells=new ArrayList<>(); //[]
        //we need the below size* size
//        [
//        (- - -)
//        (- - -)
//        (- - -) ]

        for(int i=0;i<size;i++) //row created
        {
            this.getBoardofcells().add(new ArrayList<>());
            for(int j=0;j<size;j++)
            {
                this.getBoardofcells().get(i).add(new Cell(i,j)); // adding 3 cells on each row
            }
        }

    }
   public void printBoard()
    {
        //go thru all cells and print it

        for(int i=0;i<size;i++)//row
        {
           List<Cell> row= boardofcells.get(i);//getting the rows with list of cells, hence saving it in list
            for(int j=0;j<size;j++) //col
            {
               row.get(j).display(); //on each row , get each cell, j is for cell
            }
            System.out.println();
        }
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoardofcells() {
        return boardofcells;
    }

    public void setBoardofcells(List<List<Cell>> boardofcells) {
        this.boardofcells = boardofcells;
    }
}
