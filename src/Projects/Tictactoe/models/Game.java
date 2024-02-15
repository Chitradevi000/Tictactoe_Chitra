package Projects.Tictactoe.models;

import Projects.Tictactoe.Strategies.WinningStrategy.WinningStrategy;
import Projects.Tictactoe.exception.DuplicateSymbolException;
import Projects.Tictactoe.exception.InvalidDimensionException;
import Projects.Tictactoe.exception.InvalidPlayersCountException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameStatus gamestate;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

    private Game(List<Player> players, Board board,List<WinningStrategy> winningStrategies) {
        //so whenever you create game in controller, you need to pass list of players , board
        //dimension , winning strategies
        this.players=players;
        this.board = board;
        this.moves = new ArrayList<Move>();
//        this.winner = winner;
        this.gamestate = GameStatus.IN_PROGRESS;
        this.nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }

    //getters of Game attri

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Player getWinner() {
        return winner;
    }

    public Projects.Tictactoe.models.GameStatus getGamestate() {
        return gamestate;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }


    //builder starts for validation
    //whatever the user input, you will take thru builder class and not thru directly

    public static Builder builder() //thru game , you can reach this builder method to build a game
            // check try block in controller
    {
        return new Builder();
    }


    public static class Builder
    {
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension;


        private Builder() {
            //in this constructor, im initialising with basic values
            this.players = new ArrayList<Player>();
            this.winningStrategies = new ArrayList<WinningStrategy>();
            this.dimension = 0;
        }

        //setter - all the setter returns Builder - concept of Builder pattern
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
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
        private void validate() throws DuplicateSymbolException {
            validateBotCounts();
            validateDimension();
            validateNumbersOfPlayers();
            validateUniqueSymbolOfAllPlayers();
        }

        //builder will build the game with the below method
        public Game build() throws DuplicateSymbolException {
            validate();
            return new Game(players, new Board(dimension),winningStrategies);
        }
    }
}
