package Projects.Tictactoe.Strategies.BotPLayingStrategy;

import Projects.Tictactoe.models.Board;
import Projects.Tictactoe.models.Move;
import Projects.Tictactoe.models.Player;

public interface BotPlayingStrategy {


//    Move makeMove(Board board);

    Move makeMove(Player player, Board board);
}
