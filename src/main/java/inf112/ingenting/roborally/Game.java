package inf112.ingenting.roborally;

import com.badlogic.gdx.utils.Timer;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.player.Player;

public class Game {
    private Board board;        // Game board.
    private Player[] players;   // Active players in game.

    public Game(Board board, Player[] players){
        this.board = board;
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void round(){
        board.render();
        // TODO: Add round logic.
        board.render();
    }

}
