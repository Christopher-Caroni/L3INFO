package fil.coo;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public abstract class QuizTest {

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            getLogger().debug("Starting test: " + description.getMethodName() + "() for " + QuizTest.this.getClass().getSimpleName());
        }

        @Override
        protected void succeeded(Description description) {
            getLogger().debug("SUCCESS: " + description.getMethodName());
        }

        @Override
        protected void failed(Throwable e, Description description) {
            getLogger().debug("FAIL: " + description.getMethodName());
        }

        @Override
        protected void finished(Description description) {
            getLogger().debug("finished test: " + description.getMethodName() + "\n");
        }
    };

    protected abstract Logger getLogger();
}
