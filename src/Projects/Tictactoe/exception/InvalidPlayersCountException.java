package Projects.Tictactoe.exception;

public class InvalidPlayersCountException implements RuntimeException{
    public InvalidPlayersCountException(String message)
    {
        super(message);
    }
}
