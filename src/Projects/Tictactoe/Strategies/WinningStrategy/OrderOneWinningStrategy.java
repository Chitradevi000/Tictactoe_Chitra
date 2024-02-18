package Projects.Tictactoe.Strategies.WinningStrategy;

import Projects.Tictactoe.models.Board;
import Projects.Tictactoe.models.Move;
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
    public Player checkWinner(Board board,Move lastMove) // we gonna get the player from Move
    {
        Player lastMovePlayer= lastMove.getPlayer(); // this line made for return lastMovePlayer
        char symbol=lastMove.getPlayer().getSymbol().getSymbolchar();
        int row=lastMove.getCell().getRow();
        int col=lastMove.getCell().getCol();
        int dimension=board.getSize();

        //gonna validate all the 4 methods here

            if(checkRowWins(row,col,symbol,lastMove)!=null) //check you re a row winner
                            return lastMovePlayer;
            else if(checkColWins(row,col,symbol,lastMove)!=null)
                            return lastMovePlayer;
            else if(checkForDiagonalWins(row,col,symbol,lastMove)!=null)
                            return lastMovePlayer;
            else if(checkCornerWin(row,col,symbol,lastMove)!=null)
                            return lastMovePlayer;
            else
                             return null;

    }

    private Player checkForDiagonalWins(int row,int col,char symbol,Move lastMove)
    {
        //-------------gonna do for both diagonal - topleft

        //here we gonna call the hashmap directly

        if(isCellTopLeftDiagonal(row,col))// we gonna call the fun made for topleft diagonal
        {
            if(!topLeftDiagonalSymbolCount.containsKey(symbol))
            {
                topLeftDiagonalSymbolCount.put(symbol,0);
            }

            topLeftDiagonalSymbolCount.put(symbol,
                    topLeftDiagonalSymbolCount.get(symbol)+1);

            //after adding we check whether he got the win
            if(topLeftDiagonalSymbolCount.get(symbol)==dimension)
                return lastMove.getPlayer();
        }

        //-------------gonna do for bottom left

        //here we gonna call the hashmap directly

        if(isCellBottomLeftDiagonal(row,col))// we gonna call the fun made for bottomleft diagonal
        {
            if(!bottomLeftDiagonalSymbolCount.containsKey(symbol))
            {
                bottomLeftDiagonalSymbolCount.put(symbol,0);
            }

            bottomLeftDiagonalSymbolCount.put(symbol,
                    bottomLeftDiagonalSymbolCount.get(symbol)+1);

            //after adding we check whether he got the win
            if(bottomLeftDiagonalSymbolCount.get(symbol)==dimension)
                return lastMove.getPlayer();
        }
        return null;
    }

    private Player checkCornerWin(int row,int col,char symbol,Move lastMove)
    {
        //-------------gonna do for corners

        //here we gonna call the hashmap directly

        if(isCornercell(row,col))// we gonna call the fun made for bottomleft diagonal
        {
            if(!cornersSymbolCount.containsKey(symbol))
            {
                cornersSymbolCount.put(symbol,0);
            }

            cornersSymbolCount.put(symbol,
                    cornersSymbolCount.get(symbol)+1);

            //after adding we check whether he got the win
            if(cornersSymbolCount.get(symbol)==dimension)
                return lastMove.getPlayer();
        }

        return null; //if nothing happens
    }

    private  Player checkRowWins(int row,int col,char symbol,Move lastMove)
    {
        //---------------------row count
        //we gonna check the row symbol count and col symbol count

        if(rowSymbolCount.get(row).containsKey(symbol)) //if its very 1st entry of my symbol(key)
        //i have checked above that if my symbol is not present in list-rowsymbolcount
        {
            rowSymbolCount.get(row).put(symbol,0);
        }//here we have added (key, value)-(symbol,0) in HM(get.(row)) which is in AL

        //and then i set the value to 1, but not in else part because
        //whether its already exists or not, you must add 1 as you gonna make a move with that symbol
        rowSymbolCount.get(row).put
                (
                        symbol, //key
                        rowSymbolCount.get(row).get(symbol)+1 //added 1 to the value
                );

        //once added, we will check whether that row is full of this symbol

        if(rowSymbolCount.get(row).get(symbol)==dimension)// if my symbol count==3
        {
            return lastMove.getPlayer(); //we already said that we gonna get player from Move
        }
        return null; //if nothing happens

    }

    private Player checkColWins(int row,int col,char symbol,Move lastMove)
    {
        //-------------gonna do the same above thing for col

        if(colSymbolCount.get(row).containsKey(symbol)) //if its very 1st entry of my symbol(key)
        //i have checked above that if my symbol is not present in list-rowsymbolcount
        {
            colSymbolCount.get(col).put(symbol,0);
        }//here we have added (key, value)-(symbol,0) in HM(get.(row)) which is in AL

        //and then i set the value to 1

        colSymbolCount.get(col).put
                (
                        symbol, //key
                        colSymbolCount.get(col).get(symbol)+1 //added 1 to the value
                );

        //once added, we will check whether that row is full of this symbol

        if(colSymbolCount.get(col).get(symbol)==dimension)// if my symbol count==3
        {
            return lastMove.getPlayer(); //we already said that we gonna get player from Move
        }

        //if nothing happens
        return null;
    }
}
