package fil.coo.model;

public interface QuestionModel {

    AnswerModel getAnswer();

    String getQuestionText();

    int getNbPts();

    /**
     * Asks this question
     */
    int ask();
}
