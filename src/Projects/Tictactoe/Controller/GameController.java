package Projects.Tictactoe.Controller;

//import Projects.Tictactoe.Strategies.WinningStrategy.WinningStrategy;
import Projects.Tictactoe.models.Game;
import Projects.Tictactoe.models.GameStatus;
import Projects.Tictactoe.models.Player;
import Projects.Tictactoe.Strategies.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game CreateGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies)
    {
        try {
            return Game
                    .builder() //below are the setters in builder class (inside Game class)
                    .setDimension(dimension)//stream
                    .setPlayers(players)
                    .setWinningStrategies(winningStrategies)
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
        nextPlayertoPlay.makeMove(game.getBoard());
    }

    public String getWinner(Game game)
    {
        return game.getWinner().getName();
    }
}
