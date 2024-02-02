package Projects.Tictactoe.models;

import java.security.PrivateKey;
import java.util.Scanner;

public class Player {
    private Long id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    private Scanner scanner;

    public Player(Long id, String name, Symbol symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    //player has to decide the move

    public Move makeMove(Board board)
    {
        System.out.println("Please enter the row for the move :");
        int row=scanner.nextInt();
        System.out.println("Please enter the Col for the move :");
        int col=scanner.nextInt();

        //TODO: validate the move and throw exception
        //what need to validate
        //1. you cant make a move to cellstate which is filled or blocked
        //2. you cant make move beyond the boundary
        //3.
        //homework

        //return a Move
        Cell cell=new Cell(row,col,this);// cells construtor with player - public Cell(int row, int col,Player player)
        return new Move(cell,this);

    }
}
