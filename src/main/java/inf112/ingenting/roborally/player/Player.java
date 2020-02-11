package inf112.ingenting.roborally.player;

import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.cards.CardType;

import java.util.ArrayList;

public class Player {
    private Robot[] robots = new Robot[3];
    private ArrayList<CardType> cards = new ArrayList<CardType>();
    private Robot currentRobot;
    private Board board;

    public Player(Board board){
        this.board = board;
        for(int i = 0; i < robots.length; i++){
            robots[i] = new Robot();
        }
        currentRobot = robots[0];
        currentRobot.setCell(board.getTile(0, 0).get(1));

        cards.add(CardType.MOVE_1_P1);
        cards.add(CardType.MOVE_1_P1);
        cards.add(CardType.ROTATE_RIGHT_P1);
        cards.add(CardType.MOVE_1_P1);
    }

    public Robot getCurrentRobot() {
        return currentRobot;
    }

    public ArrayList<CardType> getCards() {
        return cards;
    }

    public Robot[] getRobots() {
        return robots;
    }

    public void executeProgram(Board board) {
        for (int i = 0; i < getCards().size() ; i++) {
                currentRobot.move(getCards().get(i), board);
                cards.remove(getCards().get(i));
                board.render();
        }
    }
}
