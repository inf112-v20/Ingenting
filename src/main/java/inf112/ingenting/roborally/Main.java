package inf112.ingenting.roborally;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "RoboRally la Ingenting";
        cfg.width = 800;
        cfg.height = 800;
        new LwjglApplication(new Launcher(), cfg);
    }
}