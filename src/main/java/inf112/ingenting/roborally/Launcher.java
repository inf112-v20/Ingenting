package inf112.ingenting.roborally;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import inf112.ingenting.roborally.board.Board;
import inf112.ingenting.roborally.gui.GameConsole;
import inf112.ingenting.roborally.player.Robot;

public class Launcher extends ApplicationAdapter {
	private OrthographicCamera camera;
	private Robot robot;
	private Board board;
	private GameConsole gameConsole;

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 12, 18);
		camera.zoom = 1f;
		camera.position.set(camera.position.x, camera.position.y, 0);
		camera.update();
		board = new Board("testMap.tmx", (float) 1 / 64, camera);
		gameConsole = GameConsole.getInstance();

		robot = new Robot("player_1.png", new Vector2(5f, 5f));
		board.addRobot(robot);

	}

	@Override
	public void resize(int width, int height) {
		gameConsole.refresh();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		board.render();
		gameConsole.render();
        board.moveRobotKey(robot);
	}

	@Override
	public void dispose() {
		board.dispose();
		gameConsole.dispose();
	}
}
