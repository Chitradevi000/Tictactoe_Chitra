package Projects.Tictactoe.Strategies.BotPLayingStrategy;

import Projects.Tictactoe.models.*;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{


    @Override
    public Move makeMove(Player player,Board board) {
       //we gonna get the empty cell(ramdom) and make a bot move
        for(int i=0;i<board.getSize();i++)
        {
            for(int j=0;j< board.getSize();j++)
            {
                if(board.getBoardofcells().get(i).get(j).getCellstate().equals(Cellstate.EMPTY))
                    return new Move(new Cell(i,j),player);
            }
        }
        return null;
    }
}
