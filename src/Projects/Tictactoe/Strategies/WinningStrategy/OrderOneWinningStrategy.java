package src.Projects.Tictactoe.Strategies.WinningStrategy;

import Projects.Tictactoe.models.Board;
import Projects.Tictactoe.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class OrderOneWinningStrategy implements WinningStrategy {

    int dimension; // im creating this when i write isCellBottomLeftDiagonal

    //there are many wins
    //1. row count freq is n
    //2. col count freq
    //3. diagonal- totally 2 diagonal in all board size
    //4. corners

    private List<HashMap<Character,Integer>> rowSymbolCount=new ArrayList<>();//initially the arraylist is [] //contructor will've the map initialization
    private List<HashMap<Character,Integer>> colSymbolCount=new ArrayList<>(); //contructor will've the map initialization
    private HashMap<Character,Integer> topLeftDiagonalSymbolCount=new HashMap<>();
    private HashMap<Character,Integer> bottomLeftDiagonalSymbolCount=new HashMap<>();
    private HashMap<Character,Integer> cornersSymbolCount=new HashMap<>();

    //adding the constructor
    public OrderOneWinningStrategy(int dimension) //constructor
    {
        this.dimension=dimension;
        for(int i=0;i<dimension;i++)
        {
            rowSymbolCount.add(new HashMap<>());
            colSymbolCount.add(new HashMap<>());

            // now the array list = [{} {} {}]
        }
    }

    //there are many wins  - we need to write boolean return code for each kind of win

    public boolean isCellTopLeftDiagonal(int row,int col)
    {
        //make a drawing , you will understand why row==col

        return row==col;
    }

    public boolean isCellBottomLeftDiagonal(int row,int col)
    {
        //make a drawing , you will understand
        return (row+col)==dimension-1;
    }

    public boolean isCornercell(int row,int col)
    {
        // if dimension is 3
        //there are winning cases (0 0), (2 2), (0 2) (2 0)
        //hence we need to check all the above 4 cases

        if(row==0 || row==dimension-1) //(0 0), (2 2),(0 2) (2 0)
        {
            return col==0 || col==dimension-1;
        }
        return false;
    }




    @Override
    public Player checkwinner(Board board) {
        return null;
    }
}
