package inf112.ingenting.roborally.util;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;

// Stolen from https://github.com/TomGrill/gdx-testing/blob/master/tests/src/de/tomgrill/gdxtesting/GdxTestRunner.java

/**
 * Class for initializing LibGDX systems and running tests.
 *
 * Stolen from Tom Grill
 *
 * @see <a href="https://github.com/TomGrill/gdx-testing">de.tomgrill.gdxtesting</a>
 * @see <a href="https://github.com/TomGrill/gdx-testing/blob/master/tests/src/de/tomgrill/gdxtesting/GdxTestRunner.java">de.tomgrill.gdxtesting.GdxTestRunner</a>
 */
public class GdxTestRunner extends BlockJUnit4ClassRunner implements ApplicationListener {
	private Map<FrameworkMethod, RunNotifier> invokeInRender = new HashMap<>();

	public GdxTestRunner(Class<?> c) throws InitializationError {
		super(c);

		HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();

		new HeadlessApplication(this, config);
		Gdx.gl = mock(GL20.class);
	}

	@Override
	public void create() {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {
		synchronized (invokeInRender) {
			for (Map.Entry<FrameworkMethod, RunNotifier> each : invokeInRender.entrySet()) {
				super.runChild(each.getKey(), each.getValue());
			}
			invokeInRender.clear();
		}
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
	}

	@Override
	protected void runChild(FrameworkMethod method, RunNotifier notifier) {
		synchronized (invokeInRender) {
			invokeInRender.put(method, notifier);
		}
		waitUntilInvokedInRenderMethod();
	}

	private void waitUntilInvokedInRenderMethod() {
		try {
			while (true) {
				Thread.sleep(10);
				synchronized (invokeInRender) {
					if (invokeInRender.isEmpty())
						break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
