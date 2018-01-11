package fil.coo;

import plugin.Plugin;

public class DummyPlugin implements Plugin {
    @Override
    public String transform(String source) {
        return source;
    }

    @Override
    public String getLabel() {
        return "Dummy Plugin";
    }

    @Override
    public String helpMessage() {
        return "Does not do anything";
    }
}
