package fil.coo;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class Quiz {

    List<Question> questions;
    final static Logger logger = Logger.getLogger(Quiz.class);

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

    public void ask(int i){
    	String question = questions.get(i).getQuestionText();
    	logger.info(question);
    }
    
    /**
     * Method to ask all the question present in the list
     */
    public void askAll(){   }

}
