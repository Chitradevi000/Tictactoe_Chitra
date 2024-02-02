package Projects.Tictactoe.models;

import Projects.Tictactoe.exception.DuplicateSymbolException;
import Projects.Tictactoe.exception.InvalidDimensionException;
import Projects.Tictactoe.exception.InvalidPlayersCountException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Moves> moves;
    private Player winner;
    private GameStatus gamestate;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(List<Player> players, Board board,List<WinningStrategy> winningStrategies) {
        this.players=players;
        this.board = board;
        this.moves = new ArrayList<Moves>();
//        this.winner = winner;
        this.gamestate = GameStatus.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }


    //builder starts for validation
    //whatever the user input, you will take thru builder class and not thru directly

    public static class Builder
    {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;

        //static method which returns the builder
        public static Builder builder()
        {
            return new Builder(); // builder will return the game

        }

        public Builder() {
            //in this constructor, im initialising with basic values
            this.players = new ArrayList<Player>();
            this.winningStrategies = new ArrayList<WinningStrategy>();
            this.dimension = 0;
        }

        //setter
        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
        }

        public void setDimension(int dimension) {
            this.dimension = dimension;
        }

        public void addPlayer(Player player)
        {
            players.add(player);
        }

        public void addWinningStrategy(WinningStrategy winningStrategy)
        {
            winningStrategies.add(winningStrategy);
        }

        //validations start

        private void validateBotCounts()
        {
            int botcount=0;
            for(Player player:players)
            {
                //iterating the player list and check whether any bot avaialble and if its>1 , then throw exception
                if(player.getPlayerType().equals(PlayerType.BOT))
                {
                    botcount++;
                }
            }
            if(botcount>1) // if more than 1 bot, then its error
            {
                //throw an exception, this is a custom exception, hence create a exception package
                //InvalidBotCountException
                throw new IndexOutOfBoundsException("Bot count is > than 1");
            }
        }

        private void validateDimension()
        {
            //created custom exception InvalidDimensionException
            if(dimension<3 || dimension >10)
            {
                throw new InvalidDimensionException("dimension should be >3 and <10");
            }
        }

        private void validateNumbersOfPlayers()
        {
            if(players.size()!=(dimension-1))
            {
                throw new InvalidPlayersCountException("Players count should be dimension-1");
            }
        }

        //validate whether 2 playes are holding the same symbol
        private void validateUniqueSymbolOfAllPlayers() throws DuplicateSymbolException {
            //player class will have symbol as character
            //take all the char:symbol in hashset

            HashSet<Character> hashSet=new HashSet<>();
            for(Player player:players) // iterate the players which holds the symbol within
            {
                hashSet.add(player.getSymbol().getSymbolchar());
            }

            if(hashSet.size()!=players.size())
            {
                throw new DuplicateSymbolException("two players should not holding the same symbol");
            }
        }

        //call all the validate methods
        private void validate()
        {
            validateBotCounts();
            validateDimension();
            validateNumbersOfPlayers();
            validateUniqueSymbolOfAllPlayers();
        }

        //builder will build the game with the below method
        private Game build()
        {
            validate();
            return new Game(players, new Board(dimension),winningStrategies);
        }
    }
}
