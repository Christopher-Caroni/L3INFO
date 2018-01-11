package plugin;

public interface Plugin {

    /**
     * Applies the effect of this plugin to source and returns the result
     * @param source the source text
     * @return the text with the effect
     */
    public String transform(String source);

    /**
     *
     * @return the label of this plugin
     */
    public String getLabel();

    /**
     *
     * @return a message indicating how to use this plugin
     */
    public String helpMessage();

}