package fil.coo;

import plugin.Plugin;

public class DummyPlugin implements Plugin {
    @Override
    public String transform(String source) {
        return null;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public String helpMessage() {
        return null;
    }
}
