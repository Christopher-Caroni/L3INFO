package fil.coo;

import java.io.*;

public class QuestionFactory {

    /**
     * Method to create one question
     * @param text String, the question text
     * @param answer String, the answer text
     * @param points String, the number of points text
     * @return Question
     * @throws IOException
     */
    public Question createQuestion(String text, String answer, String points)
            throws IOException {
        try {
            int nbPoints = Integer.parseInt(points);
            return new Question(text, AnswerFactory.FACTORYANSWER.buildAnswer(answer), nbPoints);
        } catch (NumberFormatException e) {
            throw new IOException("bad format");
        }
    }

    /**
     * Method to create the quiz with a file text. Create all the questions and add into the quiz.
     * @param fileName String
     * @return Quiz
     * @throws IOException
     */
    public Quiz createQuestionnaire(String fileName) throws IOException {
        Quiz questionnaire = new Quiz();
        File source = new File(fileName);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(source));
            String text;
            // read block of 3 li n e s : text , answer and number of points
            while ((text = in.readLine()) != null) {
                String answer = in.readLine();
                String nbPoints = in.readLine();
                if (answer == null || nbPoints == null ){
                    throw new IOException("bad format");
                }
                questionnaire.addQuestion(this.createQuestion(text, answer, nbPoints));
            }
        } catch (FileNotFoundException e) {
            throw new IOException(e);
        }
        finally {
            in.close();
        }
        return questionnaire;
    }
}



