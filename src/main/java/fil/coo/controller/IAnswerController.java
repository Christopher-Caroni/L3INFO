package fil.coo.controller;

public interface IAnswerController {

    /**
     * Immediately calls the model to validate the user input for this answer
     *
     * @param input the user's input
     */
    void onInputFinished(String input);

}
