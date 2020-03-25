package inf112.ingenting.roborally;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import inf112.ingenting.roborally.player.Robot;

public class Launcher extends ApplicationAdapter {
	private OrthographicCamera camera;
	private Game game;


	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 12, 18);
		camera.zoom = 1f;
		camera.position.set(camera.position.x, camera.position.y, 0);
		camera.update();
		game = new Game(1, camera);
	}

	@Override
	public void resize(int width, int height) {
		game.refresh();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		board.render();
		gameConsole.draw();

		// Visual test to see if robot moves
        deltaTime = Gdx.graphics.getDeltaTime();
        if (moveRobotExample > 2) {
            moveRobotExample = 0;
            ProgrammingCard test = new ProgrammingCard();
            //ProgrammingCard first = new ProgrammingCard(ProgrammingCardType.MOVE_3);
            //robot.registerMove(test);
            //board.moveRobots();
            //System.out.println("Moving: " + test.getCardType());
        } else
            moveRobotExample += deltaTime;
        board.moveRobotKey(robot);
	}

	@Override
	public void dispose() {
		game.dispose();
	}
}
