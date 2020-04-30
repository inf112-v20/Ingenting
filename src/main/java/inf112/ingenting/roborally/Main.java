package inf112.ingenting.roborally;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "RoboRally - Ingenting";
        config.width = 1600;
        config.height = 800;
        new LwjglApplication(new RoboRally(), config);
    }
}