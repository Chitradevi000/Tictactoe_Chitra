package Projects.Tictactoe.Strategies.WinningStrategy;

import Projects.Tictactoe.models.Board;
import Projects.Tictactoe.models.Player;

public interface WinningStrategy {
    Player checkwinner(Board board);
}
