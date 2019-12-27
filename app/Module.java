import com.google.inject.AbstractModule;
import utils.AtomicCounter;
import utils.Counter;

public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(Counter.class).to(AtomicCounter.class);
    }
}
