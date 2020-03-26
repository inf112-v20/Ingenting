package inf112.ingenting.roborally;

import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.cards.ProgrammingCard;
import inf112.ingenting.roborally.cards.ProgrammingCardType;
import inf112.ingenting.roborally.player.Robot;
import inf112.ingenting.roborally.player.RobotDirection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlagTest {
    Board board;
    Robot robot;
    Vector2 startPosition;
    TiledMap map;
    TiledMapTileSet tileSet;
    TiledMapTileLayer layer;
    TiledMapTileLayer.Cell flag1;
    TiledMapTileLayer.Cell flag2;
    TiledMapTileLayer.Cell flag3;
    TiledMapTileLayer.Cell flag4;


    @Before
    public void setup() {
        map = new TiledMap();
        board = new Board();
        tileSet = map.getTileSets().getTileSet("tileMap");
        flag1 = new TiledMapTileLayer.Cell();
        flag2 = new TiledMapTileLayer.Cell();
        flag3 = new TiledMapTileLayer.Cell();
        flag4 = new TiledMapTileLayer.Cell();
        flag1.setTile(tileSet.getTile(55));
        flag2.setTile(tileSet.getTile(63));
        flag3.setTile(tileSet.getTile(71));
        flag4.setTile(tileSet.getTile(79));

        startPosition = new Vector2(0, 0);
        robot = new Robot(startPosition);
        board.addRobot(robot);
    }

    @Test
    public void walkOnFlag1() {
        robot.setDirection(RobotDirection.NORTH);
        robot.registerMove(new ProgrammingCard(ProgrammingCardType.MOVE_1));
        board.moveRobots();

        Assert.assertEquals(true, robot.hasVisitedFlag1());
    }

}
