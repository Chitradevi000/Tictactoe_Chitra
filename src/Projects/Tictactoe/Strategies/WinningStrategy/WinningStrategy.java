package Projects.Tictactoe.Strategies.WinningStrategy;

import Projects.Tictactoe.models.Board;
import Projects.Tictactoe.models.Move;
import Projects.Tictactoe.models.Player;

public interface WinningStrategy {
    Player checkWinner(Board board, Move lastMove);
}
