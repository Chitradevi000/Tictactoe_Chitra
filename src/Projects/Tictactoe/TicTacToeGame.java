package Projects.Tictactoe;

import Projects.Tictactoe.Controller.GameController;
import Projects.Tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        GameController gameController= new GameController();

        System.out.println("Enter the dimension of the board: ");
        int dimension=scn.nextInt();

        System.out.println("Is there any bot in the game: ");
        String isBotPresent=scn.next();

        List<Player> players=new ArrayList<>();
        int iteratorNumber=dimension-1; //no of players

        if(isBotPresent.equals("Y"))
        {
            iteratorNumber=dimension-2;
        }

        for(int i=0;i<iteratorNumber;i++)
        {
            //TODO: valicate whether same symbol passed by 2 players
            //how? maintain a hasset, and if it contains symbol then dont allow

            System.out.println("what is the name of the player: "+ i+1);
            String playerName= scn.next();

            System.out.println("What is the symbol of the player: "+ i+1);
            String characterSymbol=scn.next();

            players.add(new Player(playerName,new Symbol(characterSymbol.charAt(0)),PlayerType.HUMAN));
        }

        if(isBotPresent.equals("Y"))
        {
            System.out.println("what is the name of the BOT: ");
            String playerName= scn.next();

            System.out.println("What is the symbol of the BOT: ");
            String characterSymbol=scn.next();

            players.add(new Player(playerName,new Symbol(characterSymbol.charAt(0)),PlayerType.BOT));
        }

        Game game=gameController.CreateGame(dimension,players);

        while(game.getGamestate().equals(GameStatus.IN_PROGRESS)) //the game will run until its in progress
        {
            System.out.println("Game Status");
            gameController.displayBoard(game);

            //TODO of instructor: logic for UNDO
            gameController.executeMove(game);
        }

        System.out.println("Game has ended, the result was: ");
        if(gameController.getGameState().equals(GameStatus.DRAW))
        {
            System.out.println("Game is draw");
        }
        else
        {
            System.out.println("Game is WON by: "+gameController.getWinner(game));
        }
    }
}
