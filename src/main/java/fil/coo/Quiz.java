package fil.coo;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    List<Question> questions;

    public Quiz(){
        questions = new ArrayList<>();
    }

    /**
     * Method to add a question into the List of questions
     * @param question Question
     */
    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * Method to ask all the question present in the list
     */
    public void askAll(){   }

}
