package Projects.Tictactoe.models;

public class Bot extends Player{

        private BotDifficultyLevel botDifficultyLevel;
        private BotPlayingStrategy botPlayingStrategy;

        //super constructor which we dont need this
//    public Bot(Long id, String name, Symbol symbol, PlayerType playerType) {
//        super(id, name, symbol, playerType);
//    }

    //constructor created with this class attri,
    //this is for player type bot changed in super constructor attri

    public Bot(Long id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel, BotPlayingStrategy botPlayingStrategy) {
        super(id, name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;

    }

    public Move makeMove(Board board) //move of a bot
    {
        Move move=botPlayingStrategy.makeMove(board); //move cell
        move.setPlayer(this); //player's move
        return move;

    }


    //getter and setter

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }

    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }



}
