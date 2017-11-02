package fil.coo;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    List<Question> questions;

    public Quiz(){
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void askAll(){   }

}
