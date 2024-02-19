package Projects.Tictactoe.Controller;

//import Projects.Tictactoe.Strategies.WinningStrategy.WinningStrategy;
import Projects.Tictactoe.Strategies.WinningStrategy.OrderOneWinningStrategy;
import Projects.Tictactoe.models.Game;
import Projects.Tictactoe.models.GameStatus;
import Projects.Tictactoe.models.Move;
import Projects.Tictactoe.models.Player;
import Projects.Tictactoe.Strategies.WinningStrategy.WinningStrategy;

import java.util.List;
import java.util.Map;

public class GameController {

    public Game CreateGame(int dimension, List<Player> players)
    {
        try {
            return Game
                    .builder() //below are the setters in builder class (inside Game class)
                    .setDimension(dimension)//stream
                    .setPlayers(players)
                    .setWinningStrategies(List.of(new OrderOneWinningStrategy(dimension)))//since we have one winning strategy , we are directly passing that
                    .build();
        } catch (Exception e) {
            System.out.println("Couldnt start game, something went wrong");
        }

        return null;
    }

    //why the below function is required?
    // because the main cls(Client cls) should not directly call the method printboard
    //from Game class..
    // it should go thru controller, that why the below class created
    public void displayBoard(Game game)
    {
        game.getBoard().printBoard();//game class have board as attri, and board has printboard method
    }

    public GameStatus getGameState(Game game)
    {

        return game.getGamestate();
    }

    public void executeMove(Game game)
    {
        //i really dont understand this
        //they said its for keep on rotating of players move
        int nextPlayerIndex= game.getNextPlayerIndex();
        Player nextPlayertoPlay=game.getPlayers().get(nextPlayerIndex);
        Move move=nextPlayertoPlay.makeMove(game.getBoard()); //this make move from PLayer class will return the move, you have to use it
        updateGameMoves(game,move);
    }

    //I was running the program which is not updating the board with the symbol
    //it has shown the empty board as current status
    //we found that we didnt use the makemove return object from Player class
    //we have created a function below for using it

    private void updateGameMoves(Game game, Move move)
    {
        //we have to update game with latest move
        game.getMoves().add(move); // the updated move is available in the executeMove function
    }


    public String getWinner(Game game)
    {
        return game.getWinner().getName();
    }
}
