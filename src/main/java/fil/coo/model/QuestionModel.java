package fil.coo.model;

public abstract class QuestionModel {
    public abstract AnswerModel getAnswer();

    public abstract String getQuestionText();

    public abstract int getNbPts();

}
