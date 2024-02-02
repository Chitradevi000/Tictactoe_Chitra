package Projects.Tictactoe.Strategies.BotPLayingStrategy;

import Projects.Tictactoe.models.Board;
import Projects.Tictactoe.models.Move;

public interface BotPlayingStrategy {
    Move makemove(Board board);
}
