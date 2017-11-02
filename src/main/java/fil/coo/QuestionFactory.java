package fil.coo;

import java.io.*;

public class QuestionFactory {

    public Question createQuestion(String text, String answer, String points)
            throws IOException {
        try {
            int nbPoints = Integer.parseInt(points);
            return new Question(text, AnswerFactory.FACTORYANSWER.buildAnswer(answer), nbPoints);
        } catch (NumberFormatException e) {
            throw new IOException("bad format");
        }
    }

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



